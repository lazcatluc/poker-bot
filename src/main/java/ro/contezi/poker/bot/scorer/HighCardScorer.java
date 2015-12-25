package ro.contezi.poker.bot.scorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;

public class HighCardScorer implements Comparator<Collection<Card>> {

	@Override
	public int compare(Collection<Card> o1, Collection<Card> o2) {
		List<Card> first = new ArrayList<>(o1);
		List<Card> second = new ArrayList<>(o2);
		Collections.sort(first);
		Collections.sort(second);
		int pos = 0;
		while (pos < first.size()) {
			int diff = first.get(pos).getRank().compareTo(second.get(pos).getRank());
			if (diff != 0) {
				return diff;
			}
			pos++;
		}
		return 0;
	}

}
