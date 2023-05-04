package tw.org.iii.tutor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class EatWhat extends JFrame implements ActionListener {
  private String[] restaurants = { "沐森麵店", "大新火雞肉飯", "中華素食自助餐", "條條有理", "葛瑞絲精緻餐盒", "餃太郎手工水餃", "大業肉圓", "小順豐義式美食", "一點心意", "豪煮藝經典麵食館", "萬和餃子製造所", "八方雲集", "御鼎極品豬腳", "Kiss morning 啾你同享", "禾畔小賣所燒肉丼專賣", "便當人I.M Bento", "龍之麵館", "二五八灶咖", "California Grill 加州火烤"};
  private int targetIndex; // 目標的索引值
  private int currentIndex = 0; // 目前的索引值
  private int spinCount = 0; // 指針旋轉的圈數
  private boolean spinning = false; // 是否正在旋轉
  private Timer timer; 
  private JButton startButton; 
  private JLabel label; 

  public EatWhat() {
	  //UI
	  setTitle("EatWhat?");
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setLayout(new BorderLayout());
	  JPanel buttonPanel = new JPanel();
	  startButton = new JButton("今天吃什麼！！");
	  startButton.addActionListener(this);
	  buttonPanel.add(startButton);
	  add(buttonPanel, BorderLayout.NORTH);
	  JPanel centerPanel = new JPanel(new BorderLayout());
	  centerPanel.add(new EatWhatPanel(), BorderLayout.CENTER);
	  label = new JLabel("");
	  label.setHorizontalAlignment(JLabel.CENTER);
	  centerPanel.add(label, BorderLayout.SOUTH);
	  add(centerPanel, BorderLayout.CENTER);
	  setSize(600, 600); 
	  setLocationRelativeTo(null); // 置中顯示
	  setVisible(true);
	}

  private class EatWhatPanel extends JPanel {
	  
	  
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      int x = getWidth() / 2;
      int y = getHeight() / 2;
      int radius = Math.min(x, y) * 3 / 5; // 設定轉盤的半徑

      // 畫圓形(查來的
      g2.setColor(Color.WHITE);
      g2.fillOval(x - radius, y - radius, radius * 2, radius * 2);

      // 畫刻度線(查來的...
      g2.setColor(Color.BLACK);
      for (int i = 0; i < restaurants.length; i++) {
        double angle = i * 2 * Math.PI / restaurants.length;
        int dx = (int) (radius * Math.cos(angle));
        int dy = (int) (radius * Math.sin(angle));
        g2.drawLine(x, y, x + dx, y + dy);
      }

      // 畫指針(查來的........
      g2.rotate(Math.toRadians(currentIndex * 360.0 / restaurants.length + 90), x, y); // 旋轉
      g2.setColor(Color.RED);
      int[] xPoints = { x - 10, x + 10, x, x - 10 };
      int[] yPoints = { y - 10, y - 10, y + radius / 2 + 10, y - 10 };
      g2.fillPolygon(xPoints, yPoints, 4);
    }
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == startButton && !spinning) { // 開始
      label.setText("搜尋中ooo");
      targetIndex = (int) (Math.random() * restaurants.length);
      spinCount = (int) (Math.random() * 2 + 1 ); // 設定旋轉圈數(隨便設XD)
      timer = new Timer(20, new ActionListener() { // 定時
        private int delay = 5;
        private boolean accelerating = true;

        @Override
        public void actionPerformed(ActionEvent e) {
          currentIndex++;
          if (currentIndex >= restaurants.length) {
            currentIndex = 0;
            spinCount--;
          }
          if (spinCount == 0 && currentIndex == targetIndex) { // 停止
            timer.stop();
            spinning = false;
            label.setText("今天吃..." + restaurants[targetIndex]);
            if (restaurants[targetIndex].equals("沐森麵店")) {
                try {
                    Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/sspauqfwLUQTUuPn6?g_st=ic"));
                } catch (Exception ex) {
                }
            }
            if (restaurants[targetIndex].equals("大新火雞肉飯")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/cnxN73NSL1Hzc7SK7?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("中華素食自助餐")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/aEWmKpojiWw6NzTV6?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("條條有理")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/jAg9M5dwYcd7Vunh6?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("葛瑞絲精緻餐盒")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/PovrPBBn4S9qbwyH8?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("餃太郎手工水餃")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/q63am1cYyuqhvcNq9?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("大業肉圓")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/svuK7CDQmhx2gbKZ9?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("小順豐義式美食")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/JmkUS6QLZQgVABkn6?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("一點心意")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/9a5rXNQMKUH6aQiS6?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("豪煮藝經典麵食館")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/sXbaennkGs1pXY6U9?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("萬和餃子製造所")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/LwAWkx8gXeqACqZ77?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("八方雲集")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/wmMXHP65KYPPip6a9?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("御鼎極品豬腳")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/uD55BhRZ54nLgRBc6?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("Kiss morning 啾你同享")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/d7cSs955rEWngQu96?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("禾畔小賣所燒肉丼專賣")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/8xi97Q6UnWxHZ6VJ9?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("便當人I.M Bento")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/MjTNSyek5oJahvRN8?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("龍之麵館")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/EWX5bdoGmEgNbA6C7?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("二五八灶咖")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/67pNdxcf8BWLfGwA9?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
            if (restaurants[targetIndex].equals("California Grill 加州火烤")) {
            	try {
            		Desktop.getDesktop().browse(new URI("https://maps.app.goo.gl/jQfPjLzDbpk1fPGE9?g_st=ic"));
            	} catch (Exception ex) {
            	}
            }
          } else {
        	//需要改善！
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
  new EatWhat();
  }
  
  }


    