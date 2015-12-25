package ro.contezi.poker.bot.scorer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;

public class ScorerTest {

	@Test
	public void twoPairsBeatsPair() {
		assertThat(new Scorer().compare(
				Arrays.asList(Card.get(Suit.SPADE, Rank.KING), Card.get(Suit.DIAMOND, Rank.EIGHT),
						Card.get(Suit.HEART, Rank.KING), Card.get(Suit.CLUB, Rank.EIGHT)),
				Arrays.asList(Card.get(Suit.CLUB, Rank.ACE), Card.get(Suit.DIAMOND, Rank.ACE)))).isLessThan(0);
	}

	@Test
	public void higherCardWinsInHighCards() throws Exception {
		assertThat(new Scorer().compare(Arrays.asList(Card.get(Suit.SPADE, Rank.KING)),
				Arrays.asList(Card.get(Suit.CLUB, Rank.TWO)))).isLessThan(0);
	}
}
