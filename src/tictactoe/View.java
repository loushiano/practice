package tictactoe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import network2.CirclePanel;

public class View implements Observer{
	private JFrame frame;
	//private CirclePanel circlePanel;
	private Container contentPane;
	private JPanel northPanel;
	private JPanel southPanel;
	private JButton[][] buttons;
	
	
	private Controller controller;
	public View(Controller controller){
		frame=new JFrame("tic-tac-toe");
		frame.setPreferredSize(new Dimension(600,600));
		contentPane=frame.getContentPane();
		southPanel=new JPanel();
		
		buttons=new JButton[3][3];
		this.controller=controller;
	}
	public void createView(){
		northPanel=new JPanel();
		GridLayout layout=new GridLayout(3,3);
		BorderLayout layout2=new BorderLayout();
		northPanel.setLayout(layout);
		contentPane.setLayout(layout2);
		contentPane.add(northPanel,BorderLayout.CENTER);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		JButton start=new JButton("Start");
		JButton restart= new JButton("Restart");
		start.addActionListener(controller);
		restart.addActionListener(controller);
		southPanel.add(start);
		southPanel.add(restart);
		for (int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				buttons[i][j]=new JButton();
				buttons[i][j].setActionCommand(""+i+" "+j);
				buttons[i][j].addActionListener(controller);
				buttons[i][j].setEnabled(false);
				northPanel.add(buttons[i][j]);
			}
		}
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1 instanceof String){
			String s=(String)arg1;
			
			int i=Integer.parseInt(s.substring(0, 1));
			int j=Integer.parseInt(s.substring(2, 3));
			
			buttons[i][j].setText(s.substring(3));
			buttons[i][j].setEnabled(false);
		}else if (arg1 instanceof User){
			User user =(User)arg1;
			int i=JOptionPane.showConfirmDialog(frame, "the winner is "+user.getName() +". Would you like to restart the game?","winner",2);
			if(i==JOptionPane.OK_OPTION){
				controller.resetGame();
			}else{
			setButtons(false);
			}
		}else{
			setButtons(true);
			clearButtons();
		}
		
	}
	private void clearButtons() {
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				buttons[i][j].setText(null);
			}
		}
		
	}
	public void setButtons(boolean b) {
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				buttons[i][j].setEnabled(b);
			}
		}
		
	}


}