package ro.contezi.poker.bot.shape;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Suit;

public class Flush implements Shape {

	@Override
	public boolean matches(Collection<Card> hand) {
		if (hand.size() < 5) {
			return false;
		}
		Set<Suit> suits = new HashSet<>();
		hand.forEach(card -> suits.add(card.getSuit()));
		return suits.size() == 1;
	}

}
