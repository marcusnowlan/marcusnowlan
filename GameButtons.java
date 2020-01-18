/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**
 * Buttons class that specifies the GUI buttons and their action
 * listeners for the game
 */
public class GameButtons extends JPanel {
    public static final int w = 800;
	public static final int h = 800;
	
	String gameStatus = "";
	JLabel gameMessage = new JLabel(gameStatus, JLabel.CENTER);
	
	String p1 = JOptionPane.showInputDialog(null, "Insert Player 1 Name:");
	String p2 = JOptionPane.showInputDialog(null, "Insert Player 2 Name:");
	String instructions = ("Welcome to Connect Four!" + 
						   "\nTo play this game, each player will take turns" +
						   "\ndropping chips into the board, using the Drop" +
						   "\nbuttons at the top of the board. Player 1 is" +
						   "\nis playing with red chips, while Player 2 is" +
						   "\nplaying with black chips. To win the game, you" +
						   "\nmust have 4 chips in a row, either vertically," +
						   "\nhorizontally, or diagonally. You can undo the " +
						   "\n last move with the Undo button, and you can " +
						   "\nsave/load games with the Save and Load buttons." +
						   "\nGood luck!");
	String winner = "Nobody";
	
	GameBoard gb = new GameBoard();
	
	JButton htp = new JButton("How to Play");
	JButton startNewGame = new JButton("New Game");
	JButton saveGame = new JButton("Save Game");
	JButton loadGame = new JButton("Load Game");
	JButton undo = new JButton("Undo");
	
	JButton c0 = new JButton("Drop");
	JButton c1 = new JButton("Drop");
	JButton c2 = new JButton("Drop");
	JButton c3 = new JButton("Drop");
	JButton c4 = new JButton("Drop");
	JButton c5 = new JButton("Drop");
	JButton c6 = new JButton("Drop");
	JButton c7 = new JButton("Drop");
	
	int turnVal = 1;
    
	public GameButtons() {
		gameMessage.setFont(new Font("Ariel", Font.BOLD, 30));
		JOptionPane.showMessageDialog(null, instructions, "How to Play:", 
									  JOptionPane.PLAIN_MESSAGE);
		
		
		startNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gb.newGame();
				repaint();
			}
		});
		
		htp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, instructions, "How to Play:",
											  JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		saveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File of = new File ("savedGame.txt");
				of.delete();
				File nf = new File ("savedGame.txt");
				String currentTurn = Integer.toString(turnVal);
				String chipPositions = gb.getChipPositions();
				try {
					FileWriter f = new FileWriter(nf);
					f.write(p1);
					f.write("\n" + p2);
					f.write("\n" + currentTurn);
					f.write("\n" + chipPositions);
					f.close();
					System.exit(0);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader f = new FileReader("savedGame.txt");
					BufferedReader b = new BufferedReader(f);
					p1 = b.readLine();
					p2 = b.readLine();
					String chipList = b.readLine();
					gb.putChipsIn(chipList);
					repaint();
					b.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gb.undo();
				if (gb.moves.size() != 0) {
					if (turnVal == 1) {
						turnVal = 2;
					} else {
						turnVal = 1;
					}
				}
				repaint();
			}
		});
		
		
		// Event listeners for each chip dropper:
		
		c0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gb.isWinner()) {
					if (gb.newChipPos(0) != -1) {
						gb.addChip(0, turnVal);
						if (turnVal == 1) {
							turnVal = 2;
						} else {
							turnVal = 1;
						}
						repaint();
					}
				}
			}
		});
		
		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gb.isWinner()) {
					if (gb.newChipPos(1) != -1) {
						gb.addChip(1, turnVal);
						if (turnVal == 1) {
							turnVal = 2;
						} else {
							turnVal = 1;
						}
						repaint();
					}
				}
			}
		});
		
		c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gb.isWinner()) {
					if (gb.newChipPos(2) != -1) {
						gb.addChip(2, turnVal);
						if (turnVal == 1) {
							turnVal = 2;
						} else {
							turnVal = 1;
						}
						repaint();
					}
				}
			}
		});
		
		c3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gb.isWinner()) {
					if (gb.newChipPos(3) != -1) {
						gb.addChip(3, turnVal);
						if (turnVal == 1) {
							turnVal = 2;
						} else {
							turnVal = 1;
						}
						repaint();
					}
				}
			}
		});
		
		c4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gb.isWinner()) {
					if (gb.newChipPos(4) != -1) {
						gb.addChip(4, turnVal);
						if (turnVal == 1) {
							turnVal = 2;
						} else {
							turnVal = 1;
						}
						repaint();
					}
				}
			}
		});
		
		c5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gb.isWinner()) {
					if (gb.newChipPos(5) != -1) {
						gb.addChip(5, turnVal);
						if (turnVal == 1) {
							turnVal = 2;
						} else {
							turnVal = 1;
						}
						repaint();
					}
				}
			}
		});
		
		c6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gb.isWinner()) {
					if (gb.newChipPos(6) != -1) {
						gb.addChip(6, turnVal);
						if (turnVal == 1) {
							turnVal = 2;
						} else {
							turnVal = 1;
						}
						repaint();
					}
				}
			}
		});
		
		c7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gb.isWinner()) {
					if (gb.newChipPos(7) != -1) {
						gb.addChip(7, turnVal);
						if (turnVal == 1) {
							turnVal = 2;
						} else {
							turnVal = 1;
						}
						repaint();
					}
				}
			}
		});
		
	}
	
	// Override paintComponent and getPreferredSize
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, w, h);
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (gb.getChipColor(x, y) == 0) {
					g.setColor(Color.WHITE);
					g.fillOval(100*y, 100*x, 100, 100);
				} else if (gb.getChipColor(x, y) == 1) {
					g.setColor(Color.RED);
					g.fillOval(100*y, 100*x, 100, 100);
				} else {
					g.setColor(Color.BLACK);
					g.fillOval(100*y, 100*x, 100, 100);
				}
			}
		}
			
		if (gb.isWinner()) {
			if (turnVal == 1) {
				gameStatus = (p2 + " wins!");
			} else {
				gameStatus = (p1 + " wins!");
			}
		} else if (gb.isFull()) {
			gameStatus = "Tie game!";
		} else if (turnVal == 1) {
			gameStatus = (p1 + "'s turn");
		} else {
			gameStatus = (p2 + "'s turn");
		}
			
		gameMessage.setText(gameStatus);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(w, h);
	}
}