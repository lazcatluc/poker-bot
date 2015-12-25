package ro.contezi.poker.bot.game.strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import ro.contezi.poker.bot.game.simulator.ManyPlayerSimulator;

public class OddsStrategyTest {

	private ManyPlayerSimulator manyPlayerSimulator;
	private ManyPlayerSimulator.Builder manyPlayerSimulatorBuilder;
	
	@Before
	public void setUp() {
		manyPlayerSimulator = mock(ManyPlayerSimulator.class);
		manyPlayerSimulatorBuilder = mock(ManyPlayerSimulator.Builder.class);
		when(manyPlayerSimulatorBuilder.build()).thenReturn(manyPlayerSimulator);
	}
	
	@Test
	public void foldIfCardsAreBad() {
		OddsStrategy strategy = new OddsStrategy.Builder().withManyPlayerSimulatorBuilder(manyPlayerSimulatorBuilder).build();
		when(manyPlayerSimulator.getOdds()).thenReturn(0.01);
		
		assertThat(strategy.getAction()).isEqualTo(Action.FOLD);
	}
	
	@Test
	public void checkIfCardsAreGood() {
		OddsStrategy strategy = new OddsStrategy.Builder().withManyPlayerSimulatorBuilder(manyPlayerSimulatorBuilder).build();
		when(manyPlayerSimulator.getOdds()).thenReturn(0.99);
		
		assertThat(strategy.getAction()).isEqualTo(Action.CHECK);
	}

}
