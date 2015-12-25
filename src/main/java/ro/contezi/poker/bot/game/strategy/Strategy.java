package ro.contezi.poker.bot.game.strategy;

@FunctionalInterface
public interface Strategy {
	Action getAction();
}
