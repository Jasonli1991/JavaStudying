package tw.org.iii.tutor;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class HorseRace extends JFrame {
    private final int numHorses;
    private Horse[] horses;
    private JLabel[] horseLabels;
    private JButton startButton;
    private boolean started;

    public HorseRace(int numHorses) {
        super("Horse Race");
        this.numHorses = numHorses;
        horses = new Horse[numHorses];
        horseLabels = new JLabel[numHorses];

        // create the horses and horse labels
        for (int i = 0; i < numHorses; i++) {
            horses[i] = new Horse(i+1);
            horseLabels[i] = new JLabel(horses[i].toString());
        }

        // create the start button
        startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            if (!started) {
                started = true;
                for (int i = 0; i < numHorses; i++) {
                    horses[i].start();
                }
            }
        });

        // set up the UI
        JPanel horsePanel = new JPanel(new GridLayout(numHorses, 1));
        for (int i = 0; i < numHorses; i++) {
            horsePanel.add(horseLabels[i]);
        }
        add(horsePanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    private class Horse extends Thread {
        private final int number;
        private int position;
        private Random rand;

        public Horse(int number) {
            this.number = number;
            this.position = 0;
            this.rand = new Random();
        }

        public void run() {
            while (position < 100) {
                try {
                    Thread.sleep(rand.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                position += rand.nextInt(10);
                if (position > 100) {
                    position = 100;
                }
                updateUI();
            }
        }

        private void updateUI() {
            SwingUtilities.invokeLater(() -> {
                horseLabels[number-1].setText(toString());
            });
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Horse ");
            sb.append(number);
            sb.append(": ");
            for (int i = 0; i < position; i++) {
                sb.append("=");
            }
            sb.append(">");
            for (int i = position+1; i < 100; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        new HorseRace(4);
    }
}
