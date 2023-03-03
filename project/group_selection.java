package project;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.util.LinkedList;
import users.user;

public class group_selection extends JFrame{
	// simple frame to show all groups that user joined
	JPanel panel;
	JScrollPane pane;
	user user;
	public boolean status = false;
	
	public group_selection(user user){
		
		this.user = user;
		panel = new JPanel();
		panel.setLayout(new GridLayout(15,1));
		
		JButton button = new JButton("Back");
		panel.add(button);
		
		button.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							
							setVisible(false);
							
							
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					
				}
				);
		
		for(Map.Entry<users.groups, LinkedList<groupcontent>> entry:user.getGroups().entrySet() ) {
			//for loop to show groups
			JPanel panel1 = new JPanel();
			panel1.setLayout(new FlowLayout());
			
			JTextField nickname = new JTextField();
			nickname.setText(entry.getKey().getName());
			nickname.setEditable(false);
			
			JButton profile = new JButton();//button to go to the group page
			profile.setText("Click to go to the group");
			
			panel1.add(nickname);
			panel1.add(profile);
			
			panel.add(panel1);
		
			
			profile.addActionListener(
					new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							group_page myframe;
							
							try {
								myframe = new group_page(entry.getKey());
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
					);
			
			
		}
		
		pane = new JScrollPane(panel);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(pane);
		
		
		
	}
	

}

