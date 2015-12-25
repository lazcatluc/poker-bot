package ro.contezi.poker.bot.shape;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;

public class FullHouseTest {
	@Test
	public void findsFullHouse() throws Exception {
		assertThat(new FullHouse().matches(Arrays.asList(Card.get(Suit.CLUB, Rank.TEN),
				Card.get(Suit.SPADE, Rank.ACE), Card.get(Suit.HEART, Rank.ACE), Card.get(Suit.DIAMOND, Rank.TEN),
				Card.get(Suit.DIAMOND, Rank.ACE)))).isTrue();
	}
}
