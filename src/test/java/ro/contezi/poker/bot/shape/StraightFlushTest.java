package ro.contezi.poker.bot.shape;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;

public class StraightFlushTest {
	@Test
	public void matchesStraightFlush() throws Exception {
		assertThat(new StraightFlush().matches(Arrays.asList(Card.get(Suit.CLUB, Rank.TEN),
				Card.get(Suit.CLUB, Rank.JACK), Card.get(Suit.CLUB, Rank.NINE), Card.get(Suit.CLUB, Rank.QUEEN),
				Card.get(Suit.CLUB, Rank.KING)))).isTrue();
	}
}
