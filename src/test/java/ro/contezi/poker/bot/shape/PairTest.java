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
		assertThat(new Pair().matches(Arrays.asList(Card.get(Suit.CLUB, Rank.ACE), Card.get(Suit.DIAMOND, Rank.ACE))))
				.isTrue();
	}

	@Test
	public void doesNotApplyToTwoUnequalCards() throws Exception {
		assertThat(new Pair().matches(Arrays.asList(Card.get(Suit.CLUB, Rank.ACE), Card.get(Suit.CLUB, Rank.KING))))
				.isFalse();
	}

	@Test
	public void appliesToThreeCardsWhenOneAndThreeAreEqual() throws Exception {
		assertThat(new Pair().matches(Arrays.asList(Card.get(Suit.CLUB, Rank.ACE), Card.get(Suit.DIAMOND, Rank.KING),
				Card.get(Suit.HEART, Rank.ACE)))).isTrue();
	}
	
	@Test
	public void appliesToThreeCardsWhenTwoAndThreeAreEqual() throws Exception {
		assertThat(new Pair().matches(Arrays.asList(Card.get(Suit.DIAMOND, Rank.KING), Card.get(Suit.CLUB, Rank.ACE),
				Card.get(Suit.SPADE, Rank.ACE)))).isTrue();
	}
}
