package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import users.groups;
import users.user;

public class content extends JLabel implements Comparable<content>{
//implements comparable for comparing objects by their creation time	
	
	private String path;//string image path
	private String written;
	private LocalTime time;
	private String header;
	private JCheckBox picture;
	private user user;
	public static LinkedList<String> list1 = new LinkedList<String>();//list to keep all instances of content.
	/**
	 * 
	 * @param path
	 * @param written
	 * @param header
	 * @param user
	 * @throws IOException because of the ImageIO class
	 */
	
	public content(String path,String written,String header,user user) throws IOException {
		// checks if the content header is taken or not
		if(list1.contains(header)) {
			JOptionPane.showMessageDialog(null, "This header is already taken");
		}
		else {
			this.path = path;
			this.written = written;
			this.header = header;
			this.user = user;
			this.time = LocalTime.now();
			this.setPreferredSize(new Dimension(170,320));
			this.setLayout(new BorderLayout());
			
			JPanel  panel = new JPanel();//upper part of content which has information like header,creator,time
			panel.setBackground(Color.blue);
			panel.setLayout(new FlowLayout());
			
			JTextField header_field = new JTextField();
			header_field.setText(header);
			header_field.setEditable(false);
			
			
			JTextField time_field = new JTextField();
			time_field.setText(this.time.toString());
			time_field.setEditable(false);
			
			JButton button = new JButton("edit");// a button to edit the content
			
			JTextField author = new JTextField();
			author.setText(this.user.getNickname());
			author.setEditable(false);
			
			panel.add(author);
			panel.add(header_field);
			panel.add(time_field);
			panel.add(button);
			
			JPanel inner = new JPanel();//lower part of content which has photo and text
			JTextArea written_area = new JTextArea();
			written_area.setEditable(false);
			
			written_area.setText(written);
			list1.add(header);
			
			
			if (this instanceof groupcontent) {//this clause make sure that we do not add any instance of groupcontent
				//to content list since groupcontent is subcalss of content
				
			}
			else {
				this.user.getContents().add(this);
			}
			
			
			
			//edit button opens editing frame to edit the content
			//but it gives an error if you are not the owner of the content
			button.addActionListener(
					new ActionListener() {

						@Override
						
						public void actionPerformed(ActionEvent e) {
							
							if(user != homefeed.user) {
								JOptionPane.showMessageDialog(null, "You can only edit your posts");
								
							}
							else {
								//opens editing frame
								editing myframe = new editing(user,header,written,path);
								myframe.setSize(600, 500);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								
								
							}
							
						}
						
					}
					);
			
			
			
			if(this.path.equals("")) {
				//checks if image is selected or not
				inner.setLayout(new GridLayout(1,1));
				inner.add(written_area);
			}
			else {
				//if image selected sets image as icon to picLabel and add to the picpanel
				inner.setLayout(new GridLayout(1,2));
				
				BufferedImage picture1 = ImageIO.read(new File(path));
				JLabel picLabel = new JLabel();
				
				
				JPanel picpanel = new JPanel();
				
				
				Image scaledImage = picture1.getScaledInstance(280,280,Image.SCALE_SMOOTH);
				picLabel.setIcon(new ImageIcon(scaledImage));
				picpanel.add(picLabel);
				inner.add(picpanel);
				inner.add(written_area);
				
			}
			
			
			
			this.add(inner,BorderLayout.CENTER);
			this.add(panel,BorderLayout.NORTH);
		}
		
		
		
		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getWritten() {
		return written;
	}

	public void setWritten(String written) {
		this.written = written;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public JCheckBox getPicture() {
		return picture;
	}

	public void setPicture(JCheckBox picture) {
		this.picture = picture;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}
	
	@Override//compareTo function to compare instances. It first controls the second and after the milisecond if the seconds are same.
	// With the help of this function i could show to contents according to the creation time.
	public int compareTo(content cont) {
		if(this.getTime().getSecond()>cont.getTime().getSecond()) {
			return 1;
		}
		if(this.getTime().getSecond()<cont.getTime().getSecond()) {
			return -1;
		}
		if(this.getTime().getNano()>cont.getTime().getNano()) {
			return 1;
		}
		if(this.getTime().getNano()<cont.getTime().getNano()) {
			return -1;
		}
		return 0;
	}

}
