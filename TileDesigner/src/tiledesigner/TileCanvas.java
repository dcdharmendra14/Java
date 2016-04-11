/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiledesigner;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import static tiledesigner.TileDesignerLayout.imageA;
import static tiledesigner.TileDesignerLayout.imageStringNameA;

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
//class that extends JPanel and implements mouselistner
class TileCanvas extends JPanel implements MouseListener {
    //declare a tike selection variable
    int selectedTile = -1;
    //declar and initialize square side to 25
    static final int squareSide = 25; 
    //declare columns and rows
    int GridRow =8 ,GridCol=8;
    //declare an 2d image array of size col*rows
    Image[][] gif2dArray = new Image[GridRow][GridCol];// drawn on grid when we paint
    //width of grid
   int  gridWidth = GridCol*squareSide;
   //height of grid
   int  gridHeight = GridRow*squareSide;
   //get width of panel
   int panelWidth = getWidth();
   //get height of panel
   int panelHeight = getHeight();
   //calculate start of panel.
   int startX = (panelWidth - gridWidth)/2;
   int startY = (panelHeight - gridHeight)/2;

    //function to load images to image array
    public void LoadImageArray()
    {
        for(int i=0; i<9; i++ )
        imageA[i] = Toolkit.getDefaultToolkit().getImage(imageStringNameA[i]);//get images from tool kit
    }
    
    //resets the grids
    public void ResetGridTile()
    {
        for(int row = 0; row<GridRow; row++)
        { 
            for(int col=0; col<GridCol; col++) 
             gif2dArray[row][col] = null;//assigns null to array
        }
        selectedTile = -1;
        this.repaint();//repaints the grid
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
       int x = e.getX();//gets x
       int y = e.getY();//gets y
        if(x >= startX && x <= startX+gridWidth && y >= startY && y <= startY+gridWidth)
       {
        int xIndex = (x-startX)/squareSide; //will be an integer of square clicked
        int yIndex = (y-startY)/squareSide; //wil be an integer of squear clicked      
        //            col      row     
        if(selectedTile != -1)
        gif2dArray[xIndex][yIndex] = imageA[selectedTile];
        this.repaint();  //show new grid
       }
       
    }

    @Override
   public void paintComponent(Graphics g)
   {
       int row,col;
       super.paintComponent(g);
       panelWidth = getWidth();
       panelHeight = getHeight();
       startX = (panelWidth - gridWidth)/2;
       startY = (panelHeight - gridHeight)/2;

     //Drawing empty grid of 5*5 with an inner outer loop
       for( row = 0; row<GridRow; row++ )
       {
         for( col = 0; col<GridCol; col++)    
           g.drawRect(startX+(squareSide*row), startY+(squareSide*col), squareSide, squareSide);
       }
 
      //copy gif image array over to the drawing grid with inner outer loop
     for( row = 0; row<GridRow; row++ )
     {
         for( col = 0; col<GridCol; col++) 
          g.drawImage(gif2dArray[row][col], startX+(squareSide*row), startY+(squareSide*col), this);
     }
     
     
   }
    
    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
   //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    void CreateMouseListener() {
        addMouseListener(this);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
