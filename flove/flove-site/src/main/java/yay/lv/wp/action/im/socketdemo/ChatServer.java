/****/
package yay.lv.wp.action.im.socketdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author liuwp
 * @date 2017年4月13日
 */
public class ChatServer {
	public static void main(final String[] args) {
		new ChatServer().service();
	}

	private int port = 8189;// 默认服务器端口

	public ChatServer() {
	}

	// 创建指定端口的服务器
	public ChatServer(final int port) {
		this.port = port;
	}

	// 提供服务
	public void service() {
		try {// 建立服务器连接
			final ServerSocket server = new ServerSocket(port);
			// 等待客户连接
			final Socket socket = server.accept();
			// System.out.println("有客服的连接上线了......");
			try {
				// 读取客户端传过来信息的DataInputStream
				final DataInputStream in = new DataInputStream(
						socket.getInputStream());
				// 向客户端发送信息的DataOutputStream
				final DataOutputStream out = new DataOutputStream(
						socket.getOutputStream());
				// 获取控制台输入的Scanner
				final Scanner scanner = new Scanner(System.in);
				while (true) {
					// 读取来自客户端的信息
					final String accpet = in.readUTF();
					System.out.println(accpet);
					final String send = scanner.nextLine();
					System.out.println("服务器：" + send);
					// 把服务器端的输入发给客户端
					out.writeUTF("服务器：" + send);
				}
			} finally {// 建立连接失败的话不会执行socket.close();
				socket.close();
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
