package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import users.groups;
import users.user;
//very similar class to editing,only difference is this class is editing groupposts
public class groupediting extends JFrame{
	
	private JTextArea written_area;
	private JCheckBox image;
	private user user;
	private JCheckBox delete;
	private JButton delete_post;
	private groups group;
	//first page where program takes nickname and password
	public groupediting(user user,String header, String content, String path,groups group){
		
		this.user = user;
		this.group = group;
		this.setLayout(new BorderLayout());
		JPanel panel  = new JPanel();
		JLabel label = new JLabel("Write what you think");
		JTextArea text = new JTextArea(50,50);
		text.setText(content);
		panel.add(label);
		panel.add(text);
		JPanel panel1 = new JPanel(); 
		image = new JCheckBox("Do you want to change image ? ");
		delete = new JCheckBox("Do you want to delete image ? ");
		delete_post = new JButton("Delete post");
		panel1.setLayout(new FlowLayout());
		panel1.add(image);
		panel1.add(delete);
		panel1.add(delete_post);
		JButton button = new JButton("Post!");
		panel1.add(button);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JTextField header_field = new JTextField(10);
		header_field.setText(header);
		header_field.setEditable(false);
		panel2.add(header_field);
		this.add(panel,BorderLayout.CENTER); this.add(panel1,BorderLayout.SOUTH); this.add(panel2,BorderLayout.NORTH);
		
		button.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						if (image.isSelected() && !delete.isSelected()) {
							JFileChooser file = new JFileChooser();
							file.showOpenDialog(null);
							String path = file.getSelectedFile().getAbsolutePath();
							try {
								
								
								for(user member:group.getMembers()) {
				        			for(Map.Entry<groups, LinkedList<groupcontent>> entry:member.getGroups().entrySet()) {
				        				for(groupcontent cont:entry.getValue()) {
				        					if(cont.getHeader().equals(header)) {
				        						user.getGroups().get(group).remove(cont);
				        					}
				        				}
				        			}
				        		}
								project.groupcontent.list1.remove(header);
								groupcontent content1 = new groupcontent(path,text.getText(),header_field.getText(),user,group);
								setVisible(false);
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
						else if(!image.isSelected() && delete.isSelected()) {
							
							try {
								for(user member:group.getMembers()) {
				        			for(Map.Entry<groups, LinkedList<groupcontent>> entry:member.getGroups().entrySet()) {
				        				for(groupcontent cont:entry.getValue()) {
				        					if(cont.getHeader().equals(header)) {
				        						user.getGroups().get(group).remove(cont);
				        					}
				        				}
				        			}
				        		}
								project.groupcontent.list1.remove(header);
								groupcontent content1 = new groupcontent("",text.getText(),header_field.getText(),user,group);
								setVisible(false);
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
						else if(!image.isSelected() && !delete.isSelected()) {
							
							try {
								for(user member:group.getMembers()) {
				        			for(Map.Entry<groups, LinkedList<groupcontent>> entry:member.getGroups().entrySet()) {
				        				for(groupcontent cont:entry.getValue()) {
				        					if(cont.getHeader().equals(header)) {
				        						user.getGroups().get(group).remove(cont);
				        					}
				        				}
				        			}
				        		}
								project.groupcontent.list1.remove(header);
								groupcontent content1 = new groupcontent(path,text.getText(),header_field.getText(),user,group);
								setVisible(false);
								group_page myframe;
								myframe = new group_page(group);
								myframe.setSize(600, 500);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								
								if(test.getFrames().size() == 2) {
									test.getFrames().get(0).dispose();
								}
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						else {
							JOptionPane.showMessageDialog(null, "You cannot select both delete and change!");
						}
						
					}
					
				}
				);
		delete_post.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						for(user member:group.getMembers()) {
		        			for(Map.Entry<groups, LinkedList<groupcontent>> entry:member.getGroups().entrySet()) {
		        				for(groupcontent cont:entry.getValue()) {
		        					if(cont.getHeader().equals(header)) {
		        						user.getGroups().get(group).remove(cont);
		        					}
		        				}
		        			}
		        		}
						project.groupcontent.list1.remove(header);
						setVisible(false);
						group_page myframe;
						try {
							myframe = new group_page(group);
							myframe.setSize(600, 500);
							myframe.setVisible(true);
							myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							setVisible(false);
							if(test.getFrames().size() == 2) {
								test.getFrames().get(0).dispose();
							}
						} catch (HeadlessException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					
				}
				);
		
	}

}
