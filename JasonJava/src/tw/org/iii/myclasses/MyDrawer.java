package tw.org.iii.myclasses;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JPanel;

public class MyDrawer extends JPanel {
	private LinkedList<LinkedList<Point>> lines, recycleBin;
	public MyDrawer() {
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
		
		//判斷g屬於DebugGraphics還是Graphics2D
//		if (g instanceof DebugGraphics) {
//			System.out.println("A");
//		}else if (g instanceof Graphics2D) {
//			System.out.println("B");
//		}
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(4));
		
		for (LinkedList<Point> line : lines) {
			for (int i = 1; i < line.size(); i++) {
	            Point p0 = line.get(i - 1);
	            Point p1 = line.get(i);
	            g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
	        }

		}
		
	}
	
	private class MyListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
//			System.out.println("press:" + e.getX() + ", " + e.getY());
			//使用者畫新線時清空recycleBin
			recycleBin.clear();
			LinkedList<Point> line = new LinkedList<>();
			Point point = new Point();
			point.x = e.getX(); point.y = e.getY();
			line.add(point);
			lines.add(line);
			repaint();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
//			System.out.println("drag:" + e.getX() + ", " + e.getY());
			LinkedList<Point> lastLine = lines.getLast();
			Point point = new Point();
			point.x = e.getX(); point.y = e.getY();
			lastLine.add(point);
			repaint();
		}
	}
}

class Point implements Serializable{
//	private int x, y;

//	public int getX() {
//		return x;
//	}
//
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public void setY(int y) {
//		this.y = y;
//	}
	public int x, y;
}