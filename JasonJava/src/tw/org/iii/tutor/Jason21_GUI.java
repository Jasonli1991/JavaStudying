package tw.org.iii.tutor;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Jason21_GUI extends JFrame{
	private JButton b1;
	
	public Jason21_GUI() {
		setTitle("我的視窗");
		
		setLayout(new FlowLayout());
		b1 = new JButton("按我");
		add(b1);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Jason21_GUI();
	}

}