/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadballapp;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author DHARMI
 */
/****************************************************************
   PROGRAM:   Thread Ball App program
   AUTHOR:    Meka Dharmendra Chowdary
   Z ID:      Z1751884

   FUNCTION:  Copies image on header tool by mouse click and pastes to desired grid by click.

   INPUT:     GUI

   OUTPUT:    GUI area

   NOTES:     TileDesignerLayout.java has the center panel code and TileCanvas.java has the code for painting
              AnimationPanel.java has animation panel code, BallAnimation.java has the logic for animation,
               and Ball.java has the code to construct a ball.
****************************************************************/
public class ThreadBallApp extends JFrame {

    /**
     * @param args the command line arguments
     */
    
   // call a class to design the GUI 
  TileDesignerLayout tiledesign = new TileDesignerLayout();
  BallAnimation ball1= new BallAnimation();
    public static void main(String[] args) {
        
        createAndShowGUI();
        // TODO code application logic here
    }

    private static void createAndShowGUI() {
      ThreadBallApp frame = new ThreadBallApp();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //set the size of frame
      frame.setSize(900, 600);
      //set visibility true
      frame.setVisible(true);
    }
    
    public ThreadBallApp()
{
  //sets the title  
  super("Thread Ball App");
  //set lay out to border layout
  setLayout(new BorderLayout());
  //add the tiledesign panel to center of frame
  add(tiledesign,BorderLayout.WEST);
        // TODO code application logic here
  add(ball1,BorderLayout.EAST);
  
 }//end of constructor
    
}
