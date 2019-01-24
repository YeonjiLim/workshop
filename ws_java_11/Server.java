package com.ssafy.edu.java7;
import java.net.*;
import java.io.*;
import java.util.Vector;

public class Server{
	ServerSocket ss;
	Socket s;
	Vector<ServerThread> v;
	public Server(){
		v = new Vector(10,10); // 각각 capacity, increase 안쓰면 2씩증가고(default)
		// 10이면 10 20 30 40 이렇게 증가
	}
	public synchronized void addThread(ServerThread st){
		v.add(st);
	}
	public synchronized void removeThread(ServerThread st){
		v.remove(st);
	}
	// 몇번째꺼 가져올지 선택하는거 broadcast - 이건 synchronized꼭 해줘야함!
	// sendMessage 가 pw.println이니까 10명이면 10명을 보장ㅈ해줌
	public synchronized void broadcast(String str){
		for ( int i = 0 ; i < v.size() ; i++ ){
			ServerThread st1 = v.get(i); // casting
			st1.sendMessage(str);
		}
	}
	public void go(){
		try{
			ss = new ServerSocket(5432);
			ss.setReuseAddress(true);
			System.out.println("READY");
			while ( true ){
				s = ss.accept();
				ServerThread st = new ServerThread(this, s); // 여기서 this는 Server, 넣어준이유는 서버쓰레드엥서 서버 안에있는 멤버를 접근하고 싶어서 준것 
				// 이렇게 쓰면 public다 쓸수있음
				this.addThread(st); // 소켓들을 쓰레드에담고 그걸 synchronized 걸고 벡터로 묶은거
				// 소켓을 쓰레ㅇ드에 넣ㄱ 쓰레드르 ㄹ방에넣었으니 -> addThread, removeThread, broadcast(다음쓰레드받아오는거)
				st.start();
				// 스타트를한다 
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	public static void main(String [] args) throws IOException{
		Server server = new Server();
		server.go();
	}
}

class ServerThread extends Thread{
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	String str;
	Server server;

	public ServerThread(Server server,Socket s) throws IOException {
		this.server = server; // 서버와 (서버에 있는 방(Collection)을 사용하기위해서 생성자로 받아온다)
		this.s = s; // 소켓을 다 받아옴 (broadcast같은거 쓸라고) 
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
		System.out.println(s.getInetAddress()+"(이)가 접속했습니다");
	}
	public void sendMessage(String string){
		pw.println(string);
	}
	public void run(){
		try{
			while ( ( str = br.readLine() ) != null ){ // 키보드가아니라 소켓에서 읽어오는거라서
				server.broadcast(str); // 서버에있는 broadcast부름 
				// 아까는 println해서 그냥 하나만 가져왔는데 이번에는 왔다갔다 할수있음
				// 방을 접근할 수 있게 해준다. (아까 server class에서 this로 server를 파라메터로 받아왔으니까
				// 여러 쓰레드에서 공유하는거라서 synchronized해줘야하는것
			}
		}catch (IOException e){
			System.out.println(s.getInetAddress()+"의 연결이 종료되었습니다."); // 자기안에있던 애가 나가면
			server.removeThread(this); // 쓰레드제거
			try{
				s.close();
			}catch (IOException ie){ }
		}
	}
}
