package ro.contezi.poker.bot.scorer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.shape.Flush;
import ro.contezi.poker.bot.shape.FourOfAKind;
import ro.contezi.poker.bot.shape.FullHouse;
import ro.contezi.poker.bot.shape.HighCard;
import ro.contezi.poker.bot.shape.Pair;
import ro.contezi.poker.bot.shape.Shape;
import ro.contezi.poker.bot.shape.Straight;
import ro.contezi.poker.bot.shape.StraightFlush;
import ro.contezi.poker.bot.shape.ThreeOfAKind;
import ro.contezi.poker.bot.shape.TwoPairs;

public class Scorer implements Comparator<Collection<Card>> {

	private final List<Shape> shapes = Arrays.asList(new StraightFlush(), new FourOfAKind(), new FullHouse(),
			new Flush(), new Straight(), new ThreeOfAKind(), new TwoPairs(), new Pair(), new HighCard());
	private final List<Comparator<Collection<Card>>> tieBreakers = Arrays.asList(new HighCardScorer(), new PairScorer(), new FullHouseScorer(),
			new HighCardScorer(), new HighCardScorer(), new PairScorer(), new TwoPairScorer(), new PairScorer(), new HighCardScorer());

	@Override
	public int compare(Collection<Card> o1, Collection<Card> o2) {
		int pos1 = 0;
		int pos2 = 0;
		while (!shapes.get(pos1).matches(o1)) {
			pos1++;
		}
		while (!shapes.get(pos2).matches(o2)) {
			pos2++;
		}
		int diff = pos1 - pos2;
		if (diff != 0) {
			return diff;
		};
		return tieBreakers.get(pos1).compare(o1, o2);
	}

}
