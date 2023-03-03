package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.Collections;
import java.util.LinkedList;
import users.groups;
import users.user;

public class group_page extends JFrame{
	
	private groups group;
	private JPanel panel;
	private JScrollPane bar;
	


	public group_page(users.groups group) throws HeadlessException, IOException {
		super();
		this.group = group;
		
		//implementation of panels to create a design
		JPanel area1 = new JPanel();
		area1.setLayout(new BorderLayout());
		
		JPanel area2 = new JPanel();
		area1.add(area2,BorderLayout.NORTH);
		area2.setLayout(new FlowLayout());
		
		JTextField nickname = new JTextField(this.group.getName());
		nickname.setEditable(false);
		nickname.setOpaque(false);
		
		JPanel area3 = new JPanel();
		area1.add(area3,BorderLayout.CENTER);
		
		JPanel southarea = new JPanel();
		area1.add(southarea,BorderLayout.SOUTH);
		southarea.setLayout(new FlowLayout());
		
		
        area3.setLayout(new FlowLayout());
        JButton back = new JButton("Back");
        area2.add(back);
        
        
        
        back.addActionListener(
        		new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						homefeed myframe;
						try {
							//back button to go back
							myframe = new homefeed(homefeed.user);
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
		//this frame is seperated to 3 parts. Whether user is joined to group, whether user is creator or not
        if(this.group.getMembers().contains(homefeed.user)) {
        	if(homefeed.user.equals(group.getCreator())) {
        		//if user is the creator then it has delete group button
        		JButton members = new JButton("Members");
        		JButton delete = new JButton("Delete Group");
        		JButton post = new JButton("Post");
        		
        		southarea.add(members);
        		southarea.add(delete);
        		southarea.add(post);
        		
        		JPanel info = new JPanel();
        		info.setLayout(new FlowLayout());
        		
        		String s = String.format(" ".repeat(50) + "%s     %s     %s     Creator:%s",this.group.getName(),this.group.getCountry()
        				,this.group.getHobbies(),this.group.getCreator().getNickname() );
        		
        		JTextArea written = new JTextArea(3,55);
        		written.setForeground(Color.white);
        		written.setBackground(Color.black);
        		written.setText(s);
        		written.setEditable(false);
        		written.setOpaque(true);
        		info.add(written);
        		area3.add(info);
        		
        		panel = new JPanel();
        		panel.setLayout(new GridLayout(15,1));
        		panel.add(area1);
        		
        		//for loop to display the contents of the users 
        		for(user member:group.getMembers()) {
        			for(Map.Entry<groups, LinkedList<groupcontent>> entry:member.getGroups().entrySet()) {
        				if(entry.getKey().equals(group)) {
        					LinkedList<groupcontent> reversed = new LinkedList<groupcontent>(entry.getValue());
        					Collections.reverse(reversed);
        					for(groupcontent cont:reversed) {
            					panel.add(cont);
            				}
        				}
        				
        			}
        		}
        		
        		bar = new JScrollPane(panel);
        		bar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        		this.add(bar);
        		// in order to show members it opens member_selection frame
        		members.addActionListener(
        				new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								
								member_selection myframe;
								myframe = new member_selection(group);
								myframe.setSize(240, 190);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								
							}
        					
        				}
        				);
        		//it opens groupposting page to post group content
        		post.addActionListener(
        				new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								groupposting myframe = new groupposting(homefeed.user,group);
								
								myframe.setSize(600, 500);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								
							}
        					
        				}
        				);
        		//deleting group results in deleting the group in every storage list created like the groups variable of users and total list
        		//of groups class
        		delete.addActionListener(
        				new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								
								for(user user:user.total) {
									user.getGroups().remove(group);
									group.getMembers().removeAll(group.getMembers());
									groups.total.remove(group);
								}
								homefeed myframe;
								try {
									myframe = new homefeed(homefeed.user);
									myframe.setSize(600, 500);
									myframe.setVisible(true);
									myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									setVisible(false);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							
								
							}
        					
        				}
        				);
        		
        		
        		
        	}
        	else {
        		//if user is not the creator program goes this way
        		JButton members = new JButton("Members");
        		JButton leave = new JButton("Leave");
        		JButton post = new JButton("Post");
        		southarea.add(members);
        		southarea.add(leave);
        		southarea.add(post);
        		JPanel info = new JPanel();
        		info.setLayout(new FlowLayout());
        		String s = String.format(" ".repeat(50) + "%s     %s     %s     Creator:%s",this.group.getName(),this.group.getCountry()
        				,this.group.getHobbies(),this.group.getCreator().getNickname() );
        		JTextArea written = new JTextArea(3,55);
        		written.setForeground(Color.white);
        		written.setBackground(Color.black);
        		written.setText(s);
        		written.setEditable(false);
        		written.setOpaque(true);
        		info.add(written);
        		area3.add(info);
        		panel = new JPanel();
        		panel.setLayout(new GridLayout(15,1));
        		panel.add(area1);
        		
        		//the reason of the lists are reversed is to show content starting from the most recent in the group page
        		//groupcontents are accessed from the groups list of the members oh this group
        		for(user member:group.getMembers()) {
        			for(Map.Entry<groups, LinkedList<groupcontent>> entry:member.getGroups().entrySet()) {
        				if(entry.getKey().equals(group)) {
        					LinkedList<groupcontent> reversed = new LinkedList<groupcontent>(entry.getValue());
        					Collections.reverse(reversed);
        					for(groupcontent cont:reversed) {
            					panel.add(cont);
            				}
        				}
        				
        			}
        		}
        		
        		bar = new JScrollPane(panel);
        		bar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        		this.add(bar);
        		
        		//simple member_selection fram to show the members of this gorup
        		members.addActionListener(
        				new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								member_selection myframe;
								myframe = new member_selection(group);
								myframe.setSize(240, 190);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								
							}
        					
        				}
        				);
        		
        		//leaving the group results in removal of groups from the users group list and removal of user from the members list of group
        		leave.addActionListener(
        				new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								group.getMembers().remove(homefeed.user);
								homefeed.user.getGroups().remove(group);
								homefeed myframe;
								try {
									myframe = new homefeed(homefeed.user);
									myframe.setSize(600, 500);
									myframe.setVisible(true);
									myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									setVisible(false);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
							}
        					
        				}
        				);
        		
        		post.addActionListener(
        				new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								groupposting myframe = new groupposting(homefeed.user,group);
								
								myframe.setSize(600, 500);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								
							}
        					
        				}
        				);
        	}
        }
        
        
        else {
        	//if user is not joined to the group then program goes this way
        	JButton join = new JButton("Join");
    		southarea.add(join);
    		JPanel info = new JPanel();
    		info.setLayout(new FlowLayout());
    		String s = String.format(" ".repeat(50) + "%s     %s     %s     Creator:%s",this.group.getName(),this.group.getCountry()
    				,this.group.getHobbies(),this.group.getCreator().getNickname() );
    		JTextArea written = new JTextArea(3,55);
    		written.setForeground(Color.white);
    		written.setBackground(Color.black);
    		written.setText(s);
    		written.setEditable(false);
    		written.setOpaque(true);
    		info.add(written);
    		area3.add(info);
    		panel = new JPanel();
    		panel.setLayout(new GridLayout(15,1));
    		panel.add(area1);
    		
    		bar = new JScrollPane(panel);
    		bar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    		this.add(bar);
    		//this action listener makes user to join to the group by adding it into the members list and also adding group to the users group list
    		join.addActionListener(
    				new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							group.addMember(homefeed.user);
							homefeed.user.getGroups().put(group, new LinkedList<groupcontent>());
							setVisible(false);
							group_page myframe;
							try {
								myframe = new group_page(group);
								myframe.setSize(600, 500);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							} catch (HeadlessException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						}
    					
    				}
    				
    				);
        }
		
		
	}
	
	
	
	

}
