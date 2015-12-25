package ro.contezi.poker.bot.game.strategy;

public interface Action {
	Action FOLD = new Action(){};
	Action CHECK = new Action(){};
}
