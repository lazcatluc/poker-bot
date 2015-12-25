package ro.contezi.poker.bot.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.scorer.Scorer;

public class Game {
	private final List<List<Card>> playerCards;
	private final List<Card> communityCards;
	
	private Game(int players) {
		playerCards = new ArrayList<>(players);
		for (int i = 0; i < players; i++) {
			playerCards.add(new ArrayList<>(2));
		}
		communityCards = new ArrayList<>(5);
	}
	
	public Result getResult() {
		Result result = new Result(playerCards.size());
		Scorer scorer = new Scorer();
		List<Card> bestHand = playerCards.stream().min(scorer).get();
		for (int i = 0; i < playerCards.size(); i++) {
			if (scorer.compare(bestHand, playerCards.get(i)) == 0) {
				result.markWinner(i);
			}
		}
		return result;
	}
	
	public Game withCommunity(Card... cards) {
		communityCards.addAll(Arrays.asList(cards));
		return this;
	}
	
	public Player withPlayer(int playerPlusOne) {
		return new Player(playerCards.get(playerPlusOne - 1));
	}
	
	public static Game of(int players) {
		Game game = new Game(players);
		return game;
	}
	
	public class Player {
		
		private final List<Card> hand;
		
		private Player(List<Card> hand) {
			this.hand = hand;
		}
		
		public Game holding(Card... cards) {
			hand.addAll(Arrays.asList(cards));
			return Game.this;
		}
	}
}
