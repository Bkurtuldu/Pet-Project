package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import users.groups;
import users.user;
//class to post groupcontents
public class groupposting extends JFrame {
	
	private JTextArea written_area;
	private JCheckBox image;
	private user user;
	private groups group;
	
	
	public groupposting(user user,groups group){
		super();
		this.user = user;
		this.group = group;
		//the part where panels and labels are set and buttons are created
		this.setLayout(new BorderLayout());
		JPanel panel  = new JPanel();
		JLabel label = new JLabel("Write what you think");
		JTextArea text = new JTextArea(50,50);
		panel.add(label);
		panel.add(text);
		JPanel panel1 = new JPanel(); 
		image = new JCheckBox("Do you want to add image ? ");
		panel1.setLayout(new FlowLayout());
		panel1.add(image);
		JButton button = new JButton("Post!");
		panel1.add(button);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JButton button1 = new JButton("back");
		panel2.add(button1);
		panel2.add(new JLabel("Please enter an header for your post"));
		JTextField header_field = new JTextField(10);
		panel2.add(header_field);
		this.add(panel,BorderLayout.CENTER); this.add(panel1,BorderLayout.SOUTH); this.add(panel2,BorderLayout.NORTH);
		
		button.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						if (image.isSelected()) {
							JFileChooser file = new JFileChooser();
							file.showOpenDialog(null);
							String path = file.getSelectedFile().getAbsolutePath();
							try {
								//takes input from the user and creates content object
								groupcontent content1 = new groupcontent(path,text.getText(),header_field.getText(),user,group);
								group_page myframe;
								myframe = new group_page(group);
								myframe.setSize(600, 500);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								setVisible(false);
								if(test.getFrames().size() == 2) {
									test.getFrames().get(0).dispose();
								}
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else {
							
							try {
								groupcontent content1 = new groupcontent("",text.getText(),header_field.getText(),user,group);
								group_page myframe;
								myframe = new group_page(group);
								myframe.setSize(600, 500);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								setVisible(false);
								if(test.getFrames().size() == 2) {
									test.getFrames().get(0).dispose();
								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						
					}
					
				}
				);
		
		button1.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						
					}
					
				}
				);
		
	}
	
	

}
