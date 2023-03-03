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

import users.groups;
import users.user;
//this frame shows the suggested groups
public class suggestgroup extends JFrame{
	
	JPanel panel;
	JScrollPane pane;
	user user;
	public boolean status = false;
	
	public suggestgroup(user user){
		
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
		
		LinkedHashSet<groups> suggested = new LinkedHashSet<groups>();
		//in a for loop, if groups country is same as the user or if there is common element in the hobbies of group and user, program add
		//this groups to the suggested groups list.
		for(groups group : groups.total) {
			if(!this.user.getGroups().keySet().contains(group)) {
				if(this.user.getCountry().toLowerCase().equals(group.getCountry().toLowerCase())) {
					suggested.add(group);
				}
				for(String str:group.getHobbies()) {
					if(this.user.getHobbies().contains(str)) {
						suggested.add(group);
					}
				}
			}
		}
		//this part, if suggested group has fewer than 2 element, add other groups to the suggested groups.
		LinkedList<groups> storage_list = new LinkedList<groups>(groups.total);
		storage_list.removeAll(this.user.getGroups().keySet());
		storage_list.removeAll(suggested);
		int num = 0;
		while(suggested.size()<2) {
			
			suggested.add(storage_list.get(num));
			num++;
		}
		//this part add the groups one by one to the panel
		for(groups group: suggested) {
			JPanel panel1 = new JPanel();
			panel1.setLayout(new FlowLayout());
			
			JTextField nickname = new JTextField();
			nickname.setText(group.getName());
			nickname.setEditable(false);
			
			JButton profile = new JButton();
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
								myframe = new group_page(group);
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
