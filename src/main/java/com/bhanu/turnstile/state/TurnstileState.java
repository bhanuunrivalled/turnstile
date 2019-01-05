package com.bhanu.turnstile.state;

import com.bhanu.turnstile.TurnstileFsm;

public interface TurnstileState {
	
	public void coin(TurnstileFsm fsm);
	
	public void pass(TurnstileFsm  fsm);

}
