package ro.contezi.poker.bot.shape;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;

public class PairTest {

	@Test
	public void appliesToTwoEqualCards() {
		assertThat(new Pair().applies(Arrays.asList(Card.get(Suit.CLUB, Rank.ACE), Card.get(Suit.CLUB, Rank.ACE)))).isTrue();
	}

}
