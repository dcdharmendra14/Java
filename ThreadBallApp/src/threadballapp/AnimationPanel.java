/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadballapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javafx.embed.swing.JFXPanel;
import javax.swing.JPanel;

/**
 *
 * @author DHARMI
 */
class AnimationPanel extends JFXPanel implements Runnable  {
    
private ArrayList<Ball> ballListAL = new ArrayList<Ball>();//An ArrayList of Ball objects. 
private Dimension ballPanelDim = null; //reference to a Dimension object that is initially set to null. 
private Thread ballPanelThread = null; //A reference to a Thread object that is initially set to null.
Image husky = Toolkit.getDefaultToolkit().getImage("huskie.gif");

   public AnimationPanel()
  {
      Dimension d = new Dimension(500,450); //later this is used in paint
      this.setPreferredSize(d);
  }

    

    @Override
    public void run() {
       //System.out.println("thread running"); 
     while(ballPanelThread != null)     
      {
       //The loop body should put the thread to sleep for a short amount of time
       //(100 milliseconds is about right), and then call repaint()
       //(which will eventually result in paintComponent() being executed).
       try {
	   Thread.sleep(70); //sleep 1 seconds,wake up and repaint
         } 
       catch (InterruptedException e) {
        e.printStackTrace();
       }
      repaint();
      }//endwhile thread

        
    }

    public void startballs() {
       // System.out.println("Start button clicked");
        if(ballPanelThread == null)
        {
            ballPanelThread = new Thread(this);
            ballPanelThread.start();
        }
    }

    public void stopballs() {
        ballPanelThread = null;
    }
    
@Override
    protected void paintComponent(Graphics g) 
     {
         super.paintComponent(g); //will clean off screen
         //If the Dimension object reference is null (first time through), create a set of Ball objects
         //and add them to the ArrayList, then get the dimensions of the panel.
         if (ballPanelDim == null)
         {
          ballPanelDim = this.getSize(); //fill in ball panel dimension of x and y 350 and 300 
          ballListAL.add(new Ball(Color.RED, 10, (ballPanelDim.width - 28), (ballPanelDim.height - 60), 8, -6));
          ballListAL.add(new Ball(Color.BLUE, 20, (ballPanelDim.width - 100), (ballPanelDim.height - 200), -6, -4));
          ballListAL.add(new Ball(Color.GREEN, 25, (ballPanelDim.width - 200), (ballPanelDim.height - 150), 4, 4));
          ballListAL.add(new Ball(Color.CYAN, 30, (ballPanelDim.width - 300), (ballPanelDim.height - 60), -3, 3));
         }
        this.setBackground(Color.BLACK); //this "clears" the screen to yellow
        g.drawImage(husky, ballPanelDim.width/3, ballPanelDim.height/3, this);
        for (Ball b : ballListAL)
        {
         b.move(ballPanelDim); //passing type dim to method, needs x and y
         b.draw(g); //passing g to the draw method
        }
    
     }

}