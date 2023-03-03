package project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import users.user;
//this frame shows suggested users to main user.
public class suggestuser extends JFrame{
	
	JPanel panel;
	JScrollPane pane;
	user user;
	public boolean status = false;
	
	public suggestuser(user user){
		
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
		
		LinkedHashSet<user> suggested = new LinkedHashSet<user>();
		//if the age difference is lower than 5,if countries are same and if hobbies have common elements, program adds this user to suggested users.
		for(user users:user.total) {
			if(!this.user.equals(users)) {
				if(!this.user.getFollowed().contains(users)) {
					if(Math.abs(this.user.getAge()- users.getAge()) <= 5) {
						if(this.user.getCountry().toLowerCase().equals(users.getCountry().toLowerCase())) {
							suggested.add(users);
						}
						for(String str:users.getHobbies()) {
							if(this.user.getHobbies().contains(str)) {
								suggested.add(users);
							}
						}
					}
				}
			}
		}
		
		//this part adds more suggested users to show if suggested users list has fewer than 5 elements
		LinkedList<user> storage_list = new LinkedList<user>(user.total);
		storage_list.removeAll(this.user.getFollowed());
		storage_list.remove(this.user);
		storage_list.removeAll(suggested);
		
		int num = 0;
		while(suggested.size()<5) {
			suggested.add(storage_list.get(num));
			num = num +1;
			
		}
		
		for(user users:suggested) {
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
		
		pane = new JScrollPane(panel);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(pane);
		
		
		
	}
	

}
