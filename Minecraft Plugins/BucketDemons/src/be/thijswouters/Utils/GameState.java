package be.thijswouters.Utils;

import be.thijswouters.SQL.State;

public enum GameState {
	
    IN_LOBBY(true), IN_GAME(false), AFTER_GAME(false);
    
    private boolean canJoin;
    private static GameState currentState;
    
    GameState(boolean canJoin){
    	this.canJoin = canJoin;
    }
    
    public boolean canJoin(){
    	return canJoin;
    }
    
    public static void setState(GameState state){
    	State.setState("One", state.name());
    	GameState.currentState = state;
    }
    
    public static boolean isState(GameState state){
    	return GameState.currentState == state;
    }
    
    public static GameState getState(){
    	return currentState;
    }
}
