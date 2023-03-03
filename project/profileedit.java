package project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import users.user;
//this frame is for editing profile information,it is very similar to sign up page
public class profileedit extends JFrame{
	
	private JTextField nickname;
	private JTextField password;
	private JTextField realName;
	private JTextField age;
	private JTextField mail;
	private JTextField hobbies;
	private JTextField country;
	private JCheckBox premium;
	private JCheckBox profilephoto;
	private JButton button;
	private JPanel panel;
	private static int counter = 0;
	private user user;
	
	public profileedit(user user){
		super("Editing Profile");
		this.user = user;
		setLayout(new GridLayout(8,1));
		nickname = new JTextField(10); 
		password = new JTextField(10);
		realName = new JTextField(10);
		age = new JTextField(10);
		mail = new JTextField(10);
		hobbies = new JTextField(10);
		country = new JTextField(10);
		premium = new JCheckBox("Do you want to be premium user ?");
		profilephoto = new JCheckBox("Do you want to change  profile photo ?");
		button = new JButton("Edit");
		//adding textfields to take input, and adding seperate panels  for seperate informations to the grid layout
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel label = new JLabel("Nickname:");
		panel.add(label);
		panel.add(nickname);
		nickname.setText(user.getNickname());
		nickname.setEditable(false);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Password:");
		panel1.add(label1);
		panel1.add(password);
		password.setText(user.getPassword());
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JLabel label2 = new JLabel("Real Name:");
		panel2.add(label2);
		panel2.add(realName);
		realName.setText(user.getRealName());
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		JLabel label3 = new JLabel("Age:");
		panel3.add(label3);
		panel3.add(age);
		age.setText(Integer.toString(user.getAge()));
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		JLabel label4 = new JLabel("Mail Adress:");
		panel4.add(label4);
		panel4.add(mail);
		mail.setText(user.getEmailAdress());
		
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new FlowLayout());
		JLabel label5 = new JLabel("Hobbies:(Optional)");
		panel5.add(label5);
		panel5.add(hobbies);
		String str = "";
		for(String s:user.getHobbies()) {
			str = str + s + ",";
		}
		hobbies.setText(str);
		
		JPanel panel6 = new JPanel();
		panel6.setLayout(new FlowLayout());
		JLabel label6 = new JLabel("Country:");
		panel6.add(label6);
		panel6.add(country);
		country.setText(user.getCountry());
		
		
		
		
		
		
		
		
		
		add(panel); add(panel1); add(panel2); add(panel3); add(panel4); add(panel5); add(panel6); add(premium); add(profilephoto); add(button);
		
		button.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						//try block the prevent program to give error when parsing age text area to integer
						try {
							if(!nickname.getText().equals("") && !password.getText().equals("") && !realName.getText().equals("") && !age.getText().equals("") &&
									!mail.getText().equals("") && !country.getText().equals("")) {
								
								ArrayList<String> nicks = new ArrayList<String>(users.user.list1);
								nicks.remove(user.getNickname());
								if (nicks.contains(nickname.getText())) {
									JOptionPane.showMessageDialog(null, "Please try another nickname");
									
								}
								else {
									
									LinkedList<String> hobbies_list = new LinkedList<String>(Arrays.asList(hobbies.getText().split(",")));
									if(profilephoto.isSelected()) {
										JFileChooser file = new JFileChooser();
										file.showOpenDialog(null);
										String path = file.getSelectedFile().getAbsolutePath();
										
										user.setAge(Integer.parseInt(age.getText()));
										user.setEmailAdress(mail.getText());
										user.setHobbies(hobbies_list);
										user.setPassword(password.getText());
										user.setPremiumStatus((premium.isSelected() ? true: false));
										user.setProfilePicture(path);
										user.setRealName(realName.getText());
										user.setCountry(country.getText());
										
										profile_page myframe;
										
										try {
											setVisible(false);
											myframe = new profile_page(user);
											myframe.setSize(600, 500);
											myframe.setVisible(true);
											myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
										
									}
									else {
										String path = "C:/Users/berke/eclipse-workspace/project/src/users/default.png";
										
										user.setAge(Integer.parseInt(age.getText()));
										user.setEmailAdress(mail.getText());
										user.setHobbies(hobbies_list);
										user.setPassword(password.getText());
										user.setPremiumStatus((premium.isSelected() ? true: false));
										user.setProfilePicture(path);
										user.setRealName(realName.getText());
										user.setCountry(country.getText());
										profile_page myframe;
										
										try {
											setVisible(false);
											myframe = new profile_page(user);
											myframe.setSize(600, 500);
											myframe.setVisible(true);
											myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
									
									}
								}
								
								
							}
							else {
								JOptionPane.showMessageDialog(null, "Please fill all the necessary information");
							}
						}
						catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Please enter valid age");
						}
						
						
						
						
						
						
					}
					
				}
				);
	}

}
