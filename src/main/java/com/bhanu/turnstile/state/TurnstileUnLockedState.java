package com.bhanu.turnstile.state;

import com.bhanu.turnstile.TurnstileFsm;

public class TurnstileUnLockedState implements TurnstileState {
	
	private TurnstileLockedState lockedState;

	@Override
	public void coin(TurnstileFsm fsm) {
		fsm.setState(this);
		fsm.thankYou();
	}

	@Override
	public void pass(TurnstileFsm fsm) {
		if(lockedState==null) {
			lockedState = new TurnstileLockedState();
		}
		fsm.setState(lockedState);
		fsm.lock();
	}

}
