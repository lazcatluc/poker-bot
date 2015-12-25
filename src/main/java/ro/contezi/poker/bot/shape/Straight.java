package ro.contezi.poker.bot.shape;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;

public class Straight implements Shape {

	@Override
	public boolean matches(Collection<Card> hand) {
		if (hand.size() < 5) {
			return false;
		}
		List<Card> handToProcess = new ArrayList<>(hand);
		Collections.sort(handToProcess);
		for (int i = 0; i < hand.size() - 1; i++) {
			if (handToProcess.get(i + 1).getRank().ordinal() - handToProcess.get(i).getRank().ordinal() != 1) {
				return false;
			}
		}
		return true;
	}

}
