package tw.org.iii.myclasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
 private BufferedImage ball ;
 private Timer timer;
 private int ballX,ballY,viewW,viewH,dx,dy;
 //viewH,W 為視窗大小
 
 public MyPanel() {
  setBackground(Color.YELLOW);
  
  
  try {
   ball= ImageIO.read(new File("dir1/ball1.png"));
  } catch (Exception e) {
   System.out.println(e);
  }
  ballX=ballY=100;
  dx=dy=2;
  timer= new Timer();
  timer.schedule(new BallTask(),1000,16);//第三個參數為多少時間繼續移動
  
  
 }
 
 @Override
 protected void paintComponent(Graphics g) {
  viewW=getWidth();viewH=getHeight();
  super.paintComponent(g);
  //System.out.println(getWidth()+";"+getHeight()); 
  
  Graphics2D g2d = (Graphics2D)g;
  g2d.drawImage(ball,ballX,ballY,null); //座標為0,0
  
  
 }
 private class BallTask extends TimerTask{
  @Override
  public void run() {
   if(ballX<=0 ||ballX+64>=viewW) { //+64是因為影像寬高為64*64
    dx *= -1;
   }
   if(ballY<=0 || ballY+64 >=viewH) {
    dy *= -1;
   }
   ballX+=dx;  //常數移動方向
   ballY+=dy;
   repaint();
   
  }
 }
}