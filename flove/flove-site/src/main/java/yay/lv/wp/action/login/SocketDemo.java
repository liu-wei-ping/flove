/****/
package yay.lv.wp.action.login;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * @author liuwp
 * @date 2017年3月17日
 */
public class SocketDemo extends Thread {
	public static void main(final String[] args) {
		new SocketDemo().start();
	}

	@Override
	public void run() {
		// port参数表示服务器监听的端口号，从1-65535
		try {

			final ServerSocket serverSocket = new ServerSocket(23415);

			// while (true) { //
			// 由于可能当有多个客户端连接时，accept方法就会产生多个Socket对象，需加一个while循环监听来自客户端的连接
			// block，当没有客户端连接时，改主线程会一直阻塞等待连接，一直监听，直到有客户端连接才会执行
			final Socket socket = serverSocket.accept();// 侦听事务的连接，accept是一个阻塞的方法，会阻塞当前的main线程，并且返回的是一个Socket类型
			// 建立连接，表示serverSocket在监听，如果监听到有客户端连接则会调用accept方法，然后返回一个Socket，最后建立连接
			JOptionPane.showMessageDialog(null, "有客户端连接到了本机的12345端口");
			// 然后测试在浏览器中输入http://127.0.0.1:12345则会弹出相应有客户端连接的提示框，然后原来阻塞在accept方法那里就会往下执行

			// 将socket传递给另起的一个新的线程,即是socket通信的线程
			// new ChatSocket(socket).start();

			// }

		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
