/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadballapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author DHARMI
 */
class BallAnimation extends JFXPanel implements ActionListener{
    
    private JButton StartBtn = new JButton("Start"); //start/stop Button array
    private JButton StopBtn = new JButton("Stop");
    AnimationPanel animationPan1 = new AnimationPanel(); //creates the top animation panel where balls will be
    String bip = "NiuSong.wav";
    Media hit = new Media(Paths.get("NiuSong.wav").toUri().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(hit);
    
    
    
    BallAnimation()
    {
        //set layout
        this.setLayout(new BorderLayout());
        //set flowlayout for buttons
        JPanel ButtonPanel = new JPanel(new FlowLayout());
        //add start btn
        ButtonPanel.add(StartBtn);
        //add stop btn
        ButtonPanel.add(StopBtn);
        //add button panel
        add(ButtonPanel,BorderLayout.SOUTH);
        //add animation panel
        add(animationPan1,BorderLayout.NORTH);
        //add action listeners
        StartBtn.addActionListener(this);
        StopBtn.addActionListener(this);
        StopBtn.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
          
        
            if (e.getSource()==StartBtn)
            {
                //start the balls
                animationPan1.startballs();
                 mediaPlayer.play();
                StartBtn.setEnabled(false);
                StopBtn.setEnabled(true);
            }
            
            else if(e.getSource() == StopBtn)
            {
                mediaPlayer.pause();
                //stop the balls
                animationPan1.stopballs();
                StartBtn.setEnabled(true);
                StopBtn.setEnabled(false);
            }
    
    }
    
}
