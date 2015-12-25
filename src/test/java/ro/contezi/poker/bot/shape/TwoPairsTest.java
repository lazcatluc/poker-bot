package ro.contezi.poker.bot.shape;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;

public class TwoPairsTest {

	@Test
	public void test() {
		assertThat(new TwoPairs().applies(Arrays.asList(Card.get(Suit.SPADE, Rank.ACE), Card.get(Suit.HEART, Rank.ACE),
				Card.get(Suit.DIAMOND, Rank.EIGHT), Card.get(Suit.CLUB, Rank.EIGHT)))).isTrue();
	}

}
