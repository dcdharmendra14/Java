/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiledesigner;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author DHARMI
 */
/****************************************************************
   PROGRAM:   Tile canvas program

   AUTHOR:    Meka Dharmendra Chowdary
   Z ID:      Z1751884


   FUNCTION:  Copies image on header tool by mouse click and pastes to desired grid by click.

   INPUT:     GUI

   OUTPUT:    GUI area

   NOTES:     TileDesignerLayout.java has the center panel code and TileCanvas.java has the code for painting
****************************************************************/
public class TileDesigner extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
     createAndShowGUI();
    }
    //creates the gui
    public static void createAndShowGUI()
    {
      //create a self instance
      TileDesigner frame = new TileDesigner();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //set the size of frame
      frame.setSize(400, 400);
      //set visibility true
      frame.setVisible(true);
    }
  //constructor for class
public TileDesigner()
{
  //sets the title  
  super("Tile Canvas");
 // call a class to design the GUI 
  TileDesignerLayout tiledesign = new TileDesignerLayout();
  //set lay out to border layout
  setLayout(new BorderLayout());
  //add the tiledesign panel to center of frame
  add(tiledesign,BorderLayout.CENTER);
        // TODO code application logic here
 }//end of constructor
 

}//end of class