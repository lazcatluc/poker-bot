package ro.contezi.poker.bot.game.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.cards.Rank;
import ro.contezi.poker.bot.cards.Suit;
import ro.contezi.poker.bot.game.simulator.ManyPlayerSimulator;

public class OddsStrategy implements Strategy {

	private final ManyPlayerSimulator.Builder manyPlayerSimulator;
	private final List<Card> myCards;
	private final List<Card> communityCards;
	private final int pot;
	private final int amountRequiredToCheck;
	private final int players;

	private OddsStrategy(Builder builder) {
		this.manyPlayerSimulator = builder.manyPlayerSimulator;
		this.myCards = new ArrayList<>(builder.myCards);
		this.communityCards = new ArrayList<>(builder.communityCards);
		this.pot = builder.pot;
		this.amountRequiredToCheck = builder.amountRequiredToCheck;
		this.players = builder.players;
	}

	@Override
	public Action getAction() {
		double odds = manyPlayerSimulator.withCommunity(communityCards).withCurrent(myCards).withPlayers(players)
				.build().getOdds();
		if (amountRequiredToCheck > odds * (pot + amountRequiredToCheck)) {
			return Action.FOLD;
		}
		return Action.CHECK;
	}

	public static class Builder {
		private ManyPlayerSimulator.Builder manyPlayerSimulator = new ManyPlayerSimulator.Builder();
		private List<Card> communityCards = Collections.emptyList();
		private List<Card> myCards = Arrays.asList(Card.get(Suit.SPADE, Rank.ACE), Card.get(Suit.HEART, Rank.ACE));
		private int pot = 3;
		private int amountRequiredToCheck = 1;
		private int players = 2;

		public Builder withPot(int pot) {
			this.pot = pot;
			return this;
		}

		public Builder withAmountRequiredToCheck(int amountRequiredToCheck) {
			this.amountRequiredToCheck = amountRequiredToCheck;
			return this;
		}

		public Builder withMyCards(Card... cards) {
			myCards = Arrays.asList(cards);
			return this;
		}

		public Builder withPlayers(int players) {
			this.players = players;
			return this;
		}

		public OddsStrategy build() {
			return new OddsStrategy(this);
		}

		public Builder withManyPlayerSimulatorBuilder(ManyPlayerSimulator.Builder manyPlayerSimulatorBuilder) {
			this.manyPlayerSimulator = manyPlayerSimulatorBuilder;
			return this;
		}
	}
}
