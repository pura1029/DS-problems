package com.gtm.ds.inttest.ifelse.strategy.dp;

public abstract class Strategy {
	public abstract String getParameter();

	protected void apply() {
		someMethod();
	}

	private void someMethod() {
		System.out.println(this.getClass().getSimpleName() + "=" + getParameter());
	}
}