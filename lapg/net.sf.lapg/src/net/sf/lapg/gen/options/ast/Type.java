package net.sf.lapg.gen.options.ast;

import net.sf.lapg.gen.options.OptdefTree.TextSource;

public class Type extends AstOptNode {

	private String identifier;

	public Type(String identifier, TextSource input, int start, int end) {
		super(input, start, end);
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}
}