package ro.contezi.poker.bot.cards;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CardTest {

	@Test
	public void deckContainsAllCards() {
		assertThat(Card.newDeck().size()).isEqualTo(52);
	}

	@Test
	public void deckIsShuffled() throws Exception {
		assertThat(Card.newDeck()).isNotEqualTo(Card.newDeck());
	}
	
}
