/* Pledge of Honor ***********************************************************************************
I hereby certify that I have completed this programming project on my own without any help from
anyone else. The effort in the project thus belongs completely to me. I did not search for a
solution, or I did not consult to any program written by others or did not copy any program from
other sources. I read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Berke Kurtuldu,0076351>
************************************************************************************************************/
package project;

import java.awt.Frame;
import java.io.IOException;
import java.time.LocalTime;
import java.util.LinkedList;

import javax.swing.JFrame;

import users.groups;
import users.user;



public class test {

	public static void main(String[] args) throws IOException {
		
		homepage myframe = new homepage();
		
		myframe.setSize(600, 500);
		myframe.setVisible(true);
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		user user1 = new user("Berke","12345","Berke Kurtuldu",21,"berkeberke61752@gmail.com",
				new LinkedList<String>(),false,"C:/Users/berke/eclipse-workspace/project/src/users/default.png","Turkey");
		user1.getHobbies().add("Physics");
		
		user user2 = new user("Ahmet","12345","Ahmet Sahin",25,"ahmetsahin@gmail.com",
				new LinkedList<String>(),false,"C:/Users/berke/eclipse-workspace/project/src/users/default.png","Brazil");
		user2.getHobbies().add("Diving");
		
		user user3 = new user("Mehmet","12345","Mehmet Olmez",27,"mehmetolmez@gmail.com",
				new LinkedList<String>(),true,"C:/Users/berke/eclipse-workspace/project/src/users/default.png","Turkey");
		user3.getHobbies().add("Basketball");
		
		user user4 = new user("Mahmut","12345","Mahmut Tuncer",28,"mahmuttuncer@gmail.com",
				new LinkedList<String>(),false,"C:/Users/berke/eclipse-workspace/project/src/users/default.png","Sweden");
		user4.getHobbies().add("Writing");
		
		user user5 = new user("Ayse","12345","Ayse Kutanoglu",31,"aysekutanoglu@gmail.com",
				new LinkedList<String>(),false,"C:/Users/berke/eclipse-workspace/project/src/users/default.png","ABD");
		user5.getHobbies().add("Reading");
		
		user user6 = new user("Sebnem","12345","Sebnem Ferah",45,"sebnemferah@gmail.com",
				new LinkedList<String>(),true,"C:/Users/berke/eclipse-workspace/project/src/users/default.png","Finland");
		user6.getHobbies().add("Bitcoin");
		
		user user7 = new user("Begum","12345","Begum Yilmaz",54,"begumyilmaz@gmail.com",
				new LinkedList<String>(),false,"C:/Users/berke/eclipse-workspace/project/src/users/default.png","Norway");
		user7.getHobbies().add("Horror films");
		
		user user8 = new user("Ardil","12345","Ardil Baran",17,"ardilbaran@gmail.com",
				new LinkedList<String>(),false,"C:/Users/berke/eclipse-workspace/project/src/users/default.png","Norway");
		user8.getHobbies().add("Chemistry");
		
		user user9 = new user("Ozgun","12345","Ozgun Bali",32,"ozgunbali@gmail.com",
				new LinkedList<String>(),true,"C:/Users/berke/eclipse-workspace/project/src/users/default.png","Sweden");
		user9.getHobbies().add("Travelling");
		
		user user10 = new user("Mert","12345","Mert Kaygusuz",13,"mertkaygusuz@gmail.com",
				new LinkedList<String>(),false,"C:/Users/berke/eclipse-workspace/project/src/users/default.png","Brazil");
		user10.getHobbies().add("Computers");
		
		user user11 = new user("Kadir","12345","Kadir Sakallioglu",62,"kadirsakallioglu@gmail.com",
				new LinkedList<String>(),false,"C:/Users/berke/eclipse-workspace/project/src/users/default.png","Hungary");
		user11.getHobbies().add("Math");
		
		user user12 = new user("Davut","12345","Davut Yikilmaz",14,"davutyikilmaz@gmail.com",
				new LinkedList<String>(),true,"C:/Users/berke/eclipse-workspace/project/src/users/default.png","Italy");
		user12.getHobbies().add("Adventure films");
		
		
		user1.following(user2);
		user1.following(user12);
		user1.following(user9);
		
		user2.following(user3);
		user2.following(user7);
		user2.following(user6);
		
		user3.following(user4);
		user3.following(user1);
		user3.following(user11);
		
		user4.following(user10);
		user4.following(user12);
		user4.following(user8);
		
		user5.following(user11);
		user5.following(user9);
		user5.following(user8);
		
		user6.following(user4);
		user6.following(user5);
		user6.following(user7);
		
		user7.following(user8);
		user7.following(user2);
		user7.following(user1);
	
		user8.following(user11);
		user8.following(user12);
		user8.following(user9);
		
		user9.following(user10);
		user9.following(user12);
		user9.following(user6);
		
		user10.following(user11);
		user10.following(user12);
		user10.following(user9);
		
		user11.following(user1);
		user11.following(user2);
		user11.following(user7);
		
		user12.following(user6);
		user12.following(user1);
		user12.following(user2);
		
		groups group1 = new groups("KUSAS","Turkey",new LinkedList<String>(),user1);
		groups group2 = new groups("CRYPTO","Turkey",new LinkedList<String>(),user2);
		groups group3 = new groups("HORROR FILM LOVERS","Turkey",new LinkedList<String>(),user4);
		groups group4 = new groups("QUANTUM PHYSICS","Turkey",new LinkedList<String>(),user5);
		
		group1.getHobbies().add("Diving");
		group2.getHobbies().add("Bitcoin");
		group3.getHobbies().add("Horror films");
		group4.getHobbies().add("Physics");
		
		group1.addMember(user12);
		group1.addMember(user10);
		group1.addMember(user4);
		
		
		group2.addMember(user8);
		group2.addMember(user3);
		
		
		group3.addMember(user9);
		group3.addMember(user1);
		group3.addMember(user5);
		group3.addMember(user6);
		
		group4.addMember(user7);
		group4.addMember(user2);
		group4.addMember(user11);
		
		
		content content1 = new content("","Did you guyss watched True Detective!","Series",user1);
		content content2 = new content("","Dont you think life is a little bit meaningless!","Life",user1);
		content content3 = new content("","I got a comp project to finish Hurrayy!","Project",user1);
		groupcontent content4 = new groupcontent("C:/Users/berke/eclipse-workspace/project/src/true-detective-symbol-100978.png"
				,String.format("I know its not a horror movie but this series %nis a masterpiece", args),"True Detective",user1,group3);
		
		content content5 = new content("","How did Fiorentina manage to beat Milan!","Football",user2);
		content content6 = new content("","I really did not understand why Earth does not fall onto Sun!","Science",user2);
		content content7 = new content("","What do you do in your freetime?","Boring",user2);
		groupcontent content8 = new groupcontent("C:/Users/berke/eclipse-workspace/project/src/belirsizlik-ilkesi.png"
				,"These formulas will change the world forever.\nJust believe me!","Quantum",user2,group4);
		
		content content9 = new content("","Math is the only key to understand the nature.","Math",user3);
		content content10 = new content("","Today school was boring!","School",user3);
		content content11 = new content("","The best hamburger shop in town is Baltazar","Food",user3);
		groupcontent content12 = new groupcontent("C:/Users/berke/eclipse-workspace/project/src/810ca0c6-2553-4036-85f9-0a46cca52122.jpg"
				,"I bet Bitcoin will hit 100.000 $ at the\n end of the year ","BTC",user3,group2);
		
		content content13 = new content("","Suicide is very close maybe!","Sadness",user4);
		content content14 = new content("C:/Users/berke/eclipse-workspace/project/src/Sodyum-hidroksit.jpg","Please do not pour water on NaOH","Chemistry",user4);
		content content15 = new content("","Anyone in the town who wants to play basketball","Basketball",user4);
		groupcontent content16 = new groupcontent("","When will be the next trip?","Diving",user4,group1);
		
		content content17 = new content("C:/Users/berke/eclipse-workspace/project/src/rwUTspI9_mid.png","Dollar is gaining power right now!","Economy",user5);
		content content18 = new content("","I love but it hurts","Broken hearted",user5);
		content content19 = new content("","My bench press is increasing!","Gym",user5);
		groupcontent content20 = new groupcontent("","I really really scared when im watching Hereditary!","Horrorr",user5,group3);
		
		content content21 = new content("","Today is the best day of my life","Happiness",user6);
		content content22 = new content("","Will robots takeover?","AI",user6);
		content content23 = new content("","Stephen Curry is the GOAT","NBA",user6);
		groupcontent content24 = new groupcontent("C:/Users/berke/eclipse-workspace/project/src/intro-1612714481.jpg","Classicc!","Screammm",user6,group3);
		
		content content25 = new content("C:/Users/berke/eclipse-workspace/project/src/action_block_2_1080x1080.jpg","Look at my lovely family!!","Family",user7);
		content content26 = new content("","My life got me disappointed again :(","Disappointment",user7);
		content content27 = new content("","Love to watch tennis","Tennis",user7);
		groupcontent content28 = new groupcontent("","Why quantum physicists do not love Einstein?","Einstein",user7,group4);
		
		content content29 = new content("","I hate cleanningggggg!!!!","Cleaning",user8);
		content content30 = new content("","When you burn magnesium, there will be an unharmful explosion","Chemistry advice",user8);
		content content31 = new content("C:/Users/berke/eclipse-workspace/project/src/Graffiti-Berlin-Wall.jpg","Graffities are beautiful across the streets","Streets",user8);
		groupcontent content32 = new groupcontent("","I lost all my money while i trading LUNA","LUNA",user8,group2);
		
		content content33 = new content("","I do not understand anything about computers","Computers",user9);
		content content34 = new content("","Todayy my cancer got cured :)))))","IM HAPPPYYY",user9);
		content content35 = new content("C:/Users/berke/eclipse-workspace/project/src/carrots-7-1200.jpg","Eating carrots may heal your eyes!","Interesting information",user9);
		groupcontent content36 = new groupcontent("","You guyss should watch Primer by Shane Caroot","Primer",user9,group3);
		
		content content37 = new content("","I love to listen Amzonia by Gojhira!","Song",user10);
		content content38 = new content("","I broke my arm today :(((","Fracture",user10);
		content content39 = new content("","I have some gossipss :)","Gossip",user10);
		groupcontent content40 = new groupcontent("C:/Users/berke/eclipse-workspace/project/src/60244.jpg","Here is my photo underwater!!","Scuba Diving",user10,group1);
		
		content content41 = new content("C:/Users/berke/eclipse-workspace/project/src/artworks-WNzrzG6Yh1VRBSBF-utokcg-t500x500.jpg","Listen to this song immediately","Songss",user11);
		content content42 = new content("","I did not think that i will get an A at physics","Physics note",user11);
		content content43 = new content("","WOWWW, my father bought me a carrr!","WOWWW",user11);
		groupcontent content44 = new groupcontent("","Heisenberg really changed the world!","Heisenberg",user11,group4);
		
		content content45 = new content("C:/Users/berke/eclipse-workspace/project/src/bigstock-Happy-Young-Couple-Driving-Alo-98409830.jpg","Check my roadtrip list on my spotifyy!!","Listening song",user12);
		content content46 = new content("","I got a job at the college i graduated","College",user12);
		content content47 = new content("","Watching formula 1 is the most interesting thing ever","RACE",user12);
		groupcontent content48 = new groupcontent("","I think i really hurt my ear while diving","MY EARR",user12,group1);
		
		
		
		
		
	}
	
	
	
	public static LinkedList<Frame> getFrames() {
		
		LinkedList<Frame> returnlist = new LinkedList<Frame>();
		for(int i = 0; i< Frame.getFrames().length;i+=1) {
			if(Frame.getFrames()[i].isVisible()) {
				returnlist.add(Frame.getFrames()[i]);
			}
		}
		return returnlist;
	}

}
