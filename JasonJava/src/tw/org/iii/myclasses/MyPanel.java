package tw.org.iii.myclasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private BufferedImage[] imgs ;
	private Timer timer;
	private int ballX,ballY,viewW,viewH,dx,dy;
	private LinkedList<BallTask> balls;
	//viewH,W 為視窗大小
 
	public MyPanel() {
		setBackground(Color.YELLOW);
  
		try {
			imgs = new BufferedImage[4];
			imgs[0] = ImageIO.read(new File("dir2/ball1.png"));
			imgs[1] = ImageIO.read(new File("dir2/ball2.png"));
			imgs[2] = ImageIO.read(new File("dir2/ball3.png"));
			imgs[3] = ImageIO.read(new File("dir2/ball4.png"));
		} catch (IOException e) {
		}
		
		balls = new LinkedList<>();
		
		timer = new Timer();
		timer.schedule(new RefreshView(), 0, 16);
		addMouseListener(new MyMouseListener());
	}
		
	 @Override
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW=getWidth();viewH=getHeight();
		//System.out.println(getWidth()+";"+getHeight()); 
	  
		Graphics2D g2d = (Graphics2D)g;
		for (BallTask ball : balls) {
			g2d.drawImage(imgs[ball.img], ball.x, ball.y, null); //座標為0,0
		}
	  
	 }
 
 	 private class MyMouseListener extends MouseAdapter {
 		 @Override
 		public void mouseClicked(MouseEvent e) {
 			BallTask ball = new BallTask(e.getX()-32, e.getY()-32);
 			balls.add(ball);
 			timer.schedule(ball, 500, 30);
 		}
 	 }
 	 private class RefreshView extends TimerTask {
 		@Override
		public void run() {
			repaint();
		}
 	 }
 
	 private class BallTask extends TimerTask{
		 public int x, y, dx, dy, img;
		 public BallTask(int x, int y) {
			 this.x = x; this.y = y;
			 dx = (int)(Math.random()*15) -7 + 1;
			 dy = (int)(Math.random()*15) -7 + 1;
//			 dx = (int)(Math.random()*3+1) * (Math.random()>0.5 ? 1 :-1);
//			 dy = (int)(Math.random()*3+1) * (Math.random()>0.5 ? 1 :-1);
			 img = (int)(Math.random()*4);
		 }
		 
		 @Override
			public void run() {
				if (x <= 0 || x + 64 >= viewW) {
					dx *= -1;
				}
				if (y <= 0 || y + 64 >= viewH) {
					dy *= -1;
				}
				x += dx;
				y += dy;
			}

		 
	 }
}