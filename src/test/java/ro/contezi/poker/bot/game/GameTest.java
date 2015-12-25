package ro.contezi.poker.bot.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;

public class GameTest {

	@Test
	public void highestCardPlayerIsWinner() {
		Game game = Game.of(2).withPlayer(1).holding(Card.get(Suit.CLUB, Rank.ACE)).withPlayer(2)
				.holding(Card.get(Suit.DIAMOND, Rank.EIGHT));
		
		assertThat(game.getResult().isWinner(1)).isTrue();
	}
	
	@Test
	public void lowestCardPlayerIsNotWinner() throws Exception {
		Game game = Game.of(2).withPlayer(1).holding(Card.get(Suit.CLUB, Rank.ACE)).withPlayer(2)
				.holding(Card.get(Suit.DIAMOND, Rank.EIGHT));
		
		assertThat(game.getResult().isWinner(2)).isFalse();
	}

}
