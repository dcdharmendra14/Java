/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadballapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author DHARMI
 */
class Ball {

    Color color; //The Color of the ball. 
    int radius; //The radius of the ball (integer). 
    int x, y; //The x and y coordinates of the ball�s center point (integers). 
	
    int dx; //the amount of change in the ball�s x coordinate each time the ball moves.
	//A negative value means the ball is currently moving to the left;
	//a positive value means the ball is currently moving to the right. 
	
    int dy; //the amount of change in the ball�s y coordinate each time the ball moves.
	//A negative value	means the ball is currently moving up;
	//a positive value means the ball is currently moving down.

    
    
    Ball(Color bColor, int bRadius, int bX, int bY, int bDx, int bDy) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      color = bColor; 
      radius = bRadius;
      x = bX;
      y = bY;
      dx = bDx;
      dy = bDy;
    }

   public void move(Dimension dPanel) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      //dim of the panel is passed in..used from get size
//this updates the x and y of where to move to on panel
//and changes directions (dx,dy) if needed    
//Has one parameter, a Dimension object that contains the width
//and height of the panel in which the ball is moving. Does the following: 
		 
//If the x coordinate of the ball is less than or equal its radius OR
//greater than or equal to the width of the panel minus the radius of the ball,

//reverse the horizontal direction of the ball (i.e., change the sign for dx).
  if ((x <= radius) || (x >= (dPanel.width - radius)))
  {
    dx=-dx; //change sign
  }
			
		
   x += dx; //adjust new x in the ball.
   
   if ((y <= radius) || (y >= (dPanel.height - radius)))
  {
    dy=-dy; //change sign
  }
			
		
   y += dy; //adjust new y in the ball.
 
}

   public void draw(Graphics g) {
       
      g.setColor(color);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     g.fillOval(x - radius, y-radius, 2*radius, 2*radius);
   }
    
}
