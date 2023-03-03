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
import java.util.LinkedHashMap;
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

public class groupcontent extends content{
//subclass of content class	
	
	private String path;
	private String written;
	private LocalTime time;
	private String header;
	private JCheckBox picture;
	private user user;
	public static LinkedList<String> list1 = new LinkedList<String>();
	public static LinkedHashMap<users.groups,LinkedList<groupcontent>> list2 = new LinkedHashMap<users.groups,LinkedList<groupcontent>>();
	//most important instance of groupcontent is list2.it keeps all contents diversified by their groups.this map is used to access the 
	//group contents as easy as possible.
	private groups group;
	
	public groupcontent(String path,String written,String header,user user,groups group) throws IOException {
		super(path,written,header,user);
		if(list1.contains(header)) {
			JOptionPane.showMessageDialog(null, "This header is already taken");
		}
		else {
			this.path = path;
			this.written = written;
			this.header = header;
			this.user = user;
			this.group = group;
			this.setPreferredSize(new Dimension(170,320));
			this.setLayout(new BorderLayout());
			JPanel  panel = new JPanel();
			panel.setBackground(Color.blue);
			panel.setLayout(new FlowLayout());
			JTextField header_field = new JTextField();
			header_field.setText(header);
			header_field.setEditable(false);
			this.time = LocalTime.now();
			JTextField time_field = new JTextField();
			time_field.setText(this.time.toString());
			JButton button = new JButton("edit");
			JTextField author = new JTextField();
			author.setText(this.user.getNickname());
			time_field.setEditable(false);
			author.setEditable(false);
			panel.add(author);
			panel.add(header_field);
			panel.add(time_field);
			panel.add(button);
			JPanel inner = new JPanel();
			JTextArea written_area = new JTextArea();
			written_area.setEditable(false);
			written_area.setText(written);
			list1.add(header);
			this.user.getGroups().get(group).add(this);
			
			if(list2.keySet().contains(group)) {
				list2.get(group).add(this);
			}
			else {
				list2.put(group, new LinkedList<groupcontent>());
				list2.get(group).add(this);
			}
			
			
			
			
			button.addActionListener(
					new ActionListener() {

						@Override
						
						public void actionPerformed(ActionEvent e) {
							
							if(user != homefeed.user) {
								JOptionPane.showMessageDialog(null, "You can only edit your posts");
								
							}
							else {
								
								groupediting myframe = new groupediting(user,header,written,path,group);
								myframe.setSize(600, 500);
								myframe.setVisible(true);
								myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								
								
							}
							
						}
						
					}
					);
			
			
			
			if(this.path.equals("")) {
				
				inner.setLayout(new GridLayout(1,1));
				inner.add(written_area);
			}
			else {
				
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

}

