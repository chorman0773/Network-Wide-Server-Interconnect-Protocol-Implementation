package github.chorman0773.gac14.hiveprotocol;

import java.time.Instant;
import java.util.UUID;

import com.google.gson.JsonObject;

import github.chorman0773.pokemonsms.net.multicast.NetHandlerMulticast;

public class HiveController {
	private NetHandlerMulticast handler;
	private UUID serverId;
	private ServerInfo info;
	
	static class ServerInfo{
		Instant lastHeard;
		Instant firstHeard;
		UUID id;
		JsonObject title;
		JsonObject motd;
		boolean isConnectable;
	}
	
	public HiveController() {
		// TODO Auto-generated constructor stub
	}

}
