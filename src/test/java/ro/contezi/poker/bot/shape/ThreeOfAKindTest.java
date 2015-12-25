package ro.contezi.poker.bot.shape;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;

public class ThreeOfAKindTest {

	@Test
	public void matchesThreeEqualRanks() {
		assertThat(new ThreeOfAKind().matches(Arrays.asList(Card.get(Suit.CLUB, Rank.TEN),
				Card.get(Suit.SPADE, Rank.ACE), Card.get(Suit.HEART, Rank.ACE), Card.get(Suit.DIAMOND, Rank.FIVE),
				Card.get(Suit.DIAMOND, Rank.ACE)))).isTrue();
	}

}
