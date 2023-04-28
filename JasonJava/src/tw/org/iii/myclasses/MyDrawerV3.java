package tw.org.iii.myclasses;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

public class MyDrawerV3 extends JPanel {
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines, recycleBin;
	public MyDrawerV3() {
		setBackground(Color.YELLOW);
		
		lines = new LinkedList<>();
		recycleBin = new LinkedList<>();
		
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}
	
	public void clear() {
		lines.clear();
		repaint();
	}
	public void undo() {
		if (lines.size()>0) {
			recycleBin.add(lines.removeLast());
			repaint();
		}
	}
	public void redo() {
		if (lines.size()>0) {
			lines.add(recycleBin.removeLast());
			repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(4));
		
		for (LinkedList<HashMap<String, Integer>> line : lines) {
			for (int i = 1; i < line.size(); i++) {
				HashMap<String, Integer> p0 = line.get(i - 1);
				HashMap<String, Integer> p1 = line.get(i);
	            g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
	        }

		}
		
	}
	
	private class MyListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			recycleBin.clear();
			LinkedList<HashMap<String, Integer>> line = 
				new LinkedList<>();
			
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			line.add(point);
			lines.add(line);

			repaint();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			
			lines.getLast().add(point);
			
			repaint();
		}
	}
}

