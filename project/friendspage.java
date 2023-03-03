package project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import users.user;

public class friendspage extends JFrame{
	//this frame simply shows the friends of the user
	JPanel panel;
	JScrollPane pane;
	user user;
	public boolean status = false;
	
	public friendspage(user user){
		
		this.user = user;
		panel = new JPanel();
		panel.setLayout(new GridLayout(15,1));
		//using of grid layout in order to list users downwards
		
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
		
		// this for loop lists all the followed users 
		for(user users:this.user.getFollowed()) {
			
			JPanel panel1 = new JPanel();
			panel1.setLayout(new FlowLayout());
			
			JTextField nickname = new JTextField();
			nickname.setText(users.getNickname());
			nickname.setEditable(false);
			
			JButton profile = new JButton();
			profile.setText("Click to see profile");
			
			panel1.add(nickname);
			panel1.add(profile);
			
			panel.add(panel1);
		
			
			profile.addActionListener(
					new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							profile_page myframe;
							
							try {
								// when user click to see the profile it opens profile page of that user
								myframe = new profile_page(users);
								myframe.setSize(600, 500);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								setVisible(false);
								////////////////////////////////////////////////////////////////////
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
		//addition of scrollpane
		pane = new JScrollPane(panel);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(pane);
		
		
		
	}
	

}
