package ro.contezi.poker.bot.shape;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;

public class Pair implements Shape {

	@Override
	public boolean applies(Collection<Card> hand) {
		if (hand.size() < 2) {
			return false;
		}
		List<Card> handToProcess = new ArrayList<>(hand);
		return handToProcess.get(0).equals(handToProcess.get(1));
	}

}
