package ro.contezi.poker.bot.shape;

import java.util.Collection;

import ro.contezi.poker.bot.cards.Card;

@FunctionalInterface
public interface Shape {
	boolean applies(Collection<Card> hand);
}
