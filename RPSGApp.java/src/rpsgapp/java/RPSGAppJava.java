/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpsgapp.java;

/****************************************************************
   PROGRAM:   Rock Paper Scissors Game
   AUTHOR:    Meka Dharmendra Chowdary
   FUNCTION:  Takes input from user and displays the winner.

   INPUT:     GUI

   OUTPUT:    GUI area

   NOTES:     RPSGame.java has the code functionality and GameStat.java takes care of game statistics.
****************************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author DHARMI
 */
public class RPSGAppJava extends JFrame implements ActionListener,ListSelectionListener  {
    
    

    /**
     * @param args the command line arguments
     */
    //hash map for gamestats
    private HashMap<String, GameStat> gameStats = new HashMap<String, GameStat>();
    //user choice
    private int Uchoice = 1;
    //list of all the buttons
    private final JButton startGameBtn = new JButton("Start New Game"); //several buttons needed
    private final JButton stopGameBtn = new JButton("Stop");
    private final JRadioButton RockBtn = new JRadioButton("ROCK");
    private final JRadioButton PaperBtn = new JRadioButton("PAPER");
    private final JRadioButton ScissorsBtn = new JRadioButton("SCISSORS");
    private final JButton GoBtn = new JButton("GO");
//these 4 lines are for upper left jlist of games in a jscrollpanel
    private final DefaultListModel<String> model = new DefaultListModel<String>(); 
    private final JList<String> finishedGamesList = new JList<String>(model);
    private final JScrollPane gamesListPane = new JScrollPane(finishedGamesList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
      

    //text area tto display output
    private JTextArea roundResultsTA = new JTextArea(15, 35);  //these 2 lines are for lower right output area showing a round played
    //adding text area to scroll pane
    private JScrollPane outputAreaPaneScroll = new JScrollPane(roundResultsTA);

    //list of all text fields
    private JTextField CrockTextF = new JTextField();
    private JTextField UrockTextF = new JTextField();
    private JTextField CpaperTextF = new JTextField();
    private JTextField UpaperTextF = new JTextField();
    private JTextField CscissorsTextF = new JTextField();
    private JTextField UscissorsTextF = new JTextField();
    private JTextField TiesTextF = new JTextField(5);
    private JTextField WinnerTextF = new JTextField(5);
//setting game object to null
private RPSGame  currentGameRPS = null;                              

    public static void main(String[] args) {
        // TODO code application logic here
        createAndShowGUI();
    }
    
    public static void createAndShowGUI() {
     RPSGAppJava frame1 = new RPSGAppJava(); //new up  this class, & call constructor, --due to extends, it is a frame
     frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
     frame1.pack();
      frame1.setVisible(true);
    }
    
    RPSGAppJava(){                           //constructor where the GUI is built and added to frame, lots of code here
super("Rock Paper Scissors");                   //call frame class constructor,recommended by java
setSize(1500, 800);
setLayout(new BorderLayout());               //set layout for frame 

                            
//create and add west panel
JPanel WestPanel= new JPanel(new BorderLayout()); //then set color, borders on panel1
WestPanel.setBackground(Color.BLUE);
                   
// add  scroll pane to north region of west panel
 //adding games list panel to west panel
 WestPanel.add(gamesListPane, BorderLayout.NORTH);
 gamesListPane.setBackground(Color.BLUE);
 //grid lay out for statistics
 JPanel StatsPanel = new JPanel(new BorderLayout());
 JPanel CountPanel = new JPanel(new GridLayout(3,4));
 CountPanel.setBackground(Color.YELLOW);
 //addign labels and text fields
 CountPanel.add(new JLabel("        ")); //how to add a blank label to a panel
 CountPanel.add(new JLabel("ROCK"));
 CountPanel.add(new JLabel("PAPER"));
 CountPanel.add(new JLabel("SCISSORS"));
 CountPanel.add(new JLabel("USER"));
 CountPanel.add(UrockTextF);
 CountPanel.add(UpaperTextF);
 CountPanel.add(UscissorsTextF);
 CountPanel.add(new JLabel("COMPUTER "));
 CountPanel.add(CrockTextF);
 CountPanel.add(CpaperTextF);
 CountPanel.add(CscissorsTextF);
 //adding results panel
 JPanel ResultsPanel = new JPanel(new GridLayout(2,2));
 ResultsPanel.setBackground(Color.YELLOW);
 //addign labels and text fields
 ResultsPanel.add(new JLabel("TIES"));
 ResultsPanel.add(TiesTextF);
 ResultsPanel.add(new JLabel("WINNER IS"));
 ResultsPanel.add(WinnerTextF);
 JPanel SpacePanel = new JPanel(new BorderLayout());
 StatsPanel.add(CountPanel, BorderLayout.NORTH );
 StatsPanel.add(ResultsPanel, BorderLayout.SOUTH );
 //addign stats panel to west panel
 WestPanel.add(StatsPanel, BorderLayout.SOUTH);
 //addign west panel to frame
 add(WestPanel, BorderLayout.WEST);
 //defining east panel
 JPanel EastPanel= new JPanel(new BorderLayout());
 JPanel ControlPanel= new JPanel(new GridLayout(2,1));
 JPanel StartPanel= new JPanel(new FlowLayout());
 StartPanel.setBackground(Color.LIGHT_GRAY);
 //addign buttons to start panel
 startGameBtn.setBackground(Color.GREEN);
 stopGameBtn.setBackground(Color.RED);
 StartPanel.add(startGameBtn);
 StartPanel.add(stopGameBtn);
 //addign start to control
 ControlPanel.add(StartPanel);
 JPanel InputChoicePanel= new JPanel(new FlowLayout());
 InputChoicePanel.setBackground(Color.BLUE);
 //adding buttons tp inputchoice panel
 RockBtn.setBackground(Color.YELLOW);
 PaperBtn.setBackground(Color.YELLOW);
 ScissorsBtn.setBackground(Color.YELLOW);
 GoBtn.setBackground(Color.cyan);
 InputChoicePanel.add(RockBtn);
 InputChoicePanel.add(PaperBtn);
 InputChoicePanel.add(ScissorsBtn);
 InputChoicePanel.add(GoBtn);
 ControlPanel.add(InputChoicePanel);
 //addign control panel to east panel
 EastPanel.add(ControlPanel,BorderLayout.NORTH );
 EastPanel.add(outputAreaPaneScroll,BorderLayout.SOUTH );
 //addign eastpanel to frame
 add(EastPanel, BorderLayout.EAST);
 //disabling buttons
 RockBtn.setEnabled(false);
 PaperBtn.setEnabled(false);
 ScissorsBtn.setEnabled(false);
 GoBtn.setEnabled(false);
 stopGameBtn.setEnabled(false);
 //adding action and selction listeners
 finishedGamesList.addListSelectionListener(this);
 startGameBtn.addActionListener(this);
 stopGameBtn.addActionListener(this);
 RockBtn.addActionListener(this);
 PaperBtn.addActionListener(this);
 ScissorsBtn.addActionListener(this);
 GoBtn.addActionListener(this);
 //stopGameBtn.addActionListener(this);
 
 }



//overriding action performed funtion
    @Override
    public void actionPerformed(ActionEvent e) {
        //if start button is clicked
          if (e.getSource()==startGameBtn)
          {
              //if a game to be saved is pending 
              if (currentGameRPS != null)       //this means we are finishing a game that was just completed
              {    
                  Date startDate = new Date();
                  //add stats object to hash map
                  gameStats.put(startDate.toString(), currentGameRPS.getGameStat());
                  model.addElement(startDate.toString());
                  //display results on gui
                  DisplayTextFields(startDate.toString());
                  //new up the game
                  currentGameRPS = new RPSGame();
                  RockBtn.setEnabled(true);
                  PaperBtn.setEnabled(true);
                  ScissorsBtn.setEnabled(true);
                  GoBtn.setEnabled(true);
                  roundResultsTA.setText(" ");
                  stopGameBtn.setEnabled(true);
                  
               }
              else
              {
                       //we are starting first game
                       currentGameRPS = new RPSGame();
                       RockBtn.setEnabled(true);
                       PaperBtn.setEnabled(true);
                       ScissorsBtn.setEnabled(true);
                       GoBtn.setEnabled(true);
                       roundResultsTA.setText(" ");
                       stopGameBtn.setEnabled(true);
                       //enable buttons for user
               }
            }
          //if stop button is clicked
          else if(e.getSource() == stopGameBtn)
          {
                  Date startDate = new Date();
                  //save gamestats
                  gameStats.put(startDate.toString(), currentGameRPS.getGameStat());
                  //add to gui list
                  model.addElement(startDate.toString());
                  DisplayTextFields(startDate.toString()); 
                  //set game to null
                  currentGameRPS = null;
                  stopGameBtn.setEnabled(false);
                  GoBtn.setEnabled(false);
                  RockBtn.setEnabled(false);
                  PaperBtn.setEnabled(false);
                  ScissorsBtn.setEnabled(false);
          }
                //if rock button is clicked  
          else if(e.getSource() == RockBtn)
          {
            Uchoice = 1;
            PaperBtn.setSelected(false);
            ScissorsBtn.setSelected(false);
          }
          //if paper button is selected
          else if(e.getSource() == PaperBtn)
          {
            Uchoice = 2;
            RockBtn.setSelected(false);
            ScissorsBtn.setSelected(false);
          }
          //if scissors button is selected
          else if(e.getSource() == ScissorsBtn)
          {
            Uchoice = 3;
            PaperBtn.setSelected(false);
            PaperBtn.setSelected(false);
          }
          //ig go button is clicked
          else if(e.getSource() == GoBtn)
          {
              try {
                  //play game using the user choice
                  roundResultsTA.append(currentGameRPS.playOneRound(Uchoice));
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(RPSGAppJava.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          
                  
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //override method for selection list click
    @Override
    public void valueChanged(ListSelectionEvent e) {
        //if something is clicked
        if (!finishedGamesList.isSelectionEmpty())
          {
              //get the selected value
            String  key = (String)finishedGamesList.getSelectedValue()  ;  
            //pass it to get stats and display on gui
            DisplayTextFields(key);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }
    
}

    //function to display stats on gui.
public void DisplayTextFields(String k)
{
           //hash map for computer gestures and user gestures
           HashMap<Integer, Integer> TempComputer = new HashMap<Integer, Integer>();
           HashMap<Integer, Integer> TempUser = new HashMap<Integer, Integer>();
                //get the date key that the user has chosen in listbox
           GameStat Temp = gameStats.get(k);
           TempComputer = Temp.getComputerGestures();
           TempUser = Temp.getUserGestures();
           CrockTextF.setText(Integer.toString(TempComputer.get(1)));  //how to put text in the text field for rock
           CrockTextF.setFont( new Font("SansSerif", Font.BOLD, 18));  //gives you large bold fon
           CpaperTextF.setText(Integer.toString(TempComputer.get(2)));  //how to put text in the text field for rock
           CpaperTextF.setFont( new Font("SansSerif", Font.BOLD, 18));
           CscissorsTextF.setText(Integer.toString(TempComputer.get(3)));  //how to put text in the text field for rock
           CscissorsTextF.setFont( new Font("SansSerif", Font.BOLD, 18));
           UrockTextF.setText(Integer.toString(TempUser.get(1)));  //how to put text in the text field for rock
           UrockTextF.setFont( new Font("SansSerif", Font.BOLD, 18));  //gives you large bold fon
           UpaperTextF.setText(Integer.toString(TempUser.get(2)));  //how to put text in the text field for rock
           UpaperTextF.setFont( new Font("SansSerif", Font.BOLD, 18));
           UscissorsTextF.setText(Integer.toString(TempUser.get(3)));  //how to put text in the text field for rock
           UscissorsTextF.setFont( new Font("SansSerif", Font.BOLD, 18));
           TiesTextF.setFont(new Font("SansSerif", Font.BOLD, 18));
           TiesTextF.setText(Integer.toString(Temp.getTies()));
           WinnerTextF.setFont(new Font("SansSerif", Font.BOLD, 18));
           WinnerTextF.setText(Temp.getWinner());
}

}