package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;
import java.util.List;

public class PatternSet {
	private static List<Pattern> patterns;

	private PatternSet() {
	}

	public static List<Pattern> instance() {
		if (patterns == null)
			init();

		return patterns;
	}

	private static void init() {
		patterns = new ArrayList<>();

		patterns.add(new ThreeBlackCrows());
		patterns.add(new ThreeWhiteSoldiers());
	}
}
