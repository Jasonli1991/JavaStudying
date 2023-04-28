package tw.org.iii.tutor;

import javax.swing.JOptionPane;

public class Jason03_showDialogCount {

	public static void main(String[] args) {
		String strX = JOptionPane.showInputDialog("x = ?");
		String strY = JOptionPane.showInputDialog("y = ?");
		
		int x = Integer.parseInt(strX);
		int y = Integer.parseInt(strY);
		
		int r = x + y;
		
		JOptionPane.showMessageDialog(null, 
				String.format("%d + %d = %d", x, y, r));
	}

}
