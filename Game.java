/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
    public void run() {
        // Top-level frame in which game components live
        final JFrame frame = new JFrame("Connect Four");
        frame.setLayout(null);
		frame.setLocation(1, 1);
        frame.setSize(1000, 1000);
		
		final GameButtons allButtons = new GameButtons();
		frame.add(allButtons);
		allButtons.setBounds(0, 200, 1000, 800);
		
		frame.add(allButtons.gameMessage);
		allButtons.gameMessage.setBounds(200, 0, 500, 100);
		
		frame.add(allButtons.htp);
		allButtons.htp.setBounds(850, 200, 100, 100);
		frame.add(allButtons.startNewGame);
		allButtons.startNewGame.setBounds(850, 300, 100, 100);
		frame.add(allButtons.saveGame);
		allButtons.saveGame.setBounds(850, 400, 100, 100);
		frame.add(allButtons.loadGame);
		allButtons.loadGame.setBounds(850, 500, 100, 100);
		frame.add(allButtons.undo);
		allButtons.undo.setBounds(850, 600, 100, 100);
		
		frame.add(allButtons.c0);
		allButtons.c0.setBounds(0, 100, 100, 100);
		frame.add(allButtons.c1);
		allButtons.c1.setBounds(100, 100, 100, 100);
		frame.add(allButtons.c2);
		allButtons.c2.setBounds(200, 100, 100, 100);
		frame.add(allButtons.c3);
		allButtons.c3.setBounds(300, 100, 100, 100);
		frame.add(allButtons.c4);
		allButtons.c4.setBounds(400, 100, 100, 100);
		frame.add(allButtons.c5);
		allButtons.c5.setBounds(500, 100, 100, 100);
		frame.add(allButtons.c6);
		allButtons.c6.setBounds(600, 100, 100, 100);
		frame.add(allButtons.c7);
		allButtons.c7.setBounds(700, 100, 90, 100);
		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    /**
     * Main method run to start and run the game. Initializes the GUI elements specified in Game and
     * runs it. IMPORTANT: Do NOT delete! You MUST include this in your final submission.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}