package tw.org.iii.myclasses;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JPanel;

public class MyDrawerV2 extends JPanel {
	private LinkedList<Line> lines, recycleBin;
	private Color nowColor;
	private float strokeSize;
	
	
	public MyDrawerV2() {
		setBackground(Color.YELLOW);
		
		nowColor = Color.BLUE;
		lines = new LinkedList<>();
		recycleBin = new LinkedList<>();
		strokeSize = 4f; // 初始筆刷粗細為 4
		
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}
	
	public Color getColor() {
		return nowColor;
	}
	
	public void setColor(Color color) {
		nowColor = color;
	}
	
	public float getStrokeSize() {
        return strokeSize;
    }
	
	public void setStrokeSize(float strokeSize) {
        this.strokeSize = strokeSize;
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
	
	//存檔
	public boolean saveLines(String fname) {
		//若class方法AutoCloseable
		//括號中處理AutoCloseable的敘述句,可多道
		try (FileOutputStream fin = new FileOutputStream(fname);
				ObjectOutputStream oout = new ObjectOutputStream(fin)){
			oout.writeObject(lines);
			oout.flush();
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	//讀檔
	public boolean loadLines(String fname) {
		try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream(fname))) {
			lines =(LinkedList<Line>)oin.readObject();
			repaint();
			recycleBin.clear();
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
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
		
		for (Line line : lines) {
			g2d.setColor(line.getColor());
			g2d.setStroke(new BasicStroke(line.getStrokeSize()));
			
			for (int i = 1; i < line.size(); i++) {
	            Point p0 = line.getPoint(i - 1);
	            Point p1 = line.getPoint(i);
	            g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
	        }

		}
		
	}
	
	private class MyListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
//			System.out.println("press:" + e.getX() + ", " + e.getY());
//			使用者畫新線時清空recycleBin
			recycleBin.clear();
			Line line = new Line(nowColor, strokeSize);
			Point point = new Point();
			point.x = e.getX(); point.y = e.getY();
			line.addPoint(point);
			lines.add(line);
			repaint();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
//			System.out.println("drag:" + e.getX() + ", " + e.getY());
			Point point = new Point();
            point.x = e.getX(); point.y = e.getY();

            lines.getLast().addPoint(point);

            repaint();
		}
	}
}

class Line implements Serializable{
	private Color color;
	private LinkedList<Point> points;
	private float strokeSize;
	Line(Color color, float strokeSize) {
		this.color = color;
		this.strokeSize = strokeSize;
		points = new LinkedList<>();
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
//	public LinkedList<Point> getPoints() {
//		return points;
//	}
//	public void setPoints(LinkedList<Point> points) {
//		this.points = points;
//	}
	
	public float getStrokeSize() {
        return strokeSize;
    }

    public void setStrokeSize(float strokeSize) {
        this.strokeSize = strokeSize;
    }
	
	public void addPoint(Point point) {
		points.add(point);
	}
	
	public Point getPoint(int index) {
		return points.get(index);
	}
	
	public int size() {
		return points.size();
	}
	
	
}