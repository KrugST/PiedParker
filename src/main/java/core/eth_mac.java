package core;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class eth_mac {

	public String mac() {
		InetAddress ip;
		String cama = null;
		StringBuilder sb = new StringBuilder();

		try {
			ip = InetAddress.getLocalHost();
			// System.out.println("Current IP address : " +
			// ip.getHostAddress());
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			byte[] mkc = network.getHardwareAddress();
			for (int i = 0; i < mkc.length; i++) {
				sb.append(String.format("%02X%s", mkc[i], (i < mkc.length - 1) ? "" : ""));
			} // End for
			cama = sb.toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return cama;//
	} // End main
} // end class
