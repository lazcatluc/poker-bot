package ro.contezi.poker.bot.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;

public class TwoPairs implements Shape {

	@Override
	public boolean applies(Collection<Card> hand) {
		if (hand.size() < 4) {
			return false;
		}
		List<Card> handToProcess = new ArrayList<>(hand);
		if (new Pair().applies(handToProcess.subList(0, 2)) && new Pair().applies(handToProcess.subList(2, 4))) {
			return true;
		};
		if (new Pair().applies(Arrays.asList(handToProcess.get(0), handToProcess.get(2))) &&
				new Pair().applies(Arrays.asList(handToProcess.get(1), handToProcess.get(3)))) {
			return true;
		}
		if (new Pair().applies(Arrays.asList(handToProcess.get(0), handToProcess.get(3))) &&
				new Pair().applies(Arrays.asList(handToProcess.get(1), handToProcess.get(2)))) {
			return true;
		}
		return false;
	}

}
