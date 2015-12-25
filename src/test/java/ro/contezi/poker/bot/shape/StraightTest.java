package ro.contezi.poker.bot.shape;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;

public class StraightTest {
	@Test
	public void matchesStraight() throws Exception {
		assertThat(new Straight().matches(Arrays.asList(Card.get(Suit.CLUB, Rank.TEN),
				Card.get(Suit.SPADE, Rank.JACK), Card.get(Suit.HEART, Rank.NINE), Card.get(Suit.DIAMOND, Rank.QUEEN),
				Card.get(Suit.DIAMOND, Rank.KING)))).isTrue();
	}
}
