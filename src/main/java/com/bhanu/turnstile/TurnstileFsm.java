package com.bhanu.turnstile;

import com.bhanu.turnstile.state.TurnstileState;

public abstract class TurnstileFsm {
	
	private TurnstileState state;
	
	public void setState(TurnstileState state) {
		this.state = state;
	}

	public void pass() {
		state.pass(this);
	}
	
	public void coin() {
		state.coin(this);
	}

	public abstract void lock();
	
	public abstract void unLock();
	
	public abstract void thankYou();
	
	public abstract void alarm();
	

}
