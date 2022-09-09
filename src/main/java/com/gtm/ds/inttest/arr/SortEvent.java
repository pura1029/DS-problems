package com.gtm.ds.inttest.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvent {

	public static void main(String[] args) {
		List<Event> events = new ArrayList<>();
		events.add(new Event("kmn", "mnq", "12", EventType.valueOf("X")));
		events.add(new Event("gss", "xyz", "12", EventType.X));
		events.add(new Event("abc", "xyz", "12", EventType.G));

		Collections.sort(events);

		List<String> res = events.stream()
				.map(e -> e.teamName + " " + e.name + " " + e.date + " " + e.type + " " + e.name)
				.collect(Collectors.toList());
		System.out.println(res);
	}

	static class Event implements Comparable<Event> {
		String name;
		String teamName;
		String date;
		EventType type;

		public Event(String name, String teamName, String date, EventType type) {
			super();
			this.name = name;
			this.teamName = teamName;
			this.date = date;
			this.type = type;
		}

		@Override
		public int compareTo(Event o) {
			int cDate = this.date.compareTo(o.date);
			int cType = this.type.value - o.type.value;
			if (cDate == 0 && cType == 0) {
				int cName = this.name.compareTo(o.name);
				if (cName == 0) {
					return this.teamName.compareTo(o.teamName);
				}
				return cName;
			} else if (cDate == 0) {
				return cType;
			}
			return cDate;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((date == null) ? 0 : date.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Event other = (Event) obj;
			if (date == null) {
				if (other.date != null)
					return false;
			} else if (!date.equals(other.date))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (teamName == null) {
				if (other.teamName != null)
					return false;
			} else if (!teamName.equals(other.teamName))
				return false;
			if (type != other.type)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Event [name=" + name + ", teamName=" + teamName + ", date=" + date + ", type=" + type + "]";
		}
	}

	enum EventType {

		G(1), Y(2), X(3), S(4);

		Integer value;

		EventType(Integer value) {
			this.value = value;
		}
	}
}
