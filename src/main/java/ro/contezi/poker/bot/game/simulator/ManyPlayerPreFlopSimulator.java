package ro.contezi.poker.bot.game.simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;
import ro.contezi.poker.bot.game.Result;
import ro.contezi.poker.bot.game.TexasHoldEm;
import ro.contezi.poker.bot.simulator.Combinator;

public class ManyPlayerPreFlopSimulator {

	private final List<Card> current;
	private final int players;
	private final int runs;

	private ManyPlayerPreFlopSimulator(Builder builder) {
		this.current = new ArrayList<>(builder.current);
		this.players = builder.players;
		this.runs = builder.runs;
	}

	public List<Result> getPossibleResults() {
		List<Result> ret = new ArrayList<>();
		for (int i = 0; i < runs; i++) {
			ret.add(gameOfCombination(new Combinator().without(current).getDeck()).getResult());
		}
		return ret;
	}

	private TexasHoldEm gameOfCombination(List<Card> combination) {
		TexasHoldEm game = TexasHoldEm.of(players).withPlayer(1).holding(current);
		for (int player = 2; player <= players; player++) {
			int playerFromIndex = 2 * (player - 2);
			game.withPlayer(player).holding(combination.subList(playerFromIndex, playerFromIndex + 2));
		}
		return game.withCommunity(combination.subList(2 * players, 2 * players + TexasHoldEm.COMMUNITY_CARDS));
	}

	public static class Builder {
		private int players = 2;
		private int runs = 1000;
		private List<Card> current = Arrays.asList(Card.get(Suit.SPADE, Rank.ACE), Card.get(Suit.HEART, Rank.ACE));

		public Builder withPlayers(int players) {
			this.players = players;
			return this;
		}

		public Builder withCurrent(Card... cards) {
			current = Arrays.asList(cards);
			return this;
		}
		
		public Builder withRuns(int runs) {
			this.runs = runs;
			return this;
		}

		public ManyPlayerPreFlopSimulator build() {
			return new ManyPlayerPreFlopSimulator(this);
		}

	}
}
