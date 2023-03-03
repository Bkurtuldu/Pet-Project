package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import users.groups;
import users.user;

//similar class to group_page
public class homefeed extends JFrame{
	
	private JScrollPane bar;
	private JPanel panel;
	public static user user;
	
	
	public user getUser() {
		return user;
	}


	public void setUser(user user) {
		this.user = user;
	}
	/**
	 * 
	 * @param user that uses the application
	 * @throws IOException
	 */

	public homefeed(user user) throws IOException{
		this.user = user;
		
		JPanel area1 = new JPanel();
		area1.setLayout(new BorderLayout());
		JPanel area2 = new JPanel();
		area1.add(area2,BorderLayout.NORTH);
		area2.setLayout(new FlowLayout());
		
		JTextField nickname = new JTextField(this.user.getNickname());
		nickname.setEditable(false);
		nickname.setOpaque(false);
		
		JButton profile = new JButton("MyProfile");
		JButton posting = new JButton ("Post");
		JButton logout = new JButton("Log-out");
		JButton groups = new JButton("Groups");
		JButton search = new JButton("Search");
		JTextField searchbar = new JTextField(10);
		
		area2.add(nickname);
 		area2.add(profile);
		area2.add(posting);
		area2.add(groups);
		area2.add(search);
		area2.add(searchbar);
		area2.add(logout);
		
		
		
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(30,1));
		panel.add(area1);
	
		
		//part where all contents and group contents are gathered in one list and sorted afterwards.
		//After sorting the elements of the list is added one by one to the panel to display them
		LinkedList<content> all_post = new LinkedList<content>();
		for(user followeds:this.user.getFollowed()) {
		for(content contents:followeds.getContents()) {
			all_post.add(contents);
		    }
	    }
		//getting the groupcontents from the groups user joined
		for(Map.Entry<users.groups, LinkedList<groupcontent>> entry:groupcontent.list2.entrySet()) {
			if(this.user.getGroups().keySet().contains(entry.getKey())) {
				for(groupcontent cont:entry.getValue()) {
					all_post.add(cont);
				}
			}
			
		}
		Collections.sort(all_post);
		Collections.reverse(all_post);
		//adding all content one by one to the panel to display
		for(content cont:all_post) {
			panel.add((Component) cont);
		}
		
		
		
		
		
		
		
		bar = new JScrollPane(panel);
		bar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(bar);
		//actionlisteners of buttons
		profile.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						profile_page myframe;
						try {
							myframe = new profile_page(user);
							myframe.setSize(600, 500);
							myframe.setVisible(true);
							myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							setVisible(false);
						} catch (HeadlessException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
					}
	
				}
				);
		
		posting.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						posting_page myframe = new posting_page(user);
						
						myframe.setSize(600, 500);
						myframe.setVisible(true);
						myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
						
					}
					
				}
				);
		//logging out is simply reopens the homepage where user needs to login
		logout.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						homepage myframe;
						try {
							myframe = new homepage();
							myframe.setSize(600, 500);
							myframe.setVisible(true);
							myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
					}
					
				}
				);
		
		groups.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						group_selection myframe = new group_selection(user);
						myframe.setSize(355, 190);
						myframe.setVisible(true);
						myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
						
						
					}
					
				}
				);
		//this button is for searching contents,groups and users
		search.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						//this actionlistener search for groups,users and contents.if none of them is found then it gives an error message.
						//If found then it opens the corresponding page of content user or group
						boolean status = false;
						//this part search for users
						for(users.user users :users.user.total) {
							if (users.getNickname().equals(searchbar.getText())){
								profile_page myframe;
								try {
									status = true;
									myframe = new profile_page(users);
									myframe.setSize(600, 500);
									myframe.setVisible(true);
									myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									setVisible(false);
								} catch (HeadlessException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}	
							}
						}
						//this part search for group name
						for(users.groups group:users.groups.total) {
							if(group.getName().equals(searchbar.getText())) {
								group_page myframe;
								try {
									status = true;
									myframe = new group_page(group);
									myframe.setSize(600, 500);
									myframe.setVisible(true);
									myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									setVisible(false);
								} catch (HeadlessException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}	
							}
						}
						//these two forl loops are searching contents in both the normal contents of the users and group contents of users.
						for(user user:user.getFollowed()) {
							for(content cont:user.getContents()) {
								if(cont.getHeader().equals(searchbar.getText())) {
									profile_page myframe;
									try {
										status = true;
										myframe = new profile_page(user);
										myframe.setSize(600, 500);
										myframe.setVisible(true);
										myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										setVisible(false);
									} catch (HeadlessException | IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}	
								}
							}
						}
						
						for(users.groups group: user.getGroups().keySet()) {
							for(groupcontent cont:user.getGroups().get(group)) {
								if(cont.getHeader().equals(searchbar.getText())) {
									group_page myframe;
									try {
										status = true;
										myframe = new group_page(group);
										myframe.setSize(600, 500);
										myframe.setVisible(true);
										myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										setVisible(false);
									} catch (HeadlessException | IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						}
						if(!status) {
							//if the early stated status variable is still false,then search operation did not succeed.
							JOptionPane.showMessageDialog(null, "This user or group or content does not exist");
						}
						
						
					}
					
				}
				);
		
		
		
	}
	
	
	

}
