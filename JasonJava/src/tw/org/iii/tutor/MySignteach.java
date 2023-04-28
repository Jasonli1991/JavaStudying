package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.org.iii.myclasses.MyDrawerV2;
import tw.org.iii.myclasses.MyDrawerV3teach;

public class MySignteach extends JFrame{
	private MyDrawerV3teach myDrawer;
	private JButton clear, undo, redo, chColor;
	private JButton saveObj, loadObj, saveJPEG;
	
	public MySignteach() {
		super("簽名");
	
		myDrawer = new MyDrawerV3teach();
		setLayout(new BorderLayout());
		add(myDrawer, BorderLayout.CENTER);
		
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		chColor = new JButton("Color");
		saveObj = new JButton("Save Obj");
		loadObj = new JButton("Load Obj");
		saveJPEG = new JButton("Save JPEG");
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo); top.add(redo);
		top.add(chColor); top.add(saveObj); top.add(loadObj);
		top.add(saveJPEG);
		
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
		
		saveJPEG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.saveJPEG();
			}
		});
		
		
		setSize(800, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void changeColor() {
		/*
		Color newColor = JColorChooser.showDialog(
			null, "Change Color", myDrawer.getColor());
		if (newColor != null) {
			myDrawer.setColor(newColor);
		}
		*/
	}
	
	private void saveObject() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			myDrawer.saveLines(file.getAbsolutePath());
		}
	}
	
	private void loadObject() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			myDrawer.loadLines(file.getAbsolutePath());
		}
	}

	public static void main(String[] args) {
		new MySignteach();
	}

}