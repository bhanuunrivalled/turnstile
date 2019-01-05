package turnstile;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bhanu.turnstile.SimpleTurnstileFsm;
import com.bhanu.turnstile.state.TurnstileLockedState;

public class SimpleTurnstileTest {

	private SimpleTurnstileFsm simpleTurnstileFsm;

	@Before
	public void setUp() {
		simpleTurnstileFsm = new SimpleTurnstileFsm();
		simpleTurnstileFsm.setState(new TurnstileLockedState());
	}

	@Test
	public void coinAndPass() {
		simpleTurnstileFsm.coin();
		simpleTurnstileFsm.pass();
		assertActions("UL");
	}
	
	@Test
	public void coinAndPassPass() {
		simpleTurnstileFsm.coin();
		simpleTurnstileFsm.pass();
		simpleTurnstileFsm.pass();
		assertActions("ULA");
	}
	
	@Test
	public void multipleCoinAndPass() {
		// passing 5 coins
		for(int i=0;i<5;i++) {
			simpleTurnstileFsm.coin();
		}
		simpleTurnstileFsm.pass();
		assertActions("UTTTTL");
	}
	
	@Test
	public void multiplePassCoin() {
		// passing 5 coins
		for(int i=0;i<5;i++) {
			simpleTurnstileFsm.pass();
		}
		simpleTurnstileFsm.coin();
		assertActions("AAAAAU");
	}

	private void assertActions(String expected) {
		assertEquals(expected, simpleTurnstileFsm.getActions());
	}

}
