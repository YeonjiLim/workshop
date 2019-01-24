package com.ssafy.edu.java7;
import java.net.*;
import java.io.*;

public class Client {
	Socket s;
	BufferedReader br, br1;
	PrintWriter pw;
	String str;
	public void go(){
		try{
			s = new Socket("192.168.208.85",5433);
			//키보드로 읽어서 소켓쓰는것
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
			
			// 안해도되는데 클라이언트 쓰레드 분리하려고 선언함
			ClientThread ct = new ClientThread(s);
			ct.start();

			while ( ( str = br.readLine() ) != null ){
				pw.println(str);
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	public static void main(String [] args){
		System.out.println("Client");
		Client c = new Client();
		c.go();
	}
}

class ClientThread extends Thread{
	Socket s;
	BufferedReader br1;		
	String str;
	public ClientThread(Socket s) throws IOException {
		this.s = s;
		// 소켓에서 읽는거 분리시킴
		br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	public void run(){
		try{
			while ( ( str = br1.readLine() ) != null){
				System.out.println(str);
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
}
	
