package ro.contezi.poker.bot.simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;

public class Simulator {
	private final List<Card> current;
	private final int cardsToSimulate;
	
	private Simulator(Builder builder) {
		this.current = Collections.unmodifiableList(new ArrayList<>(builder.current));
		this.cardsToSimulate = builder.cardsToSimulate;
	}

	public List<List<Card>> getPossibleResults() {
		List<Card> deck = new ArrayList<>(Card.newDeck());
		deck.removeAll(current);
		
		List<List<Card>> combinations = combinations(deck, cardsToSimulate);
		combinations.forEach(list -> list.addAll(current));
		return combinations;
	}
	
	private List<List<Card>> combinations(List<Card> from, int cards) {
		if (from.size() < cards) {
			return Collections.emptyList();
		}
		
		if (cards == 0) {
			return Collections.singletonList(new ArrayList<>());
		}
		
		Card first = from.get(0);
		List<Card> newCards = new ArrayList<>(from);
		newCards.remove(0);
		
		List<List<Card>> ret = new ArrayList<>();
		List<List<Card>> cardsWithFirst = combinations(newCards, cards - 1);
		cardsWithFirst.forEach(list -> list.add(first));
		ret.addAll(cardsWithFirst);
		ret.addAll(combinations(newCards, cards));
		
		return ret;
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
		
		public Simulator build() {
			return new Simulator(this);
		}
	}
}
