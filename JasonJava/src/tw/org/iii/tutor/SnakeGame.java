package tw.org.iii.tutor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGame implements ActionListener, KeyListener {

private static final int SCALE = 10;
private static final int WIDTH = 60;
private static final int HEIGHT = 40;
private static final int SPEED = 100;

private JFrame frame;
private RenderPanel renderPanel;
private Timer timer = new Timer(SPEED, this);
private ArrayList<Point> snake = new ArrayList<Point>();
private Point fruit = new Point();
private int ticks = 0;
private int direction = 1;
private Random random = new Random();

public SnakeGame() {
	frame = new JFrame("Snake Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
    frame.setVisible(true);
    frame.addKeyListener(this);
    renderPanel = new RenderPanel();
    frame.add(renderPanel);  // 將 renderPanel 加到 JFrame 上
    startGame();
}

public void startGame() {
    snake.clear();
    snake.add(new Point(WIDTH/2, HEIGHT/2));
    direction = 1;
    ticks = 0;
    fruit.setLocation(random.nextInt(WIDTH), random.nextInt(HEIGHT));
    timer.start();
}

public void actionPerformed(ActionEvent e) {
    renderPanel.repaint();
    ticks++;
    
    if (ticks % 2 == 0 && snake.size() > 0) {
        Point head = snake.get(snake.size()-1);
        Point newHead = (Point) head.clone();
        switch (direction) {
            case 0:
                newHead.y--;
                break;
            case 1:
                newHead.x++;
                break;
            case 2:
                newHead.y++;
                break;
            case 3:
                newHead.x--;
                break;
        }
        if (newHead.equals(fruit)) {
            snake.add(fruit);
            fruit.setLocation(random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }
        else {
            snake.remove(0);
            for (Point p : snake) {
                if (p.equals(newHead)) {
                    timer.stop();
                }
            }
        }
        snake.add(newHead);
    }
}

public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_UP && direction != 2) {
        direction = 0;
    }
    if (key == KeyEvent.VK_RIGHT && direction != 3) {
        direction = 1;
    }
    if (key == KeyEvent.VK_DOWN && direction != 0) {
        direction = 2;
    }
    if (key == KeyEvent.VK_LEFT && direction != 1) {
        direction = 3;
    }
}

public void keyReleased(KeyEvent e) {}

public void keyTyped(KeyEvent e) {}

private class RenderPanel extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(Color.BLACK);
	    g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
	    g.setColor(Color.WHITE);
	    for (Point p : snake) {
	        g.fillRect(p.x * SCALE, p.y * SCALE, SCALE, SCALE);
	    }
	    g.setColor(Color.RED);
	    g.fillRect(fruit.x * SCALE, fruit.y * SCALE, SCALE, SCALE);
	}
}

public static void main(String[] args) {
	new SnakeGame();
}
}