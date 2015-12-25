package ro.contezi.poker.bot.game.simulator;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;

public class ManyPlayerPreFlopSimulatorITest {

	@Test
	public void fullSimulation() {
		System.out.println(new ManyPlayerSimulator.Builder().withPlayers(2)
				.withCurrent(Card.get(Suit.SPADE, Rank.JACK), Card.get(Suit.HEART, Rank.JACK))
				.withCommunity(Card.get(Suit.DIAMOND, Rank.SEVEN), Card.get(Suit.HEART, Rank.ACE),
						Card.get(Suit.HEART, Rank.KING))
				.build().getOdds());
	}

}
