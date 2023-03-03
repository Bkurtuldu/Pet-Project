package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import users.groups;

public class creategroup extends JFrame{
	
	private JPanel panel;
	private JTextField name;
	private JTextField country;
	private JTextField hobbies;
	
	public creategroup() {
		panel = new JPanel();
		name = new JTextField(10);
		country = new JTextField(10);
		hobbies = new JTextField(10);
		
		this.setLayout(new BorderLayout());
		
		JPanel left = new JPanel();
		left.setPreferredSize(new Dimension(100,200));
		this.add(left,BorderLayout.EAST);
		
		
		JPanel right = new JPanel();
		right.setPreferredSize(new Dimension(100,200));
		this.add(right,BorderLayout.WEST);
		
		panel.setBackground(Color.magenta);
		this.add(panel,BorderLayout.CENTER);
		panel.setLayout(new BorderLayout());
		
		JButton create = new JButton("create");
		panel.add(create,BorderLayout.SOUTH);
		
		JButton back = new JButton("back");
		panel.add(back,BorderLayout.NORTH);
		
		JPanel main = new JPanel();
		panel.add(main,BorderLayout.CENTER);
		//declaration of grid layout to list all the components vertically.
		main.setLayout(new GridLayout(5,1));
		//different panels and text areas to get input from the user
		JPanel forname = new JPanel();
		forname.setLayout(new FlowLayout());
		JLabel naming = new JLabel("Name:");
		forname.add(naming);
		forname.add(name);
		main.add(forname);
		
		JPanel forcountry = new JPanel();
		forname.setLayout(new FlowLayout());
		JLabel cntry = new JLabel("Country:");
		forcountry.add(cntry);
		forcountry.add(country);
		main.add(forcountry);
		
		JPanel forhobbies = new JPanel();
		forname.setLayout(new FlowLayout());
		JLabel hbbie = new JLabel("Hobbies:");
		forhobbies.add(hbbie);
		forhobbies.add(hobbies);
		main.add(forhobbies);
		
		back.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				}
				);
		
		create.addActionListener(//takes input from the user and creates an instance of groups object
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(!name.getText().equals("") && !country.getText().equals("") && !hobbies.getText().equals("")) {
							
							LinkedList<String> hobbies_list = new LinkedList<String>(Arrays.asList(hobbies.getText().split(",")));
							groups group1 = new groups(name.getText(),country.getText(),hobbies_list,homefeed.user);
							setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "Please enter all necessary information");
						}
						
						
					}
					
				}
				);
		
		
	}
	
	
}
