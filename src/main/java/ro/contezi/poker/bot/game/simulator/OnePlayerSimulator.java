package ro.contezi.poker.bot.game.simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.simulator.Combinator;

public class OnePlayerSimulator {
	private final List<Card> current;
	private final int cardsToSimulate;
	
	private OnePlayerSimulator(Builder builder) {
		this.current = Collections.unmodifiableList(new ArrayList<>(builder.current));
		this.cardsToSimulate = builder.cardsToSimulate;
	}

	public List<List<Card>> getPossibleResults() {		
		List<List<Card>> combinations = new Combinator().without(current).combinationsOf(cardsToSimulate);
		combinations.forEach(list -> list.addAll(current));
		return combinations;
	}
	
	public static class Builder {
		private int cardsToSimulate;
		private Collection<Card> current;
		
		public Builder simulating(int cardsToSimulate) {
			this.cardsToSimulate = cardsToSimulate;
			return this;
		}
		
		public Builder holding(Card... current) {
			this.current = Arrays.asList(current);
			return this;
		}
		
		public OnePlayerSimulator build() {
			return new OnePlayerSimulator(this);
		}
	}
}
