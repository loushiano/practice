package tictactoe;

import java.util.Observable;

public class Mode extends Observable {
	private View view;
	private User userO;
	private User userX;
	private int turn;
	public Mode(){
		turn=0;
		userO=new User("O");
		userX=new User("X");
	}
	public void SetObserver(View view){
		this.view=view;
		addObserver(view);
	}

	public void play(String actionCommand) {
		if(turn==0){
			userX.addPlayedTurn(actionCommand);
			setChanged();
			notifyObservers(actionCommand.concat("X"));
			boolean b=checkWinner(userX);
			if(b){
			setChanged();
			notifyObservers(userX);
			}
			turn=1;
		}else{
			userO.addPlayedTurn(actionCommand);
			setChanged();
			notifyObservers(actionCommand.concat("O"));
			boolean b=checkWinner(userO);
			if(b){
			setChanged();
			notifyObservers(userO);
			}
			turn=0;
		}
		
	}
	public boolean checkWinner(User user){
		return user.CheckForStraighLine();
	}
	public static void main(String args[]){
		Mode mode=new Mode();
		Controller controller=new Controller(mode);
		View view=new View(controller);
		controller.setView(view);
		mode.SetObserver(view);
		view.createView();
	}
	public void restart() {
		userX.reset();
		userO.reset();
		turn=0;
		setChanged();
		notifyObservers(null);
	}

}
