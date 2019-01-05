package com.bhanu.turnstile.state;

import com.bhanu.turnstile.TurnstileFsm;

/**
 * this is a type of locked state in which one coin event moves the fsm in to
 * intermediate locked state
 * 
 * @author Dev-il
 *
 */
public class TurnstileComplicatedLockedState implements TurnstileState {

	private TurnstileIntermidiateLockedState turnstileIntermidiateLockedState;

	@Override
	public void coin(TurnstileFsm fsm) {
		if (turnstileIntermidiateLockedState == null) {
			turnstileIntermidiateLockedState = new TurnstileIntermidiateLockedState();
		}
		fsm.setState(turnstileIntermidiateLockedState);
		fsm.lock();
	}

	@Override
	public void pass(TurnstileFsm fsm) {
		fsm.setState(this);
		fsm.alarm();
	}

}
