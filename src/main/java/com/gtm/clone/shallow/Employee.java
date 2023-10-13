package com.gtm.clone.shallow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Cloneable {
	private int id;
	private String name;
	private Department department;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
