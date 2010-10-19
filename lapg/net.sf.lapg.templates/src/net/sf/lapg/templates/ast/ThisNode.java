/**
 * Copyright 2002-2010 Evgeny Gryaznov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.lapg.templates.ast;

import net.sf.lapg.templates.api.EvaluationContext;
import net.sf.lapg.templates.api.IEvaluationStrategy;
import net.sf.lapg.templates.ast.AstTree.TextSource;

public class ThisNode extends ExpressionNode {

	protected ThisNode(TextSource source, int offset, int endoffset) {
		super(source, offset, endoffset);
	}

	@Override
	public Object evaluate(EvaluationContext context, IEvaluationStrategy env) {
		return context.getThisObject();
	}

	@Override
	public void toString(StringBuffer sb) {
		sb.append("self");
	}
}