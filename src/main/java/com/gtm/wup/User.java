package com.gtm.wup;

import java.util.ArrayList;
import java.util.List;

public class User {

	String userId;
	Msg msg;
	String color;
	List<User> userList = new ArrayList<>();
	User parent;
	public User() {
		this.userId = IdGen.genId();
		this.parent = null;
	}
}
