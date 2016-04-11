/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpsgameapp.java;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Set;
/**
 *
 * @author DHARMI
 */
/****************************************************************
   PROGRAM:   Rock Paper Scissors Game
   AUTHOR:    Meka Dharmendra Chowdary
   Z ID:      Z1751884

   FUNCTION:  Takes input from user and displays the winner.

   INPUT:     1 for Rock , 2 for Paper, 3 for Scissors

   OUTPUT:    Game results and list of games played with results

   NOTES:     RPSGame.java has the code functionality and GameStat.java takes care of game statistics.
****************************************************************/
public class RPSGameAppJava {
    
  
    public static void main(String[] args) throws FileNotFoundException, Exception {
        System.out.println("Welcome to Rock/Paper/Scissors game");
        System.out.println("Let us start one game ");
        //Welcome text
        Scanner scanner = new Scanner(System.in);
        //To input from user
        HashMap<String, GameStat> gameStats = new HashMap<>();
        // To store game stats
        
        int GFlag = 1;
        //loops till you dont want to play game
        while(GFlag == 1)
      {   
        System.out.println("Enter number of rounds: ");
        int maxRound = scanner.nextInt();
        //takes number of rounds you want to play
        int round=1;
        int Uchoice;
        // round to calculate rounds, Uchoice to store users choice
        RPSGame game1= new RPSGame();
        //new up a game
        GameStat Temp= new GameStat();
        // Temperory object to get Game stats
        while(round <= maxRound)
        {
          System.out.println("Round : "+round);
          System.out.println("Pick a gesture 1)Rock 2)Paper 3)Scissors");
          try
          {
            Uchoice = scanner.nextInt();
            //gets user choice
            if(Uchoice >3 || Uchoice<=0) //if user choice invalid
            {
             throw new Exception("Enter only number 1 or 2 or 3");
             //throws exception if number is out of boundary
            }
            String result= game1.playOneRound(Uchoice);
            //gets the result of game
            System.out.println("Result =  " + result);
            //prints result
          }
          catch(InputMismatchException e) // catch block if user enter characters 
          {
              System.out.println("Enter only numbers from 1-3");
              round--; // to replay round
              scanner.nextLine(); // resets scanner
          }
          catch (Exception e) // catches generic exception
          {
              System.out.println(e.getMessage());
              round--;
              scanner.nextLine();
          }
          round++; 
        }
        System.out.println("******************End of the game******************************");
        Temp = game1.getGameStat();
        //get gamestats and store in Temp
        System.out.println("******************Game Statistics are *************************");
        System.out.println("Games user won  " + Temp.getuserWins() );
        game1.displayUserGestures();
        //display user stats
        System.out.println("Games computer won  "+ Temp.getcomputerWins() );
        game1.displayComputerGestures();
        //display computer stats
        System.out.println("Games tied  " + Temp.getTies());
        System.out.println("Overall result =  " + Temp.getWinner());
        Date startDate = new Date();
        // date and time to push game stats in to hashmap
        gameStats.put(startDate.toString(), game1.getGameStat());
        System.out.println("Want to play another game ? (Y/N)");
        String Gchoice = scanner.next();
        //get user choice of playing another game
        if("N".equals(Gchoice) || "n".equals(Gchoice))
            GFlag=0;//stops the loop
      }
      System.out.println("******************Summary of games played *************************\n"); 
      Set setOfKeys = gameStats.keySet();
      //get values to print hashmap
      Iterator iterator = setOfKeys.iterator();
      //iterator to go through hashmap
      while (iterator.hasNext()) //till the last key in hashmap
       {
         String key = (String) iterator.next(); // convert key to string
         System.out.println("Time :"+ key +"    Result = "+ (gameStats.get(key).getWinner()));
        // Display result
       }
    }
}
