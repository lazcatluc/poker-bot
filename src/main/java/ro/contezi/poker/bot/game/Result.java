package ro.contezi.poker.bot.game;

public class Result {

	private boolean winners[];
	
	public Result(int players) {
		winners = new boolean[players];
	}
	
	public Result markWinner(int player) {
		winners[player] = true;
		return this;
	}
	
	public boolean isWinner(int playerPlusOne) {
		return winners[playerPlusOne - 1];
	}

}
