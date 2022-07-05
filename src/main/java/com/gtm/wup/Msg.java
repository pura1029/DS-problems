package com.gtm.wup;

public class Msg {

	String id;
	String userId;

	public Msg() {
		if(this.id == null){
			this.id = IdGen.genId();
		}
	}
}
