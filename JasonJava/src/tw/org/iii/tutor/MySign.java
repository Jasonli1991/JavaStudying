package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import tw.org.iii.myclasses.MyDrawer;
import tw.org.iii.myclasses.MyDrawerV2;

public class MySign extends JFrame{
	private MyDrawerV2 myDrawer;
	private JButton clear, undo, redo, chColor, saveObj, loadObj;
	private JScrollBar lineSizeScrollBar;
	
	
	public MySign() {
		super("簽名");
	
		myDrawer = new MyDrawerV2();
		setLayout(new BorderLayout());
		add(myDrawer, BorderLayout.CENTER);
		
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		chColor = new JButton("Color");
		saveObj = new JButton("Save");
		loadObj = new JButton("Load");
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo); top.add(redo); top.add(chColor); top.add(saveObj); top.add(loadObj);
		
		// add line size combo box
        /*lineSizeComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        lineSizeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedLineSize = (int) lineSizeComboBox.getSelectedItem();
                myDrawer.setStrokeSize(selectedLineSize);
            }
        });
        top.add(lineSizeComboBox);*/
		// add line size scroll bar
        lineSizeScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 1, 1, 1, 11);   

        lineSizeScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int selectLineSize = lineSizeScrollBar.getValue();
                myDrawer.setStrokeSize(selectLineSize);
            }
        });
        top.add(lineSizeScrollBar);
		
		
		
		add(top, BorderLayout.NORTH);
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();				
			}
		});
		
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();		
			}
		});
		
		chColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
				
			}
		});
		
		saveObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObject();
			}
		});
		
		loadObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObject();
			}
		});
		
		setSize(800, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void changeColor() {
		Color newColor =  JColorChooser.showDialog(null, "Change Color", myDrawer.getColor());
		if (newColor != null) {
			myDrawer.setColor(newColor);
		}
	}
	
	private void saveObject() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			//偵錯點
			myDrawer.saveLines(file.getAbsolutePath());
		}
//		myDrawer.saveLines("dir1/lines");
	}
	
	private void loadObject() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			myDrawer.loadLines(file.getAbsolutePath());
		}
//		myDrawer.loadLines("dir1/lines");
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}
}