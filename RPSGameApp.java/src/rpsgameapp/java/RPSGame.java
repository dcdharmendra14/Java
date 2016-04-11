/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpsgameapp.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/****************************************************************

   CLASS:   RPSGame
   AUTHOR:    Meka Dharmendra Chowdary
   Z ID:      Z1751884
   NOTES:   Has all the functionality of game. 
****************************************************************/
public class RPSGame {
    private  String[] gestureNamesAL = {"rock", "paper", "scissors"};
    //gestures list
    private ArrayList<Integer> userGestureHistoryAL = new ArrayList<Integer>();
    //to store user gestures
    private GameStat stats1 = new GameStat();
    // stats object to store game stats
    private int round = 0;
    //round initialised to 0
    private HashMap<Integer, Integer> TempComputer = new HashMap<Integer, Integer>();
    // Hash map to store user gesture stats
    private HashMap<Integer, Integer> TempUser = new HashMap<Integer, Integer>();
    //Hash map to store computer gesture stats
    /****************************************************************

   FUNCTION:   playOneRound

   ARGUMENTS:  integer

   RETURNS:    String

   NOTES:      Takes user choice and computer choice and displays the result.
****************************************************************/
    String playOneRound(int InUserChoice) throws FileNotFoundException
     {
         round++;
       userGestureHistoryAL.add(InUserChoice);
       //add user choice to list
       int Cchoice = getComputerChoice();
       //gets the computer choice
       System.out.println("User Choice is "+ getGesture(InUserChoice) + "   Computer choice is "+ getGesture(Cchoice));
       if(((InUserChoice - Cchoice +3)%3) == 0) // condition for tie
       {
           stats1.update(0,0,1,InUserChoice,Cchoice);
           return "Tie";
       }
       else if(((InUserChoice - Cchoice +3)%3) == 1) //condition for user win
       {
           stats1.update(0,1,0,InUserChoice,Cchoice);
           return "User Won";
       }
       else if(((InUserChoice - Cchoice +3)%3) == 2) //condition for computer win
       {
           stats1.update(1,0,0,InUserChoice,Cchoice);
           return "Computer Won";
       }
       return "cancelled"; //if everything fails
     }       
         
    /****************************************************************

   FUNCTION:   getComputerChoice

   ARGUMENTS:  NA

   RETURNS:    integer

   NOTES:     Gives computer choice depending on the round
****************************************************************/
    int getComputerChoice() throws FileNotFoundException
    {
        int CompChoice = 1;
        if(round ==1) // if 1st round
        {
          try
          {
           Scanner fileScanner = new Scanner(new File("ip.txt")); //open the file
           CompChoice = fileScanner.nextInt(); //get number from file
          }
          catch(FileNotFoundException e) //if file is not there
          {
           System.out.println("File doesnot exist");
          }
        }
        
        else if(round >1 && round <=4) //for rounds 1-4
        {
          Random rn = new Random(); //generate random number variable
          CompChoice = rn.nextInt(3) + 1 ; //get random number from 1-3
        }   
        
        else if(round >=5) //for round 5 and so on
        {
            CompChoice = userGestureHistoryAL.get(round - 2); // get users last rounds choice
        }
        
      return CompChoice; //return Computers choice
    }
    
    public GameStat getGameStat()
    {
        return stats1; // returns game stats object
    }

    public void displayUserGestures() //displays users gestures
    {
        TempUser = stats1.getUserGestures();
        System.out.println("User choices are  " + gestureNamesAL[0] + TempUser.get(1) +"  "+  gestureNamesAL[1] + TempUser.get(2) +"  "+ gestureNamesAL[2] + TempUser.get(3));
    }
    
    public void displayComputerGestures() //displays computer gestures
    {
        TempComputer = stats1.getComputerGestures();
        System.out.println("Computer choices are  " + gestureNamesAL[0] + TempComputer.get(1) +"  " +  gestureNamesAL[1] + TempComputer.get(2) +"  " + gestureNamesAL[2] + TempComputer.get(3));
    }
 /****************************************************************

   FUNCTION:   getGesture

   ARGUMENTS:  integer

   RETURNS:    String

   NOTES:      gives gesture name with integer
               1- Rock 2- Paper 3- Scissors
****************************************************************/
    public String getGesture(int a) 
    {
        switch(a)
        {
            case 1: return "Rock";
                   
            case 2: return "Paper";
                    
            case 3 : return "Scissors";  
        }
        return "Invalid Choice";
    }
}
