 package project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import users.groups;
import users.user;
//simple member selection frame for showing the members of groups
public class member_selection extends JFrame{
	
	JPanel panel;
	JScrollPane pane;
	groups group;
	public boolean status = false;
	
	public member_selection(groups group){
		
		this.group = group;
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
		
		for(user users:group.getMembers()) {
			JPanel panel1 = new JPanel();
			panel1.setLayout(new FlowLayout());
			
			JTextField nickname = new JTextField();
			nickname.setText(users.getNickname());
			nickname.setEditable(false);
			
			JButton profile = new JButton();
			profile.setText("Click to remove");
			
			panel1.add(nickname);
			panel1.add(profile);
			
			panel.add(panel1);
		
			
			profile.addActionListener(
					new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							if(homefeed.user.equals(group.getCreator())) {
								if(!users.equals(group.getCreator())) {
									try {
										groupcontent.list2.get(group).removeAll(users.getGroups().get(group));
										group.getMembers().remove(users);
										users.getGroups().remove(group);
										group_page myframe;
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
								else {
									JOptionPane.showMessageDialog(null, "You are the creator, if you want to leave group you can delete the group by delete button");
								}
								
							}
							else {
								JOptionPane.showMessageDialog(null, "You are not the creator");
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
