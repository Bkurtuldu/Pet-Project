package project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridBagLayoutInfo;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


import users.user;
public class homepage extends JFrame{
	
	private JButton signinbutton;
	
	private JButton signupbutton;
	
	private JPanel panel;
	
	private JPanel new_panel;
	
	private JTextField nickname;
	
	private JPasswordField password;
	
	//first page where program takes nickname and password
	public homepage() throws IOException{
		super("Carcosa");
		ImageIcon img = new ImageIcon("C:/Users/berke/OneDrive/Masaüstü/true-detective-symbol-100978.png");
		this.setIconImage(img.getImage());
		setLayout(new BorderLayout(400,300));
		signinbutton = new JButton("Sign-in");
		signupbutton = new JButton("Sign-Up");
		signinbutton.setBackground(Color.black);
		signupbutton.setBackground(Color.black);
		signinbutton.setForeground(Color.white);
		signupbutton.setForeground(Color.white);
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,2,10,10));
		panel.add(signinbutton);
		panel.add(signupbutton);
		panel.setBackground(Color.DARK_GRAY);
		
		
		nickname = new JTextField(10);
		password = new JPasswordField(10);
		new_panel = new JPanel();
		new_panel.setLayout(new BorderLayout());
		JPanel another_panel = new JPanel();
		another_panel.setLayout(new FlowLayout());
		
		//panels and labels are created
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Password:");
		label1.setForeground(Color.white);
		panel1.add(label1);
		panel1.add(password);
		panel1.setBackground(Color.black);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		JLabel label4 = new JLabel("Nickname:");
		label4.setForeground(Color.white);
		panel4.add(label4);
		panel4.add(nickname);
		panel4.setBackground(Color.black);
		
		// nickname and password area added to the another panel
		another_panel.add(panel4);
		another_panel.add(panel1);
		
		//new_panel is the main panel
		another_panel.setBackground(Color.DARK_GRAY);
		new_panel.add(another_panel,BorderLayout.SOUTH);
		
		
		
		//if user exists with the nickname and password user wrote, it opens the homefeed for that user
		signinbutton.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {	
						if (user.list1.contains(nickname.getText()) && password.getText().equals(user.total.get(user.list1.indexOf(nickname.getText())).getPassword())) {
							
							homefeed myframe;
							try {
								myframe = new homefeed(user.total.get(user.list1.indexOf(nickname.getText())));
								myframe.setSize(600, 500);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								setVisible(false);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						else {
							JOptionPane.showMessageDialog(null, "This user cannot be found");
						}
					}	
				}
				);
		// signup button opens new signup frame
		signupbutton.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						signuppage myframe = new signuppage();
						
						myframe.setSize(600, 500);
						myframe.setVisible(true);
						myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						setVisible(false);
					}	
				}
				);
		
		
		//adjustment of the application logo 
		add(panel,BorderLayout.SOUTH);
		getContentPane().setBackground(Color.DARK_GRAY);
		add(new_panel,BorderLayout.NORTH);
		new_panel.setPreferredSize(new Dimension(250,300));
		new_panel.setBackground(Color.DARK_GRAY);
		JPanel picpanel = new JPanel();
		picpanel.setLayout(new FlowLayout());
		picpanel.setBackground(Color.DARK_GRAY);
		new_panel.add(picpanel,BorderLayout.CENTER);
		JLabel pic = new JLabel();
		BufferedImage picture1 = ImageIO.read(new File("C:/Users/berke/eclipse-workspace/project/src/true-detective-symbol-100978.png"));
		picpanel.add(pic);
		pic.setIcon(new ImageIcon(picture1));
		add(new JPanel(),BorderLayout.EAST);
		add(new JPanel(),BorderLayout.WEST);
		
	}
	
	
	

	

}
