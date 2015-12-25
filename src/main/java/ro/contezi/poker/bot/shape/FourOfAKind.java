package ro.contezi.poker.bot.shape;

import java.util.Collection;

import ro.contezi.poker.bot.cards.Card;

public class FourOfAKind implements Shape {

	@Override
	public boolean matches(Collection<Card> hand) {
		return false;
	}

}
