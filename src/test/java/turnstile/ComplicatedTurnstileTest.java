package turnstile;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bhanu.turnstile.SimpleTurnstileFsm;
import com.bhanu.turnstile.state.TurnstileComplicatedLockedState;

public class ComplicatedTurnstileTest {
	
	private SimpleTurnstileFsm complicatedTurnstileFsm;
	
	@Before
	public void setUp() {
		complicatedTurnstileFsm = new SimpleTurnstileFsm();
		complicatedTurnstileFsm.setState(new TurnstileComplicatedLockedState());
	}
	
	@Test
	public void coinCoinPass() {
		complicatedTurnstileFsm.coin();
		complicatedTurnstileFsm.coin();
		complicatedTurnstileFsm.pass();
		assertActions("LUL");
	}




	private void assertActions(String expected) {
		assertEquals(expected, complicatedTurnstileFsm.getActions());
	}


}
