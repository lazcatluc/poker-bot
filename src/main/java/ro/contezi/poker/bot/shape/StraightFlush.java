package ro.contezi.poker.bot.shape;

import java.util.Collection;

import ro.contezi.poker.bot.cards.Card;

public class StraightFlush implements Shape {

	@Override
	public boolean matches(Collection<Card> hand) {
		return new Straight().matches(hand) && new Flush().matches(hand);
	}

}
