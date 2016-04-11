/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadballapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author DHARMI
 */
//class extends the jpanel
class TileDesignerLayout extends JPanel {
//string array to store image names    
static String[] imageStringNameA ={"pat1.gif","pat2.gif","pat3.gif","pat4.gif","pat5.gif","pat6.gif","pat7.gif","pat8.gif","pat9.gif"};
//simage array to store images
static Image[] imageA = new Image[9];
//buttons for images
private JButton patch1btn;
private JButton patch2btn;
private JButton patch3btn;
private JButton patch4btn;
private JButton patch5btn;
private JButton patch6btn;
private JButton patch7btn;
private JButton patch8btn;
private JButton patch9btn;
private JButton resetbtn;

//constructor for the class
public TileDesignerLayout()
{
    //change layout to border
     setLayout(new BorderLayout());
     //create a TileCanvas object
     TileCanvas centerTileCanvas1 = new TileCanvas(); //call class to make    center grid
     //add the object to panel at center
     add(centerTileCanvas1, BorderLayout.CENTER);
     //call the method to clear grids
     centerTileCanvas1.ResetGridTile();//call methods in other class to set stuff up
     //add a mouse listener
     centerTileCanvas1.CreateMouseListener();
     //load images in to array
     centerTileCanvas1.LoadImageArray();
     //create a panel to add reset button
     JPanel ResPanel = new JPanel(new FlowLayout());
     //declare a reset button
     resetbtn = new JButton("Reset");
     //add reset button to reset panel
     ResPanel.add(resetbtn);
     //adding reset panel to the jpanel
     add(ResPanel, BorderLayout.SOUTH);
          //(also add panel with reset button to SOUTH)
     
        //declaring a tool bar
        JToolBar tileToolBar = new JToolBar();	//create a tool bar
        //define buttons
         patch1btn = new JButton(new ImageIcon(imageA[0])); 
         patch2btn = new JButton(new ImageIcon(imageA[1]));
         patch3btn = new JButton(new ImageIcon(imageA[2]));
         patch4btn = new JButton(new ImageIcon(imageA[3]));
         patch5btn = new JButton(new ImageIcon(imageA[4]));
         patch6btn = new JButton(new ImageIcon(imageA[5]));
         patch7btn = new JButton(new ImageIcon(imageA[6]));
         patch8btn = new JButton(new ImageIcon(imageA[7]));
         patch9btn = new JButton(new ImageIcon(imageA[8]));
         //add buttons to tool bar
         tileToolBar.add(patch1btn); //add 1 button to toolbar
         tileToolBar.add(patch2btn);
         tileToolBar.add(patch3btn);
         tileToolBar.add(patch4btn);
         tileToolBar.add(patch5btn);
         tileToolBar.add(patch6btn);
         tileToolBar.add(patch7btn);
         tileToolBar.add(patch8btn);
         tileToolBar.add(patch9btn);
         //add tool bar to north of panel
         add(tileToolBar,BorderLayout.NORTH);
         //add action listers for buttons for setting selectedTile variable
	 patch1btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
           centerTileCanvas1.selectedTile = 0;
         }
     });
      
      patch2btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
           centerTileCanvas1.selectedTile = 1;
         }
     });
     
      patch3btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
           centerTileCanvas1.selectedTile = 2;
         }
     });
      
      patch4btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
           centerTileCanvas1.selectedTile = 3;
         }
     });
      
      patch5btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
           centerTileCanvas1.selectedTile = 4;
         }
     });
     
      resetbtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
           centerTileCanvas1.ResetGridTile();
         }
     });
      
        patch6btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
           centerTileCanvas1.selectedTile = 5;
         }
     });
      
      patch7btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
           centerTileCanvas1.selectedTile = 6;
         }
     });
      
      patch8btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
           centerTileCanvas1.selectedTile = 7;
         }
     });
     
      patch9btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
         centerTileCanvas1.selectedTile = 8;
         }
     });
      
}//end of constructor
    
}//end of 
