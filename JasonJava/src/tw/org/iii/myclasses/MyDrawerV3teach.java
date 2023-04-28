package tw.org.iii.myclasses;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawerV3teach extends JPanel {
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines, recycleBin;
	
	public MyDrawerV3teach() {
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
		if (recycleBin.size() > 0) {
			lines.add(recycleBin.removeLast());
			repaint();
		}
	}
	
	public boolean saveLines(String fname) {
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
	
	public boolean loadLines(String fname) {
		try (ObjectInputStream oin = 
			new ObjectInputStream(
				new FileInputStream(fname))){
			lines = (LinkedList<LinkedList<HashMap<String, Integer>>>)oin.readObject();
			repaint();
			recycleBin.clear();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public void saveJPEG() {
		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		paint(g2d);
		
		try {
			ImageIO.write(img, "jpeg", new File("dir1/lines.jpg"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(4));
		
		for (LinkedList<HashMap<String,Integer>> line : lines) {
			for (int i=1; i<line.size(); i++) {
				HashMap<String, Integer> p0 = line.get(i-1);
				HashMap<String, Integer> p1 = line.get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), 
						p1.get("x"), p1.get("y"));
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
