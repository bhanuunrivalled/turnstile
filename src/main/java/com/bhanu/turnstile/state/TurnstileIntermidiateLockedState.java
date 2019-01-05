package com.bhanu.turnstile.state;

import com.bhanu.turnstile.TurnstileFsm;

/**
 * this state is used by complicated fsm , after the single coin it moves to
 * this state
 * 
 * @author Dev-il
 *
 */
public class TurnstileIntermidiateLockedState implements TurnstileState {

	private TurnstileLockedState lockedState;

	@Override
	public void coin(TurnstileFsm fsm) {
		init();
		lockedState.coin(fsm);
	}

	@Override
	public void pass(TurnstileFsm fsm) {
		init();
		lockedState.pass(fsm);
	}

	private void init() {
		if (this.lockedState == null) {
			lockedState = new TurnstileLockedState();
		}
	}

}
