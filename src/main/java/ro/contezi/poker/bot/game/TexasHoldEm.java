package ro.contezi.poker.bot.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ro.contezi.poker.bot.cards.Card;
import ro.contezi.poker.bot.scorer.Scorer;
import ro.contezi.poker.bot.simulator.Combinator;

public class TexasHoldEm {
	private final List<List<Card>> playerCards;
	private final List<Card> communityCards;
	
	private TexasHoldEm(int players) {
		playerCards = new ArrayList<>(players);
		for (int i = 0; i < players; i++) {
			playerCards.add(new ArrayList<>(2));
		}
		communityCards = new ArrayList<>(5);
	}
	
	public Result getResult() {
		Result result = new Result(playerCards.size());
		Scorer scorer = new Scorer();
		List<List<Card>> bestHands = new ArrayList<>(playerCards.size());
		playerCards.forEach(playerHand -> bestHands.add(buildBestHand(playerHand)));
		List<Card> bestHand = bestHands.stream().min(scorer).get();
		for (int i = 0; i < bestHands.size(); i++) {
			if (scorer.compare(bestHand, bestHands.get(i)) == 0) {
				result.markWinner(i);
			}
		}
		return result;
	}
	
	private List<Card> buildBestHand(List<Card> playerHand) {
		List<Card> playerPlusCommunity = new ArrayList<>();
		playerPlusCommunity.addAll(playerHand);
		playerPlusCommunity.addAll(communityCards);
		List<List<Card>> combinationsOf5 = Combinator.combinations(playerPlusCommunity, 5);
		Collections.sort(combinationsOf5, new Scorer());
		return combinationsOf5.get(0);
	}
	
	public TexasHoldEm withCommunity(Card... cards) {
		communityCards.addAll(Arrays.asList(cards));
		return this;
	}
	
	public Player withPlayer(int playerPlusOne) {
		return new Player(playerCards.get(playerPlusOne - 1));
	}
	
	public static TexasHoldEm of(int players) {
		TexasHoldEm game = new TexasHoldEm(players);
		return game;
	}
	
	public class Player {
		
		private final List<Card> hand;
		
		private Player(List<Card> hand) {
			this.hand = hand;
		}
		
		public TexasHoldEm holding(Card... cards) {
			hand.addAll(Arrays.asList(cards));
			return TexasHoldEm.this;
		}
	}
}
