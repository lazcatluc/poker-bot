package ro.contezi.poker.bot.game.strategy;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.game.simulator.ManyPlayerSimulator;

public class OddsStrategy implements Strategy {

	private final ManyPlayerSimulator manyPlayerSimulator;
	private final int pot;
	private final int amountRequiredToCheck;
	
	private OddsStrategy(Builder builder) {
		this.manyPlayerSimulator = builder.manyPlayerSimulatorBuilder.build();
		this.pot = builder.pot;
		this.amountRequiredToCheck = builder.amountRequiredToCheck;
	}

	@Override
	public Action getAction() {
		double odds = manyPlayerSimulator.getOdds();
		if (amountRequiredToCheck > odds * (pot + amountRequiredToCheck)) {
			return Action.FOLD;
		}
		return Action.CHECK;
	}

	public static class Builder {
		private ManyPlayerSimulator.Builder manyPlayerSimulatorBuilder = new ManyPlayerSimulator.Builder();
		private int pot = 3;
		private int amountRequiredToCheck = 1;

		public Builder withPot(int pot) {
			this.pot = pot;
			return this;
		}

		public Builder withAmountRequiredToCheck(int amountRequiredToCheck) {
			this.amountRequiredToCheck = amountRequiredToCheck;
			return this;
		}

		public Builder withMyCards(Card... cards) {
			manyPlayerSimulatorBuilder.withCurrent(cards);
			return this;
		}

		public Builder withPlayers(int players) {
			manyPlayerSimulatorBuilder.withPlayers(players);
			return this;
		}

		public OddsStrategy build() {
			return new OddsStrategy(this);
		}

		public Builder withManyPlayerSimulatorBuilder(ManyPlayerSimulator.Builder manyPlayerSimulatorBuilder) {
			this.manyPlayerSimulatorBuilder = manyPlayerSimulatorBuilder;
			return this;
		}
	}
}
