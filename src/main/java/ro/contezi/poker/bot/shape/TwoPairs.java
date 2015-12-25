package ro.contezi.poker.bot.shape;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;

public class TwoPairs implements Shape {

	@Override
	public boolean matches(Collection<Card> hand) {
		if (hand.size() < 4) {
			return false;
		}
		List<Card> handToProcess = new ArrayList<>(hand);
		Collections.sort(handToProcess);
		if (new Pair().matches(handToProcess.subList(0, 2)) && new Pair().matches(handToProcess.subList(2, 4))) {
			return true;
		}
		for (int i = 0; i < hand.size(); i++) {
			handToProcess = new ArrayList<>(hand);
			handToProcess.remove(i);
			if (matches(handToProcess)) {
				return true;
			}
		}
		return false;
	}

}
