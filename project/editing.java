package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import users.user;

public class editing extends JFrame{
	
	private JTextArea written_area;
	private JCheckBox image;
	private user user;
	private JCheckBox delete;
	private JButton delete_post;
	
	
	public editing(user user,String header, String content, String path){
		//this frame is very similar to posting_page
		this.user = user;
		this.setLayout(new BorderLayout());
		JPanel panel  = new JPanel();//main panel to place components
		JLabel label = new JLabel("Write what you think");
		
		JTextArea text = new JTextArea(50,50);
		text.setText(content);
		panel.add(label);
		panel.add(text);
		JPanel panel1 = new JPanel(); 
		image = new JCheckBox("Do you want to change image ? ");//there are options to delete or change the image
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
							//if image is selected, program deletes the former content and add edited one,that way edited content will be most recent content
							try {
								for(content cont:user.getContents()) {
									if (cont.getHeader().equals(header)) {
										user.getContents().remove(cont);
									}
									
								}
								project.content.list1.remove(header);
								content content1 = new content(path,text.getText(),header_field.getText(),user);
								setVisible(false);
								profile_page myframe = new profile_page(user);
								myframe.setSize(600, 500);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								//clause to close recently opened frame
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
								for(content cont:user.getContents()) {
									if (cont.getHeader().equals(header)) {
										user.getContents().remove(cont);
									}
									
								}
								//if user wants to delete the picture older content will be removed and new content will be inserted with empty string path
								project.content.list1.remove(header);
								content content1 = new content("",text.getText(),header_field.getText(),user);
								setVisible(false);
								profile_page myframe = new profile_page(user);
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
						else if(!image.isSelected() && !delete.isSelected()) {
							
							try {
								//even if user did not change anything since it starts to editing,new content will be inserted 
								for(content cont:user.getContents()) {
									if (cont.getHeader().equals(header)) {
										user.getContents().remove(cont);
									}
									
								}
								project.content.list1.remove(header);
								content content1 = new content(path,text.getText(),header_field.getText(),user);
								setVisible(false);
								profile_page myframe = new profile_page(user);
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
						for(content cont:user.getContents()) {
							if (cont.getHeader().equals(header)) {
								user.getContents().remove(cont);
							}
							
						}
						project.content.list1.remove(header);
						setVisible(false);
						profile_page myframe;
						try {
							//if one post is deleted,in order to refresh frame,program reopens the profile page frame
							myframe = new profile_page(user);
							myframe.setSize(600, 500);
							myframe.setVisible(true);
							myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
