package com.ssafy;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ChatServer{
	private ArrayList<User> users = new ArrayList<User>();
	
	private int port = 8000;
	
	public void go(){
		try{
			// 1. ServerSocket 생성
			ServerSocket ss = new ServerSocket(port);
			System.out.println("ServerSocket 생성 성공. port = " + port);
			while ( true ){
				// 2. Socket 생성: Client접속시
				Socket s = ss.accept();
				System.out.println("소켓 생성 성공");
				// 3. 각각 Client에 I/O Stream
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				ObjectOutputStream oos = new ObjectOutputStream(os);
				//4. Client정보 저장
				users.add(new User(s, ois, oos));
				// 5. 각각의 Client로 부터 입력을 담당하는 Thread생성
				Thread t = new ServerThread(ois);
				t.start();
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void broadcast(String msg) {
		for(User u : users) {
			ObjectOutputStream oos = u.getObjectOutputStream();
			try {
				oos.writeObject(msg);
			} catch(IOException e) {
				System.out.println(e);
			}
		}
	}
	
	public void removeClient( ObjectInputStream ois ) {
		for( User u :users){
			ObjectInputStream us = u.getObjectInputStream();
			if(ois == us){
				try{	
					us.close();
					u.getObjectOutputStream().close();
					u.getSocket().close();
				}catch( Exception e ) {}
				users.remove(u); 
				System.out.println("1 client exited !!");
			}
		}
	}
	
	public static void main(String [] args) throws IOException{
		new ChatServer().go();
	}
	
	class ServerThread extends Thread{
		
		private ObjectInputStream ois;
		
		public ServerThread(ObjectInputStream ois) {
			this.ois = ois;
		}
		
		public void run(){
			try {
				while(true){	
					String msg=(String) ois.readObject();
					broadcast(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			}		
			removeClient(ois);
		}
	}
}


class User {
	private Socket s;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public User(Socket s, ObjectInputStream ois, ObjectOutputStream oos) {
		this.s = s;
		this.ois = ois;
		this.oos = oos;
	}
	
	public Socket getSocket() {
		return s;
	}
	
	public ObjectInputStream getObjectInputStream() {
		return ois;
	}
	
	public ObjectOutputStream getObjectOutputStream() {
		return oos;
	}
}

