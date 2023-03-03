package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import users.user;
//frame to show profile_page of the user
public class profile_page extends JFrame{
	
	private user user;
	private JPanel panel;
	private JScrollPane bar;
	

	
	public profile_page(users.user user) throws HeadlessException, IOException {
		super();
		this.user = user;
		JPanel area1 = new JPanel();
		area1.setLayout(new BorderLayout());
		JPanel area2 = new JPanel();
		area1.add(area2,BorderLayout.NORTH);
		area2.setLayout(new FlowLayout());
		JTextField nickname = new JTextField(this.user.getNickname());
		nickname.setEditable(false);
		nickname.setOpaque(false);
		JPanel area3 = new JPanel();
		area1.add(area3,BorderLayout.CENTER);
		JPanel southarea = new JPanel();
		area1.add(southarea,BorderLayout.SOUTH);
		southarea.setLayout(new FlowLayout());
		
		//the part where the profile picture of the user is created with the path instance variable of user
		BufferedImage picture1 = ImageIO.read(new File(this.user.getProfilePicture()));
		JLabel picLabel = new JLabel();
		BufferedImage resizedImage = new BufferedImage(300, 250, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(picture1, 0, 0, 300, 250, null);
        g.dispose();
        picLabel.setIcon(new ImageIcon(resizedImage));
        area3.setLayout(new FlowLayout());
        area3.add(picLabel);
        JButton back = new JButton("Back");
        area2.add(back);
        
        
        
        back.addActionListener(
        		new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						homefeed myframe;
						try {
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
		
        //program will behave differently if user opens their profile page,if user opens followed user page,if user opens unfollowed user profile page
        if(this.user != homefeed.user) {
        	if(homefeed.user.getFollowed().contains(this.user)) {
        		JButton unfollow = new JButton("Unfollow");
        		JButton friends = new JButton("Friends");
        		JButton groups = new JButton("Groups");
        		southarea.add(unfollow);
        		southarea.add(friends);
        		southarea.add(groups);
        		JPanel info = new JPanel();
        		String s = String.format("%s%n%s%n%s",this.user.getNickname(),this.user.getRealName()
        				,(this.user.isPremiumStatus() ? "Premium user" : "Standard user") );
        		JTextArea written = new JTextArea();
        		written.setText(s);
        		written.setEditable(false);
        		written.setOpaque(true);
        		info.add(written);
        		area3.add(info);
        		panel = new JPanel();
        		panel.setLayout(new GridLayout(15,1));
        		panel.add(area1);
        		
        		LinkedList<content> reversed = new LinkedList<content>(this.user.getContents());
        		Collections.reverse(reversed);
        		
        		for(content contents :reversed) {
        			panel.add(contents);
        		}
        		
        		bar = new JScrollPane(panel);
        		bar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        		this.add(bar);
        		
        		unfollow.addActionListener(
        				new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								homefeed.user.getFollowed().remove(user);
								user.getFollowers().remove(homefeed.user);
								setVisible(false);
								profile_page myframe;
								try {
									myframe = new profile_page(user);
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
        		
        		friends.addActionListener(
        				new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								
								friendspage myframe = new friendspage(user);
								myframe.setSize(240, 190);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								//setVisible(false);
							
								
							}
        					
        				}
        				);
        		
        		groups.addActionListener(
        				new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								group_selection myframe = new group_selection(user);
								myframe.setSize(355,190);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								
								
							}
        					
        				}
        				);
        		
        	}
        	else {
        		JButton follow = new JButton("Follow");
        		
 
        		southarea.add(follow);
        		JPanel info = new JPanel();
        		String s = String.format("%s%n%s%n%s",this.user.getNickname(),this.user.getRealName()
        				,(this.user.isPremiumStatus() ? "Premium user" : "Standard user") );
        		JTextArea written = new JTextArea();
        		written.setText(s);
        		written.setEditable(false);
        		written.setOpaque(true);
        		info.add(written);
        		
        		area3.add(info);
        		panel = new JPanel();
        		panel.setLayout(new GridLayout(1,1));
        		panel.add(area1);
        		
        		
        		
        		bar = new JScrollPane(panel);
        		bar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        		this.add(bar);
        		
        		follow.addActionListener(
        				new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								homefeed.user.getFollowed().add(user);
								user.getFollowers().add(homefeed.user);
								setVisible(false);
								profile_page myframe;
								try {
									
									myframe = new profile_page(user);
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
        }
        else {
        	
    		JButton friends = new JButton("Friends");
    		JButton groups = new JButton("Groups");
    		JButton premium = new JButton("Create group");
    		JButton edit = new JButton("Edit profile");
    		JButton delete = new JButton("Delete profile");
    		JButton suguser = new JButton("Suggest users");
    		JButton suggroups = new JButton("Suggest groups");
    		if(this.user.isPremiumStatus()) {
    			southarea.add(premium);
    		}
    		southarea.add(friends);
    		southarea.add(groups);
    		southarea.add(edit);
    		southarea.add(delete);
    		area2.add(suguser);
    		area2.add(suggroups);
    		JPanel info = new JPanel();
    		String s = String.format("%s%n%s%n%s",this.user.getNickname(),this.user.getRealName()
    				,(this.user.isPremiumStatus() ? "Premium user" : "Standard user") );
    		JTextArea written = new JTextArea();
    		written.setText(s);
    		written.setEditable(false);
    		written.setOpaque(true);
    		info.add(written);
    		area3.add(info);
        	panel = new JPanel();
    		panel.setLayout(new GridLayout(15,1));
    		panel.add(area1);
    		
    		LinkedList<content> reversed = new LinkedList<content>(this.user.getContents());
    		Collections.reverse(reversed);
    		
    		for(content contents :reversed) {
    			panel.add(contents);
    		}
    		
    		bar = new JScrollPane(panel);
    		bar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    		this.add(bar);	
    		
    		friends.addActionListener(
    				new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							friendspage myframe = new friendspage(user);
							myframe.setSize(240, 190);
							myframe.setVisible(true);
							myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							//setVisible(false);
	
						}
    					
    				}
    				);
    		
    		edit.addActionListener(
    				new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							profileedit myframe = new profileedit(user);
							myframe.setSize(600, 500);
							myframe.setVisible(true);
							myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							setVisible(false);
							
						}
    					
    				}
    				);
    		
    		
    		delete.addActionListener(
    				new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							users.user.list1.remove(user.getNickname());
							users.user.total.remove(user);
							setVisible(false);
							for(users.user users: users.user.total) {
								users.getFollowed().remove(user);
							}
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
    		
    		premium.addActionListener(
    				new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							creategroup myframe;
							myframe = new creategroup();
							myframe.setSize(600, 500);
							myframe.setVisible(true);
							myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							
						}
    					
    				}
    				);
    		
    		suguser.addActionListener(
    				new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							suggestuser myframe;
							myframe = new suggestuser(user);
							myframe.setSize(240, 190);
							myframe.setVisible(true);
							myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							
						}
    					
    				}
    				);
    		
    		suggroups.addActionListener(
    				new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							suggestgroup myframe;
							myframe = new suggestgroup(user);
							myframe.setSize(355, 190);
							myframe.setVisible(true);
							myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							
						}
    					
    				}
    				);
        }
		
		
	}
	
	
	
	

}
