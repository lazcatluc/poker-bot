package ro.contezi.poker.bot.simulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;

public class Combinator {
	private List<Card> deck;
	
	public Combinator without(List<Card> current) {
		deck = new ArrayList<>(Card.newDeck());
		deck.removeAll(current);
		return this;
	}
	
	public List<List<Card>> combinationsOf(int cards) {
		return combinations(deck, cards);
	}
	
	private static List<List<Card>> combinations(List<Card> from, int cards) {
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
		cardsWithFirst.stream().forEach(list -> list.add(first));
		ret.addAll(cardsWithFirst);
		ret.addAll(combinations(newCards, cards));
		
		return ret;
	}
}
