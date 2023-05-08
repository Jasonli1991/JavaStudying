package tw.org.iii.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import tw.org.iii.myclasses.MyTable;

public class JDBC18 extends JFrame{
	private MyTable myTable;
	
	public JDBC18() {
		
		setLayout(new BorderLayout());
		
		try {
			myTable = new MyTable();
			JScrollPane jsp = new JScrollPane(myTable);
			add(jsp, BorderLayout.CENTER);
			
			setSize(800, 640);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		} catch (Exception e) {
			System.out.println(123);
		}
		

	}
	
	public static void main(String[] args) {
		new JDBC18();
	}

}
