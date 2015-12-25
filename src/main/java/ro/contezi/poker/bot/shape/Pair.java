package ro.contezi.poker.bot.shape;

import java.util.Collection;

import ro.contezi.poker.bot.cards.Card;

public class Pair implements Shape {

	@Override
	public boolean applies(Collection<Card> hand) {
		if (hand.size() < 2) {
			return false;
		}
		return true;
	}

}
