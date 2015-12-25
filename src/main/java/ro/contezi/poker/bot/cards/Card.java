package ro.contezi.poker.bot.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class Card {
	
	private final Rank rank;
	private final Suit suit;
	
	private static final Map<Suit, Map<Rank, Card>> CARDS; 
	
	static {
		Map<Suit, Map<Rank, Card>> cards = new EnumMap<>(Suit.class);
		Arrays.stream(Suit.values()).forEach(suit -> {
			Map<Rank, Card> ranks = new EnumMap<>(Rank.class);
			Arrays.stream(Rank.values()).forEach(rank -> ranks.put(rank, new Card(rank, suit)));
			cards.put(suit, ranks);
		});
		CARDS = Collections.unmodifiableMap(cards);
	}
	
	private Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public String toString() {
		return "The " + rank + " of " + suit;
	}
	
	public static Card get(Suit suit, Rank rank) {
		return CARDS.get(suit).get(rank);
	}
	
	public static List<Card> newDeck() {
		List<Card> deck = new ArrayList<>();
		CARDS.values().stream().map(Map::values).forEach(deck::addAll);
		Collections.shuffle(deck);
		return deck;
	}

	public Rank getRank() {
		return rank;
	}
}
