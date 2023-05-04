package tw.org.iii.tutor;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class LuckyDraw extends JFrame implements ActionListener {
  private String[] prizes = { "獎品1", "獎品2", "獎品3", "獎品4", "獎品5", "獎品6", "獎品7", "獎品8", "獎品9", "獎品10", "獎品11", "獎品12", "獎品13" };
  private int targetIndex; // 目標獎項的索引值
  private int currentIndex = 0; // 目前獎項的索引值
  private int spinCount = 0; // 轉盤旋轉的圈數
  private boolean spinning = false; // 是否正在旋轉
  private Timer timer; // 計時器
  private JButton startButton; // 開始抽獎按鈕
  private JLabel label; // 顯示抽獎結果的標籤

  public LuckyDraw() {
	  // 建立 UI
	  setTitle("轉盤抽獎");
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setLayout(new BorderLayout());
	  JPanel buttonPanel = new JPanel();
	  startButton = new JButton("開始抽獎");
	  startButton.addActionListener(this);
	  buttonPanel.add(startButton);
	  add(buttonPanel, BorderLayout.NORTH);
	  JPanel centerPanel = new JPanel(new BorderLayout());
	  centerPanel.add(new LuckyDrawPanel(), BorderLayout.CENTER);
	  label = new JLabel("抽獎結果：");
	  label.setHorizontalAlignment(JLabel.CENTER);
	  centerPanel.add(label, BorderLayout.SOUTH);
	  add(centerPanel, BorderLayout.CENTER);
	  setSize(600, 600); // 設定視窗大小
	  setLocationRelativeTo(null); // 置中顯示
	  setVisible(true);
	}

  private class LuckyDrawPanel extends JPanel {
	  
	  
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      int x = getWidth() / 2;
      int y = getHeight() / 2;
      int radius = Math.min(x, y) * 3 / 5; // 設定轉盤的半徑

      // 畫圓形
      g2.setColor(Color.WHITE);
      g2.fillOval(x - radius, y - radius, radius * 2, radius * 2);

      // 畫刻度線
      g2.setColor(Color.BLACK);
      for (int i = 0; i < prizes.length; i++) {
        double angle = i * 2 * Math.PI / prizes.length;
        int dx = (int) (radius * Math.cos(angle));
        int dy = (int) (radius * Math.sin(angle));
        g2.drawLine(x, y, x + dx, y + dy);
      }

      // 畫指針
      g2.rotate(Math.toRadians(currentIndex * 360.0 / prizes.length + 90), x, y); // 旋轉
      g2.setColor(Color.RED);
      int[] xPoints = { x - 10, x + 10, x, x - 10 };
      int[] yPoints = { y - 10, y - 10, y + radius / 2 + 10, y - 10 };
      g2.fillPolygon(xPoints, yPoints, 4);
    }
    
    private Image createImage(int x, int y, int radius) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.translate(x, y);
        double angle = 2 * Math.PI / prizes.length; // 每個刻度線對應的角度
        for (int i = 0; i < prizes.length; i++) {
            g2.rotate(angle);
            g2.setColor(getRandomColor()); // 隨機設定獎項的顏色
            g2.fillRect(0, -5, radius - 10, 10);
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 14));
            g2.drawString(prizes[i], 20, 3); // 顯示獎項名稱
        }
        return image;
    }

    	private Color getRandomColor() {
    	  int r = (int) (Math.random() * 256);
    	  int g = (int) (Math.random() * 256);
    	  int b = (int) (Math.random() * 256);
    	  return new Color(r, g, b);
    	}
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == startButton && !spinning) { // 開始抽獎
      targetIndex = (int) (Math.random() * prizes.length);
      spinCount = (int) (Math.random() * 10 ); // 設定旋轉圈數
      timer = new Timer(20, new ActionListener() { // 設定定時器
        private int delay = 20;
        private boolean accelerating = true;

        @Override
        public void actionPerformed(ActionEvent e) {
          currentIndex++;
          if (currentIndex >= prizes.length) {
            currentIndex = 0;
            spinCount--;
          }
          if (spinCount == 0 && currentIndex == targetIndex) { // 停止抽獎
            timer.stop();
            spinning = false;
            label.setText("抽獎結果：" + prizes[targetIndex]);
          } else {
            if (accelerating) {
              delay += 10; // 逐漸增加延遲時間
              if (delay >= 100) { // 延遲時間達到最高點
                accelerating = false;
              }
            } else {
              delay += 5; // 逐漸增加延遲時間
            }
            timer.setDelay(delay);
            repaint();
          }
        }
      });
      timer.start();
      spinning = true;
    }
  }



  public static void main(String[] args) {
  new LuckyDraw();
  }
  
  }


    