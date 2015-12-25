package ro.contezi.poker.bot.shape;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;

public class FullHouse implements Shape {

	@Override
	public boolean matches(Collection<Card> hand) {
		if (hand.size() < 5) {
			return false;
		}
		Set<Rank> foundRanks = new HashSet<>();
		hand.forEach(card -> foundRanks.add(card.getRank()));
		return foundRanks.size() == 2 && !new FourOfAKind().matches(hand);
	}

}
