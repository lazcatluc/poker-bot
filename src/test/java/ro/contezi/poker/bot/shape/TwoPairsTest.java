package ro.contezi.poker.bot.shape;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;

public class TwoPairsTest {

	@Test
	public void hasTwoPairsWhenHavingTwoConsecutivePairs() {
		assertThat(new TwoPairs().applies(Arrays.asList(Card.get(Suit.SPADE, Rank.ACE), Card.get(Suit.HEART, Rank.ACE),
				Card.get(Suit.DIAMOND, Rank.EIGHT), Card.get(Suit.CLUB, Rank.EIGHT)))).isTrue();
	}

	@Test
	public void hasTwoPairsWhenHavingTwoNonConsecutivePairs() {
		assertThat(new TwoPairs().applies(Arrays.asList(Card.get(Suit.SPADE, Rank.ACE),
				Card.get(Suit.DIAMOND, Rank.EIGHT), Card.get(Suit.HEART, Rank.ACE), Card.get(Suit.CLUB, Rank.EIGHT))))
						.isTrue();
	}

	@Test
	public void hasTwoPairsWhenHavingTwoNonConsecutivePairsNotInFirstPlace() {
		assertThat(new TwoPairs().applies(Arrays.asList(Card.get(Suit.SPADE, Rank.JACK), Card.get(Suit.SPADE, Rank.ACE),
				Card.get(Suit.DIAMOND, Rank.EIGHT), Card.get(Suit.HEART, Rank.ACE), Card.get(Suit.CLUB, Rank.EIGHT))))
						.isTrue();
	}

	@Test
	public void hasTwoPairsWhenHavingTwoNonConsecutivePairsNotInFirstPlaceAndNotInLastPlace() {
		assertThat(new TwoPairs().applies(Arrays.asList(Card.get(Suit.SPADE, Rank.ACE),
				Card.get(Suit.DIAMOND, Rank.EIGHT), Card.get(Suit.SPADE, Rank.JACK), Card.get(Suit.HEART, Rank.ACE),
				Card.get(Suit.CLUB, Rank.EIGHT)))).isTrue();
	}
}
