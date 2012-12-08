/**
 * Copyright 2002-2012 Evgeny Gryaznov
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
package org.textmapper.lapg.builder;

import org.textmapper.lapg.api.SourceElement;
import org.textmapper.lapg.api.rule.RhsPart;
import org.textmapper.lapg.api.rule.RhsSymbol;
import org.textmapper.lapg.api.rule.RhsUnordered;

import java.util.ArrayList;
import java.util.List;

/**
 * evgeny, 12/5/12
 */
class LiRhsUnordered extends LiRhsPart implements RhsUnordered {

	private final LiRhsPart[] parts;

	LiRhsUnordered(LiRhsPart[] parts, SourceElement origin) {
		super(origin);
		this.parts = parts;
	}

	@Override
	public RhsPart[] getParts() {
		return parts;
	}

	@Override
	List<RhsSymbol[]> expand() {
		List<RhsSymbol[]> result = new ArrayList<RhsSymbol[]>();
		int[] permutation = new int[parts.length];
		for (int i = 0; i < permutation.length; i++) {
			permutation[i] = i;
		}
		LiRhsPart[] temp = new LiRhsPart[parts.length];
		do {
			for (int i = 0; i < parts.length; i++) {
				temp[i] = parts[permutation[i]];
			}
			result.addAll(LiRhsSequence.expandList(temp));
		} while (permute(permutation));
		return result;
	}

	static boolean permute(int[] a) {
		int k = a.length - 2;
		while (k >= 0 && a[k] >= a[k + 1]) {
			k--;
		}
		if (k == -1) {
			return false;
		}
		int l = a.length - 1;
		while (a[k] >= a[l]) {
			l--;
		}
		int t = a[k];
		a[k] = a[l];
		a[l] = t;
		for (int i = k + 1, j = a.length - 1; i < j; i++, j--) {
			t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
		return true;
	}
}
