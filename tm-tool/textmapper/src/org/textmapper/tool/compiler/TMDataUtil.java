/**
 * Copyright 2002-2013 Evgeny Gryaznov
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
package org.textmapper.tool.compiler;

import org.textmapper.lapg.api.LexerRule;
import org.textmapper.lapg.api.Nonterminal;
import org.textmapper.lapg.api.Symbol;
import org.textmapper.lapg.api.UserDataHolder;
import org.textmapper.lapg.api.rule.RhsSymbol;
import org.textmapper.tool.parser.ast.TmaCommand;

import java.util.Map;

/**
 * evgeny, 1/15/13
 */
public class TMDataUtil {

	private static final String UD_CODE = "code";
	private static final String UD_ANNOTATIONS = "annotations";
	private static final String UD_IDENTIFIER = "id";
	private static final String UD_TRANSITIONMAP = "transitionMap";
	private static final String UD_CUSTOM_TYPE = "customType";
	private static final String UD_TYPE_HINT = "typeHint";
	private static final String UD_LITERAL = "literal";

	public static void putAnnotations(UserDataHolder element, Map<String, Object> annotations) {
		element.putUserData(UD_ANNOTATIONS, annotations);
	}

	public static Map<String, Object> getAnnotations(UserDataHolder element) {
		return (Map<String, Object>) element.getUserData(UD_ANNOTATIONS);
	}

	public static void putCode(UserDataHolder element, TmaCommand code) {
		element.putUserData(UD_CODE, code);
	}

	public static TmaCommand getCode(UserDataHolder element) {
		return (TmaCommand) element.getUserData(UD_CODE);
	}

	public static void putId(Symbol element, String identifier) {
		element.putUserData(UD_IDENTIFIER, identifier);
	}

	public static String getId(Symbol element) {
		return (String) element.getUserData(UD_IDENTIFIER);
	}

	public static void putCustomType(Nonterminal element, Nonterminal type) {
		element.putUserData(UD_CUSTOM_TYPE, type);
	}

	public static Nonterminal getCustomType(Nonterminal element) {
		return (Nonterminal) element.getUserData(UD_CUSTOM_TYPE);
	}

	public static void putTypeHint(Nonterminal element, TMTypeHint hint) {
		element.putUserData(UD_TYPE_HINT, hint);
	}

	public static TMTypeHint getTypeHint(Nonterminal element) {
		return (TMTypeHint) element.getUserData(UD_TYPE_HINT);
	}

	public static void putTransition(LexerRule rule, TMStateTransitionSwitch transitionSwitch) {
		rule.putUserData(UD_TRANSITIONMAP, transitionSwitch);
	}

	public static TMStateTransitionSwitch getTransition(LexerRule rule) {
		return (TMStateTransitionSwitch) rule.getUserData(UD_TRANSITIONMAP);
	}

	public static RhsSymbol getRewrittenTo(RhsSymbol source) {
		return (RhsSymbol) source.getUserData(RhsSymbol.UD_REWRITTEN);
	}

	public static void putLiteral(RhsSymbol rhsSym, Object literal) {
		assert literal instanceof String || literal instanceof Boolean || literal instanceof Integer;
		rhsSym.putUserData(UD_LITERAL, literal);
	}

	public static Object getLiteral(RhsSymbol rhsSym) {
		return rhsSym.getUserData(UD_LITERAL);
	}
}
