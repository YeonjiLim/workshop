package com.ssafy.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Traversal {
	
	public static final String sign = "+-/*";
	public Node root;
	public int idx = 0;
	
	public void printPre(Node node) {
		if(node.preNode == null) {
			System.out.print(node.data + " ");
			return;
		}
		System.out.print(node.data + " ");
		printPre(node.preNode);
		printPre(node.nextNode);
	}
	
	public void printIn(Node node) {
		if(node.preNode == null) {
			System.out.print(node.data + " ");
			return;
		}
		printIn(node.preNode);
		System.out.print(node.data + " ");
		printIn(node.nextNode);
	}
	
	public void printPost(Node node) {
		if(node.preNode == null) {
			System.out.print(node.data + " ");
			return;
		}
		printPost(node.preNode);
		printPost(node.nextNode);
		System.out.print(node.data + " ");
	}
	
	public void makeTreePre(String s, Node node) {
		idx++;
		if(idx == s.length()) {
			return;
		}
		if(sign.contains(String.valueOf(node.data)) && node.preNode == null) {
			node.preNode = new Node(s.charAt(idx));
			makeTreePre(s, node.preNode);
		}
		if(sign.contains(String.valueOf(node.data)) && node.preNode != null) {
			node.nextNode = new Node(s.charAt(idx));
			makeTreePre(s, node.nextNode);
		}
	}
	
	public void makeTreePost(String s, Node node) {
		idx--;
		if(idx < 0) {
			return;
		}
		if(sign.contains(String.valueOf(node.data)) && node.nextNode == null) {
			node.nextNode = new Node(s.charAt(idx));
			makeTreePost(s, node.nextNode);
		}
		if(sign.contains(String.valueOf(node.data)) && node.nextNode != null) {
			node.preNode = new Node(s.charAt(idx));
			makeTreePost(s, node.preNode);
		}
	}
	
	public int priorty(char c) {
		if(c == '/' || c == '*') {
			return 2;
		} else {
			return 1;
		}
	}
	
	public String makePostOrder(String s) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(sign.contains(String.valueOf(s.charAt(i)))) {
				if(stack.isEmpty()) {
					stack.push(s.charAt(i));
				} else {
					if(priorty(stack.peek()) >= priorty(s.charAt(i))) {
						sb.append(stack.pop());
						stack.push(s.charAt(i));
					} 
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		//입력종류3가지
		if(sign.contains(String.valueOf(s.charAt(0)))){ // preorder
			idx = 0;
			root = new Node(s.charAt(0));
			makeTreePre(s, root);
		} else if (sign.contains(String.valueOf(s.charAt(s.length()-1)))) { // postorder
			idx = s.length()-1;
			root = new Node(s.charAt(s.length()-1));
			makeTreePost(s, root);
		} else { // inorder
			String str = makePostOrder(s);
			idx = str.length()-1;
			root = new Node(str.charAt(str.length()-1));
			makeTreePost(str, root);
		}
		
		System.out.println("PREORDER : ");
		printPre(root);
		System.out.println();
		System.out.println("INORDER : ");
		printIn(root);
		System.out.println();
		System.out.println("POSTORDER : ");
		printPost(root);
	}
	
	
	public static void main(String[] args) throws IOException {
		Traversal t = new Traversal();
		t.solve();
	}
	
	class Node {
		Node preNode;
		char data;
		Node nextNode;
		public Node(char data) {
			this.data = data;
			preNode = null;
			nextNode = null;
		}
	}
}
