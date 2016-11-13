package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	private Mode mode;
	private View view;
	public Controller(Mode mode){
		this.mode=mode;
	}
	public void setView(View view){
		this.view=view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Start")){
			view.setButtons(true);
		}else if (e.getActionCommand().equals("Restart")){
			mode.restart();
		}else{
		mode.play(e.getActionCommand());
		}
	}
	public void resetGame() {
		mode.restart();
		
	}

}
