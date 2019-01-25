package com.ssafy;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;

public class ChatClient extends Frame implements ActionListener { 
	private static final long serialVersionUID = 2975049544012107087L;
	
	private TextArea ta;
	private TextField tf;
	private Button b1;
	private Button b2;
	private Panel p;
	private ChatConnect cc;
	
	public ChatClient(String ip, int port, String name){
		createGUI();
		cc = new ChatConnect(this, ip, port, name);
	}
	
	public void createGUI() {
		ta = new TextArea("", 40, 50, TextArea.SCROLLBARS_VERTICAL_ONLY);
		tf = new TextField(50);
		p = new Panel();
		b1 = new Button("SEND");
		b2 = new Button("EXIT");
		
		p.setLayout(new GridLayout(10, 1));
		Dimension d = b1.getMaximumSize();
		b2.setMaximumSize(d);
		p.add(b1);
		p.add(b2);
		
		ta.setEditable(false);
		ta.setBackground(new Color(204, 166, 166));
		
		add(ta, BorderLayout.CENTER);
		add(p, BorderLayout.LINE_END);
		add(tf, BorderLayout.SOUTH);
		
		setTitle("채팅 프로그램 입니다.");
		setSize(400, 500);
		setVisible(true);
		
		tf.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		tf.requestFocus();
	}
	
	public void show(String msg) {
		ta.append(msg);
	}
	
	public static void main(String[] args) {
		ChatClient cc = new ChatClient("192.168.208.84", 8000, "aa");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = tf.getText().trim();
		cc.send(msg);
		tf.setText("");
	}
}
