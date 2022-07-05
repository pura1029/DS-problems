package com.gtm.wup;

import java.util.UUID;

public class IdGen {
	private static UUID uuid = new UUID(9999, 0);

	public static String genId(){
		uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
