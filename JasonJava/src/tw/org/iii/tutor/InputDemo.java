package tw.org.iii.tutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputDemo extends JFrame implements ActionListener {
    private JTextArea inputArea;

    public InputDemo() {
        super("視窗界面輸入");

        // 創建按鈕元件
        JPanel buttonPanel = new JPanel(new GridLayout(4, 3));
        for (int i = 0; i <= 9; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        JButton clearButton = new JButton("清除");
        clearButton.addActionListener(this);
        JButton backButton = new JButton("倒退");
        backButton.addActionListener(this);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        // 創建文本區域元件
        inputArea = new JTextArea(2, 20);
        inputArea.setFont(new Font(null, Font.BOLD, 24));

        // 添加元件到視窗
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.CENTER);
        add(inputArea, BorderLayout.NORTH);

        setSize(320, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new InputDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("清除")) {
            inputArea.setText("");
        } else if (command.equals("倒退")) {
            String text = inputArea.getText();
            if (text.length() > 0) {
                inputArea.setText(text.substring(0, text.length() - 1));
            }
        } else {
            inputArea.append(command);
        }
    }
}
