package ro.contezi.poker.bot.game.simulator;

import java.util.List;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;
import ro.contezi.poker.bot.game.Result;

public class ManyPlayerPreFlopSimulatorITest {

	@Test
	public void fullSimulation() {		
		List<Result> results = new ManyPlayerPreFlopSimulator.Builder().withPlayers(2).withCurrent(
				Card.get(Suit.SPADE, Rank.JACK), Card.get(Suit.HEART, Rank.JACK)
			).build().getPossibleResults();
		double wins = results.stream().filter(result -> result.isWinner(1)).mapToDouble(result -> 1.0/result.getTotalWinners()).sum();
		
		System.out.println(wins / results.size());
	}

}
