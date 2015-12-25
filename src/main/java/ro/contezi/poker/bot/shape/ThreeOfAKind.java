package ro.contezi.poker.bot.shape;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;

public class ThreeOfAKind implements Shape {

	@Override
	public boolean applies(Collection<Card> hand) {
		if (hand.size() < 3) {
			return false;
		}
		List<Card> handToProcess = new ArrayList<>(hand);
		Collections.sort(handToProcess);
		for (int i = 0; i < hand.size() - 2; i++) {
			if (new Pair().applies(handToProcess.subList(i, i + 2)) && new Pair().applies(handToProcess.subList(i + 1, i + 3))) {
				return true;
			}
		}
		return false;
	}

}
