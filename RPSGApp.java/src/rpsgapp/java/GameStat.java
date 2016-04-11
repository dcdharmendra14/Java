/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpsgapp.java;

/**
 *
 * @author DHARMI
 */
import java.util.HashMap;

/****************************************************************

   CLASS:   GameStat
   AUTHOR:    Meka Dharmendra Chowdary
   NOTES:   Stores the game statistics
****************************************************************/
public class GameStat {
    private int userWins, computerWins, Ties;
    // Variables to store wins
    private HashMap<Integer, Integer> userGestureCounts = new HashMap<Integer, Integer>();
    //Hashmap to store user gesture counts
    private HashMap<Integer, Integer> computerGestureCounts = new HashMap<Integer, Integer>();
    //Hashmap to store computer gesture counts
 /****************************************************************

   CONSTRUCTOR:GameStat()

   ARGUMENTS:  NA

   NOTES:      initializes all private data members to null
****************************************************************/
    public GameStat()
    {
        userWins = 0;
        computerWins = 0;
        Ties = 0;
        userGestureCounts.put(1, 0); // user rock
        userGestureCounts.put(2, 0); // user paper
        userGestureCounts.put(3, 0); // user scissors
        computerGestureCounts.put(1, 0); //computer rock
        computerGestureCounts.put(2, 0); //computer paper
        computerGestureCounts.put(3, 0); //computer scissors
        
    }
    
 /****************************************************************

   FUNCTION:   update

   ARGUMENTS:  int,int,int,int,int

   RETURNS:    NA

   NOTES:      updates wins and gesture hash maps of user computer and tied games
****************************************************************/
    
    public void update(int computerWin, int userWin, int tie, int userGesture, int computerGesture)
    {
        if (computerWin == 1)  //incrementing
            computerWins++;     
        else if (userWin == 1)  //data members
            userWins++;
        else if (tie == 1)      //depending on win
            Ties++;
        switch (userGesture) { //updating hashmap of user gesture
            case 1: userGestureCounts.put(1, userGestureCounts.get(1) + 1);
                    break;
            case 2: userGestureCounts.put(2, userGestureCounts.get(2) + 1);
                    break;
            case 3: userGestureCounts.put(3, userGestureCounts.get(3) + 1);
                    break;
        }
        
        switch (computerGesture) { //updating hash map of computer gesture
            case 1: computerGestureCounts.put(1, computerGestureCounts.get(1) + 1);
                    break;
            case 2: computerGestureCounts.put(2, computerGestureCounts.get(2) + 1);
                    break;
            case 3: computerGestureCounts.put(3, computerGestureCounts.get(3) + 1);
                    break;
        }
    }
    
 /****************************************************************

   FUNCTION:   getWinner

   ARGUMENTS:  NA

   RETURNS:    String

   NOTES:      Returns the winner of overall game
****************************************************************/
    
    public String getWinner()
    {
        if (computerWins > userWins) //Computer won
        {
            return "Computer";
        }
        else if (userWins > computerWins) //user won
        {
            return "User";
        }
        else
        {       
            return "Game tied";  //tied
        }
    }   
   
    //gives the number of rounds user won
    public int getuserWins()
    {
        return userWins;
    }
    
    //gives the number of rounds Computer won
    public int getcomputerWins()
    {
        return computerWins;
    }
    
    //gives rounds tied
    public int getTies()
    {
        return Ties;
    }
    
    //returns hashmap pointer of usergestures
    public HashMap<Integer, Integer> getUserGestures()
    {
        return userGestureCounts;
    }
    
    //returns hashmap pointer of computer gestures
    public HashMap<Integer, Integer> getComputerGestures()
    {
        return computerGestureCounts;
    }
}
