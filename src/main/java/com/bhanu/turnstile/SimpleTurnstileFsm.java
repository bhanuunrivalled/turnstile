package com.bhanu.turnstile;

public class SimpleTurnstileFsm extends TurnstileFsm{
	
	private String actions="";

	@Override
	public void lock() {
		actions=actions+"L";
		
	}

	@Override
	public void unLock() {
		actions=actions+"U";
	}

	@Override
	public void thankYou() {
		actions=actions+"T";
	}

	@Override
	public void alarm() {
		actions=actions+"A";
	}

	public String getActions() {
		return actions;
	}
	

}
