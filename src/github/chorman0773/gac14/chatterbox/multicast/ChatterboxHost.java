package github.chorman0773.gac14.chatterbox.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.ByteBuffer;

public class ChatterboxHost {
	private MulticastSocket sock;
	public ChatterboxHost(int port) throws IOException {
		sock = new MulticastSocket(port);
		sock.setTimeToLive(255);
		sock.setLoopbackMode(true);
		sock.joinGroup(InetAddress.getByName("224.0.0.1"));
	}
	
	
	public ByteBuffer pull() throws IOException{
		ByteBuffer buff = ByteBuffer.allocate(16777215);
		DatagramPacket pack = new DatagramPacket(buff.array(),16777215);
		sock.receive(pack);
		buff.position(0);
		buff.limit(pack.getLength());
		return buff;
	}
	
	public void push(ByteBuffer buff) throws IOException {
		DatagramPacket pack = new DatagramPacket(buff.array(),buff.limit());
		sock.send(pack);
	}

}
