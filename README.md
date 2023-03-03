COMP 132 Project Report

GUIDELINE
The first step of the application is log-in page. If you are existed user, then you can log-in to your account, if not, you need to sign up first. In the case that, user entered wrong password or nickname, it gives an error that says this user does not exist.
After the log-in page, the program goes to the homefeed page where all contents created by the persons user followed. In the homefeed, program did not show the contents that user created. It shows them in the profile page. In the homefeed, there are also post, groups, search, and log-out button. Log-out button simply log outs and open the login page again. Post button opens another page where user can create post. Post creation page have an option to choose photo to the content user want to post. Groups buttons open another page that shows the groups of the user. Lastly, user can search contents users and groups via the search area. If there is user whose nickname is same as the text entered in the search area, program will open the profile page of that user. If there is a group that has name, same as the text entered in the search area, the program will open the page of that group. And if there is a content shared by the persons that user followed or by the persons in the group user joined, the program will open the profile page of the user that owns the content, or programs opens the group page that contains the post.
In the profile page of the user, there are selections of deleting the profile, post content, see friends, edit profile, suggest users, and suggest groups. If user post content, new content will be created and will be presented both in the homefeed of other users and profile page of the main user. See friends’ button simply shows the users that main user followed. Edit profile’s task is to edit the information of the user. User can edit all its information except nickname. Suggest users and suggest groups buttons simply shows the suggestions for users and groups to follow and join.
In the profile page of other user, if main user follows the user, then there will be unfollow option. Also see friends, see groups buttons. If main user does not follow the user, then there will be button to follow the user.
In the groups page, if you are part of the group, then you can see the contents shared by the members of the group and you have option to leave the group and post contents if you want. Then you can see the members of the group. If you are the creator, you will have right to delete members from the group except yourself. If you want to delete yourself from the group, you must delete the group.  If you are not the part of the group, then you can join to the group.





PROJECT DESCRİPTİON
https://stackoverflow.com/questions/34072052/is-it-possible-to-add-an-image-png-as-an-attribute-of-a-java-class
https://examples.javacodegeeks.com/java-swing-layouts-example/
https://www.javatpoint.com/java-gridbaglayout
https://mkyong.com/swing/java-swing-jfilechooser-example/
https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
https://stackoverflow.com/questions/7064280/how-could-i-get-the-number-of-visible-windows-of-my-app

I used the listed resources to manage some difficulties I countered. I did not use window builder in this project. For the frames that should include scroll pane, I use grid layout. For the design I mainly use border layout. At the parts of border layout, I inserted panels to improve design. I generally set layout of the panels to the flow layout to provide horizontal aligning. I use JLabels to import images by setting the icon of the label to the image. Text areas are used to both take input from the user and show written parts of the contents to the user and show profile information to the user.
The content and group content classes are inherited from JLabel class to directly add them to panels I created. In order to add the contents according to the time they are created; I both use the lists which keeps all instances of content and group content. I also implement compareTo function to the content class which is super class of groupcontent to compare content and groupcontent objects according to their creation time.
In this project, I used lots of inner classes to implement action listeners to buttons. For example, I used post button to create content, sign up button in the sign-up page to create a new user. Most of the frames have back button to set the visibility of the frame to false.
Since I worked with different frames in this project, most of the frames have an instance variable called user whose work is to provide the transfer of the user between frames. Since I use frames, when new post is posted, its immediately drops to the homefeed of the other users. Because I always open a new frame closing the previous one. Also, there is a homefeed static user variable whose objective is to keep the user that uses the program. That way I could understand whether user is viewing its profile page or others profile page. Also, I could understand using homefeed static user, whether user is viewing the group they joined, or not.




https://stackoverflow.com/questions/7064280/how-could-i-get-the-number-of-visible-windows-of-my-app
With this resource I learnt how to get the number of open frames in application.

https://stackoverflow.com/questions/34072052/is-it-possible-to-add-an-image-png-as-an-attribute-of-a-java-class
In this resource, I looked for how to put image to my homepage where the user logins.


https://examples.javacodegeeks.com/java-swing-layouts-example/
Since I did not use Windowbuilder this resource helped me lot. I personally tried GridLayout, FlowLayout, BoxLayout, Gridlayout, GridBoxLayout. Eventually I used GridLayout, BorderLayout and FlowLayout. 

 
For example, in the content class, when I’m creating a content object which is subclass of JLabel; I used a main panel that has BorderLayout. And I inserted another panel to the north area of main pane. The inserted area has FlowLayout, and it contains all the information listed horizontally. And eventually adding JLabel with pic or not to the center area of the main panel, I created a content object:

https://www.javatpoint.com/java-gridbaglayout
I tried to use the GridBagLayout, but some of the futures seemed to be overly complex. When I am searching for GridBagLayout, I also learnt lot about GridLayout which I generally used.

https://mkyong.com/swing/java-swing-jfilechooser-example/

In this resource, I looked for a solution to how to use JFileChooser.  This resource helped me lot to take the path of the selected image as String and create object using this string as path instance variable of the newly created object.


https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
In this resource, there are solutions of how to add picture to panels. I used these resources when I am trying to change or set and show the profile picture of the user in the profile page.

CLASSES

Test
Test class where all the objects are instantiated. And all the operations are made. 
 
Content
Content class is derived from JLabel. It describes the posts shared by users.

Creategroup
It is a frame that allows user to input group information and create groups

Editing
Editing class is a frame used to edit contents shared by users by taking inputs from the user

Friendspage
It is like pop up frame that shows the friends of one user and allows user to go to the profile page of the
Followed users

Group_page
Group page is the frame where the groupcontents are added. It is like the main page of main group.  Its constructor differentiates according to the user’s position in group. (Creator, member or not a part of group)

Group_selection
It is like a pop-up frame that shows the groups of users and allow user to go to the group page of the groups



Groupcontent
Groupcontent is subclass of content. It stores group contents in hash map instead of lists, which is different from content class

Groupediting
It is editing page for group information. If you are the creator, then you can access this page

Groupposting
It is posting frame for groups

Homefeed
It is the main frame of the application. You can access groups, shared contents, profile pages from this frame

Homepage
It is the login page of the application

Member_selection
It is like a pop-up frame that shows the members of groups and allow the creator of the group to the delete members of the groups

Posting_page
It is the posting frame for normal content via taking inputs from the user.

Profile_page
It is the profile page frame of users. It differentiates whether you look at your profile, followed user profile or non-followed user profile.



Profileedit
It is a frame where user can edit its profile, giving inputs. Users last edited information are shown in the text areas.

Signuppage
It is a frame allow user to create an account. It gives error messages if user did not give valid inputs.

Suggestgroups
It is like a pop-up frame which shows groups to join according to the restraints given in the project overview. If there are not enough groups to suggest than it gives another group to join.

Suggestuser
It is like a pop-up frame which shows users to follow according to the restraints given in the project overview. If there are not enough users to suggest than it gives another user to join.

Groups
Groups class is where group object is implemented. It keeps all the group’s instances in a list to select and show some of them in the suggested groups part.

User
User class is where user objects are implemented. It keeps all nicknames to control if there are duplicate nicknames. It keeps all user instances to use later. It keeps all contents of user in a list. And it keeps all group contents of a user in a map since there are different groups and different group contents of single user.

Berke Kurtuldu 

