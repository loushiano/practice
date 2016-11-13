package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
	
public class User {
	private String name; 
	private ArrayList<Integer> i;
	private ArrayList<Integer> j;
	public User(String s){
		setName(s);
		
		i=new ArrayList<Integer>();
		j=new ArrayList<Integer>();
	}
	public void addPlayedTurn(String position){
		String points[]=position.split(" ");
		i.add(Integer.parseInt(points[0]));
		j.add(Integer.parseInt(points[1]));
		
	}
	public boolean CheckForStraighLine(){
		if(i.size()<3){
			return false;
		}
		if(alltheSame(i)){
			System.out.println("1");
			return true;
		}
		if(alltheSame(j)){
			System.out.println("2");
			return true;
		}
		if(differenceOne(i) && differenceOne(j)){
			System.out.println("3");
			return true;
		}
		
		return false;	
	}
	private boolean differenceOne(ArrayList<Integer> i2) {
		int array[]=new int[i2.size()];
		for(int i=0;i<i2.size();i++){
			array[i]=i2.get(i);
	}
		Arrays.sort(array);
		for(int i=0;i<array.length-1;i++){
			if (array[i+1]-array[i]!=1){
				return false;
			}
		}
		return true;
	}
	private boolean alltheSame(ArrayList<Integer> j2) {
		int check=j2.get(0);
		for(int i=1;i<j2.size();i++){
			if(check!=j2.get(i)){
				return false;
			}
		}
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void reset(){
		i=new ArrayList<Integer>();
		j=new ArrayList<Integer>();
	}

}
