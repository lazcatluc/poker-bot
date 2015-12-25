package ro.contezi.poker.bot.scorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.shape.Pair;

public class FullHouseScorer implements Comparator<Collection<Card>> {

	@Override
	public int compare(Collection<Card> o1, Collection<Card> o2) {
		return getThreeOfAKindRank(o1).compareTo(getThreeOfAKindRank(o2));
	}

	private Rank getThreeOfAKindRank(Collection<Card> fullHouse) {
		List<Card> hand = new ArrayList<>(fullHouse);
		Collections.sort(hand);
		for (int i = 0; i < fullHouse.size() - 2; i++) {
			if (new Pair().matches(hand.subList(i, i + 2)) && new Pair().matches(hand.subList(i + 1, i + 3))) {
				return hand.get(i).getRank();
			}
		}
		throw new IllegalStateException("Not a full house hand");
	}
}
