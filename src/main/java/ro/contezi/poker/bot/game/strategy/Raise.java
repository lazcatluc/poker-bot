package ro.contezi.poker.bot.game.strategy;

public class Raise implements Action {
	private final int amount;
	
	public Raise(int amount) {
		this.amount = amount;
	}
}
