package com.gtm.collections.inte;

import java.util.Comparator;

public class ComparatorById implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Emp && o2 instanceof Emp) {
			Emp e1 = (Emp)o1;
			Emp e2 = (Emp)o2;
			if (e1.getId() > e2.getId()) {
				return 1;
			}else if(e1.getId() < e2.getId()) {
				return -1;
			}else{
				return 0;
			}
		}else if (o1 instanceof Stu && o2 instanceof Stu) {
			Stu s1 = (Stu)o1;
			Stu s2 = (Stu)o2;
			if (s1.getId() > s2.getId()) {
				return 1;
			}else if(s1.getId() < s2.getId()) {
				return -1;
			}else{
				return 0;
			}
		}else if (o1 instanceof Emp  && o2 instanceof Stu) {
			Emp s1 = (Emp)o1;
			Stu s2 = (Stu)o2;
			if (s1.getId() > s2.getId()) {
				return 1;
			}else if(s1.getId() < s2.getId()) {
				return -1;
			}else{
				return 0;
			}
		}else if (o2 instanceof Emp  && o1 instanceof Stu) {
			Emp s1 = (Emp)o2;
			Stu s2 = (Stu)o1;
			if (s1.getId() > s2.getId()) {
				return 1;
			}else if(s1.getId() < s2.getId()) {
				return -1;
			}else{
				return 0;
			}
		}
		return 0;
	}




}
