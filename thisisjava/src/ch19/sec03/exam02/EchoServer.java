package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	private static ServerSocket serverSocket = null;
	
	public static void main(String[] args) {
		System.out.println("--------------------------------------------------");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("--------------------------------------------------");
		
		startServer();
		
		Scanner scan = new Scanner(System.in);
		while (true) {
			String key = scan.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}
		scan.close();
		
		stopServer();
	}
	
	public static void startServer() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");
					
					while (true) {
						System.out.println("\n[서버] 연결 요청을 기다림\n");
						Socket socket = serverSocket.accept();
						
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버] " + isa.getHostString() + "의 연결 요청을 수락함");
						
						/*
						// 데이터 받기
						InputStream is = socket.getInputStream();
						byte[] bytes = new byte[1024];
						int readByteCount = is.read(bytes);
						String message = new String(bytes, 0, readByteCount, "UTF-8");
						
						// 데이터 보내기
						OutputStream os = socket.getOutputStream();
						bytes = message.getBytes("UTF-8");
						os.write(bytes);
						os.flush();
						System.out.println("[서버] 받은 데이터를 다시 보냄: " + message);
						*/
						
						// 데이터 받기
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String message = dis.readUTF();
						
						// 데이터 보내기
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(message);
						dos.flush();
						System.out.println("[서버] 받은 데이터를 다시 보냄: " + message);
						
						socket.close();
						System.out.println("[서버] " + isa.getHostString() + "의 연결을 끊음");
					}
				} catch (IOException e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		thread.start();
	}
	
	public static void stopServer() {
		try {
			serverSocket.close();
			System.out.println("[서버] 종료됨");
		} catch (IOException e) {
		}
	}

}

//public class EchoServer {
//	private static ServerSocket serverSocket = null;
//	private static ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//	public static void main(String[] args) {
//		System.out.println("--------------------------------------------------");
//		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
//		System.out.println("--------------------------------------------------");
//		
//		startServer();
//		
//		Scanner scan = new Scanner(System.in);
//		while (true) {
//			String key = scan.nextLine();
//			if (key.toLowerCase().equals("q")) {
//				break;
//			}
//		}
//		scan.close();
//		
//		stopServer();
//	}
//	
//	public static void startServer() {
//		Thread thread = new Thread() {
//			@Override
//			public void run() {
//				try {
//					serverSocket = new ServerSocket(50001);
//					System.out.println("[서버] 시작됨");
//					
//					while (true) {
//						Socket socket = serverSocket.accept();
//						
//						executorService.execute(() -> {
//							
//						try {
//							
//							InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
//							System.out.println("[서버] " + isa.getHostName() + "의 연결 요청을 수락함");
//							
//							DataInputStream dis = new DataInputStream(socket.getInputStream());
//							String message = dis.readUTF();
//							
//							DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//							dos.writeUTF(message);
//							dos.flush();
//							System.out.println("[서버] 받은 데이터를 다시 보냄: " + message);
//							
//							socket.close();
//							System.out.println("[서버] " + isa.getHostName() + "의 연결을 끊음\n");
//						} catch (IOException e) {
//						}
//					});
//				} 
//			} catch (IOException e) {
//				System.out.println("[서버] " + e.getMessage());
//			}
//		}
//	};
//		thread.start();
//	}
//	
//	public static void stopServer() {
//		try {
//			serverSocket.close();
//			executorService.shutdownNow();
//			System.out.println("[서버] 종료됨");
//		} catch (IOException e) {
//		}
//	}
//
//}
