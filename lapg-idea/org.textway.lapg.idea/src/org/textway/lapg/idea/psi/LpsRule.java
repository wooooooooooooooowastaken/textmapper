/**
 * Copyright (c) 2010-2011 Evgeny Gryaznov
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package org.textway.lapg.idea.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.textway.lapg.idea.parser.LapgElementTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Gryaznov Evgeny, 1/26/11
 */
public class LpsRule extends LpsElement {

	public LpsRule(@NotNull ASTNode node) {
		super(node);
	}

	public LpsReference[] getRuleRefs() {
		final ASTNode[] nodes = getNode().getChildren(TokenSet.create(LapgElementTypes.REFERENCE));
		List<LpsReference> result = new ArrayList<LpsReference>(nodes.length);
		for (ASTNode node : nodes) {
			result.add((LpsReference) node.getPsi());
		}
		return result.toArray(new LpsReference[result.size()]);
	}

}