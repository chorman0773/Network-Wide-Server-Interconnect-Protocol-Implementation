package github.chorman0773.gac14.chatterbox.pkmcom;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import com.google.gson.JsonObject;

import github.chorman0773.gac14.chatterbox.Version;

public interface Hash {
	public static int hashcode(byte b) {
		return b;
	}
	public static int hashcode(short s) {
		return s;
	}
	public static int hashcodeUnsigned(byte b) {
		return b&0xff;
	}
	public static int hashcodeUnsigned(short s) {
		return s&0xffff;
	}
	public static int hashcode(int i) {
		return i;
	}
	public static int hashcodeUnsigned(int i) {
		return i;
	}
	public static int hashcode(long l) {
		return ((int)l)^(int)(l>>32);
	}
	public static int hashcode(UUID id) {
		return hashcode(id.getMostSignificantBits())*31+hashcode(id.getLeastSignificantBits());
	}
	public static int hashcode(String s) {
		int hash = 0;
		byte[] arr = s.getBytes(StandardCharsets.UTF_8);
		for(int i = 0;i<s.length();i++)
			hash = 31*hash+hashcodeUnsigned(arr[i]);
		return hash;
	}
	
	public static int hashcode(Version v) {
		return v.hashCode();
	}
	
	public static int hashcode(JsonObject o) {
		return hashcode(o.toString());
	}
}
