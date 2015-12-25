package ro.contezi.poker.bot.game.simulator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import java.util.List;

import org.junit.Test;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;
import ro.contezi.poker.bot.game.simulator.OnePlayerSimulator;
import ro.contezi.poker.bot.shape.FourOfAKind;

public class OnePlayerSimulatorTest {

	/**
	 * http://www.texasholdem-poker.com/calculator?card1=14&card2=14&chance_format=percentage&decimals=9
	 */
	@Test
	public void fourOfAKindOnTheFlopFromTwoAces() {
		OnePlayerSimulator simulator = new OnePlayerSimulator.Builder()
				.holding(Card.get(Suit.SPADE, Rank.ACE), Card.get(Suit.DIAMOND, Rank.ACE)).simulating(3).build();
		
		List<List<Card>> allResults = simulator.getPossibleResults();
		long fourOfAKinds = allResults.stream().filter(new FourOfAKind()::matches).count();
		
		assertThat(fourOfAKinds*100.0/allResults.size()).isCloseTo(0.244897959, offset(0.000000001));
	}

}
