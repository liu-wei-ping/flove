/****/
package yay.lv.wp.action.im.socketdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author liuwp
 * @date 2017年4月13日
 */
public class ChatClient {
	public static void main(final String[] args) {
		new ChatClient().chat();
	}

	private String host = "localhost";// 默认连接到本机

	private int port = 8189;// 默认连接到端口8189

	public ChatClient() {

	}

	// 连接到指定的主机和端口
	public ChatClient(final String host, final int port) {
		this.host = host;
		this.port = port;
	}

	public void chat() {
		try {
			// 连接到服务器
			final Socket socket = new Socket(host, port);

			try {
				// 读取服务器端传过来信息的DataInputStream
				final DataInputStream in = new DataInputStream(
						socket.getInputStream());
				// 向服务器端发送信息的DataOutputStream
				final DataOutputStream out = new DataOutputStream(
						socket.getOutputStream());

				// 装饰标准输入流，用于从控制台输入
				final Scanner scanner = new Scanner(System.in);

				while (true) {
					final String send = scanner.nextLine();
					System.out.println("客户端：" + send);
					// 把从控制台得到的信息传送给服务器
					out.writeUTF("客户端：" + send);
					// 读取来自服务器的信息
					final String accpet = in.readUTF();
					System.out.println(accpet);
				}

			} finally {
				socket.close();
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
