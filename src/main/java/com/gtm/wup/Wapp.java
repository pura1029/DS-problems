package com.gtm.wup;

import java.util.ArrayList;
import java.util.List;

public class Wapp {

	List<User> userList = new ArrayList<>();

	public Wapp() {
		User user1 = new User();
		user1.color = "G";
		User user2 = new User();
		user1.color = "G";
		User user3 = new User();
		user1.color = "G";
		User user4 = new User();
		user1.color = "G";
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
	}
	public void sendMsg(User user){
		
	}

	public void forwardMsg(Msg msg){
		User user = new User();
		user.msg = msg;
		msg.userId = user.userId;
		user.color = "W";
	}

	public static void main(String[] args) {
		User main = new User();
		Msg msg = new Msg();
		main.msg = msg;
		msg.userId = main.userId;
		main.color = "B";
		
	}
}
