package com.gtm.ds.inttest.ifelse.strategy.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StrategyConditionFactory {
	private Map<String, Strategy> conditions = new HashMap<>();

	public StrategyConditionFactory() {
		conditions.put("conditionOne", new ConditionOneStrategy());
		conditions.put("conditionTwo", new ConditionTwoStrategy());
		// It is better to call else condition on purpose than to have it in the
		// conditional method
		conditions.put("conditionElse", new ElseStrategy());
		// ...
	}

	public Optional<Strategy> getStrategy(String condition) {
		return Optional.ofNullable(conditions.get(condition));
	}
}