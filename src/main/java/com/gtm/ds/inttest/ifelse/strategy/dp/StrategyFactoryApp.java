package com.gtm.ds.inttest.ifelse.strategy.dp;

public class StrategyFactoryApp {

	private final StrategyConditionFactory strategyConditionFactory;

	public StrategyFactoryApp() {
		this.strategyConditionFactory = new StrategyConditionFactory();
	}

	public void decide(String someCondition) {

		Strategy strategy = strategyConditionFactory.getStrategy(someCondition).orElse(strategyConditionFactory
				.getStrategy("conditionElse").orElseThrow(() -> new IllegalArgumentException("Wrong condition")));
		strategy.apply();
	}

	public static void main(String[] args) {
		StrategyFactoryApp factoryApp = new StrategyFactoryApp();
		factoryApp.decide("conditionOne");
		factoryApp.decide("conditionTwo");
		factoryApp.decide("conditionElse");
	}
}
