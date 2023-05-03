package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.util.Timer;

import javax.swing.JFrame;

import tw.org.iii.myclasses.MyPanel;

public class BallGame extends JFrame {
	private MyPanel myPanel;
 
 
	public BallGame() {
		super("Ball Game");
  
		setLayout(new BorderLayout());
		myPanel = new MyPanel();
		add(myPanel,BorderLayout.CENTER);
  
		setSize(800,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BallGame();

	}
	
}