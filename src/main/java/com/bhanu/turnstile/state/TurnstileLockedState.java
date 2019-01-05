package com.bhanu.turnstile.state;

import com.bhanu.turnstile.TurnstileFsm;

public class TurnstileLockedState implements TurnstileState{

	private TurnstileUnLockedState unLockedState ;
	
	@Override
	public void coin(TurnstileFsm fsm) {
		if(unLockedState==null) {
			unLockedState = new TurnstileUnLockedState();
		}
		fsm.setState(unLockedState);
		fsm.unLock();
	}

	@Override
	public void pass(TurnstileFsm fsm) {
		fsm.setState(this);
		fsm.alarm();
	}

}
