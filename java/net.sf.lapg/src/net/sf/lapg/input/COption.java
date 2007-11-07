package net.sf.lapg.input;

import net.sf.lapg.templates.api.ILocatedEntity;

public class COption implements ILocatedEntity {

	private String name;
	private Object value;
	private int line;

	public COption(String myName, Object myValue, int line) {
		this.name = myName;
		this.value = myValue;
		this.line = line;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public String getLocation() {
		return "line:" + line;
	}
}
