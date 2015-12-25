package ro.contezi.poker.bot.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;

public class TexasHoldEmTest {

	@Test
	public void bestHandPlayerIsWinner() {
		assertThat(player1BestHandGame().getResult().isWinner(1)).isTrue();
	}

	@Test
	public void worstHandPlayerIsNotWinner() throws Exception {
		assertThat(player1BestHandGame().getResult().isWinner(2)).isFalse();
	}

	@Test
	public void bothWinWithCommunityCards() throws Exception {
		TexasHoldEm game = TexasHoldEm.of(2).withPlayer(1).holding(Card.get(Suit.CLUB, Rank.ACE)).withPlayer(2)
				.holding(Card.get(Suit.HEART, Rank.EIGHT)).withCommunity(Card.get(Suit.DIAMOND, Rank.TWO),
						Card.get(Suit.DIAMOND, Rank.THREE), Card.get(Suit.DIAMOND, Rank.FOUR),
						Card.get(Suit.DIAMOND, Rank.FIVE), Card.get(Suit.DIAMOND, Rank.SIX));

		assertThat(game.getResult().isWinner(1)).isTrue();
		assertThat(game.getResult().isWinner(2)).isTrue();
	}
	
	private TexasHoldEm player1BestHandGame() {
		return TexasHoldEm.of(2).withPlayer(1)
				.holding(Card.get(Suit.SPADE, Rank.KING), Card.get(Suit.HEART, Rank.KING),
						Card.get(Suit.DIAMOND, Rank.TWO), Card.get(Suit.DIAMOND, Rank.QUEEN),
						Card.get(Suit.HEART, Rank.QUEEN))
				.withPlayer(2).holding(Card.get(Suit.CLUB, Rank.TWO), Card.get(Suit.HEART, Rank.TWO),
						Card.get(Suit.SPADE, Rank.ACE), Card.get(Suit.DIAMOND, Rank.KING),
						Card.get(Suit.CLUB, Rank.KING));
	}
}
