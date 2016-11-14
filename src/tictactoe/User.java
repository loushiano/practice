package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
	
public class User {
	private String name; 
	private ArrayList<String> position;
	private ArrayList<Integer> i;
	private ArrayList<Integer> j;
	public ArrayList<Integer> getI() {
		return i;
	}
	public void setI(ArrayList<Integer> i) {
		this.i = i;
	}
	public ArrayList<Integer> getJ() {
		return j;
	}
	public void setJ(ArrayList<Integer> j) {
		this.j = j;
	}
	public User(String s){
		setName(s);
		position= new ArrayList<String>();
		i=new ArrayList<Integer>();
		j=new ArrayList<Integer>();
	}
	public void addPlayedTurn(String position){
		String points[]=position.split(" ");
		this.position.add(points[0]+points[1]);
		i.add(Integer.parseInt(points[0]));
		j.add(Integer.parseInt(points[1]));
	}
	
	
	
		
	public ArrayList<String> getPosition() {
		return position;
	}
	public void setPosition(ArrayList<String> position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void reset(){
		position =new ArrayList<String>();
		i=new ArrayList<Integer>();
		j=new ArrayList<Integer>();
	}
	

}
