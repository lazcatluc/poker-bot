package ro.contezi.poker.bot.scorer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;

public class PairScorer implements Comparator<Collection<Card>> {

	@Override
	public int compare(Collection<Card> o1, Collection<Card> o2) {
		int score = new HighCardScorer().compare(getPair(o1), getPair(o2));
		if (score != 0) {
			return score;
		}
		return new HighCardScorer().compare(o1, o2);
	}

	protected Collection<Card> getPair(Collection<Card> o1) {
		List<Card> hand = new ArrayList<>(o1);
		Collections.sort(hand);
		for (int i = 0; i < hand.size() - 1; i++) {
			Card thisCard = hand.get(i);
			Card nextCard = hand.get(i+1);
			if (thisCard.getRank().equals(nextCard.getRank())) {
				return Arrays.asList(thisCard, nextCard);
			}
		}
		return Collections.emptyList();
	}

}
