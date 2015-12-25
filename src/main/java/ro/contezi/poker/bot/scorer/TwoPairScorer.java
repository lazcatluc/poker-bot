package ro.contezi.poker.bot.scorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;

public class TwoPairScorer extends PairScorer {

	@Override
	public int compare(Collection<Card> o1, Collection<Card> o2) {
		int score = new HighCardScorer().compare(getPair(o1), getPair(o2));
		if (score != 0) {
			return score;
		}
		
		return super.compare(removeFirstPair(o1), removeFirstPair(o2));
	}
	
	private Collection<Card> removeFirstPair(Collection<Card> o1) {
		Collection<Card> firstPair = getPair(o1);
		List<Card> remaining = new ArrayList<>(o1);
		remaining.removeAll(firstPair);
		
		return remaining;
	}

}
