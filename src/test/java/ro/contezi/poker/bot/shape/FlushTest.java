package ro.contezi.poker.bot.shape;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;

public class FlushTest {
	@Test
	public void findsFlush() throws Exception {
		assertThat(new Flush().matches(Arrays.asList(Card.get(Suit.CLUB, Rank.ACE),
				Card.get(Suit.CLUB, Rank.TWO), Card.get(Suit.CLUB, Rank.THREE), Card.get(Suit.CLUB, Rank.FIVE),
				Card.get(Suit.CLUB, Rank.KING)))).isTrue();
	}
}
