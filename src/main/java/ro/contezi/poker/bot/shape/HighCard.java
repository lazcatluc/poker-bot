package ro.contezi.poker.bot.shape;

import java.util.Collection;

import ro.contezi.poker.bot.cards.Card;

public class HighCard implements Shape {

	@Override
	public boolean matches(Collection<Card> hand) {
		return true;
	}

}
