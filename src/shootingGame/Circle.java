package shootingGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;



public class Circle {

	private Point center;   // fields
	private int radius;
	
	

	/*
	 *  constructor
	 *  @param centre the center of the circle
	 *  @param radius the radius of the center
	 *  @param letter the letter that the circle holds
	 */

	public Circle(Point center, int radius,String letter) {

		this.center = center;

		this.radius = radius;
	

	}

	/*
	 * 
	 * Returns the area of this circle.
	 * @return the are of this circle
	 */

	public double getArea() {

		return Math.PI * Math.pow(this.radius, 2);

	}

	/*
	 *  Returns the circumference of this circle (distance around the circle).
	 *  @return the circumference of this circle (distance around the circle).
	 */

	public Point getCenter() {
		return center;
	}
	/*
	 * sets the center of the circle
	 * @param center of the circle
	 */
	public void setCenter(Point center) {
		this.center = center;
	}
	/*
	 * returns the circumference of the circle
	 * @return circumference of the circle
	 */
	public double getCircumference() {

		return 2 * Math.PI * this.radius;

	}
	
	/*
	 *  Returns whether the given point lies inside this circle.
	 *  @return whether the given point lies inside this circle.
	 */

	public boolean contains(Point p) {

		return this.center.distance(p) <= this.radius;

	}
	/*
	 *  Returns a text representation of this circle, such as(non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	// "Circle{center=(40, 100),radius=100}".

	public String toString() {
		return "Circle{center=" + this.center + ",radius=" + this.radius + "}";
	}
	
	/*
	 *  Draws this Circle onto a DrawingPanel.
	 *  @param g the graphics of the panel
	 */
    public void draw(Graphics g) {
    	Graphics2D g2 =(Graphics2D)g;
    	g2.setRenderingHint(
    		    RenderingHints.KEY_ANTIALIASING,
    		    RenderingHints.VALUE_ANTIALIAS_ON);
    		g2.setRenderingHint(
    		    RenderingHints.KEY_TEXT_ANTIALIASING,
    		    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    		

    	
    	Stroke oldStroke = g2.getStroke();
    	g2.setStroke(new BasicStroke(10));
    	g2.setColor(Color.BLACK);
    	g2.drawOval((int)center.getX() - radius, (int)center.getY() - radius, 2 * radius, 2 * radius);
    	g2.setStroke(oldStroke);		
	}
    
	/*
	 * removes the lines of the circle
	 */
	
	
	

	public int getRadius() {
		
		return this.radius;
	}
	public void setCentre(int x,int y){
		this.center=new Point(x,y);
	}
}
