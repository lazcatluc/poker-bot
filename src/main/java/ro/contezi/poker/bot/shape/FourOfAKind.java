package ro.contezi.poker.bot.shape;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;

public class FourOfAKind implements Shape {

	@Override
	public boolean matches(Collection<Card> hand) {
		if (hand.size() < 4) {
			return false;
		}
		List<Card> handToProcess = new ArrayList<>(hand);
		Collections.sort(handToProcess);
		for (int i = 0; i < hand.size() - 3; i++) {
			if (new ThreeOfAKind().matches(handToProcess.subList(i, i + 3)) && new Pair().matches(handToProcess.subList(i + 2, i + 4))) {
				return true;
			}
		}
		return false;
	}

}
