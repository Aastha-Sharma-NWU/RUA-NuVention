# RUA-NuVention


Url of RUA app is http://ec2-18-116-24-84.us-east-2.compute.amazonaws.com/

Directions to use RUA App:

1. Register for first time users
 For registration users have to submit basic information like name, phone number, password.Once any user get registered they can login in the app
 
2. Login 
 In order to login into app user have to enter the registered phone number and password 

3. Role
For first time users, after login they will land up on roles page where they have to select their role either parent or student(as of now we have these two roles only in future we might be having more roles if scope of app will be upgraded)

4. Survey
After selecting role users will be directed to survey page where they have fill following information:
How many audio or video calls and text messages they prefer to make to their parents/child during the week .
How many days they are comfortable with no calls to their parents/child
In case of the user being a student they can also select the offlimit topics which they don't want their parents to bring up in the conversation.
 
 5. Dashboard
After submitting survey users will land up on dashboard page where they can see their calls logs for that week

A ring with audio call shows x/y represents actual/planned calls
it means x calls actually  have been done by a user so far in this week, user can click on + button to log more calls or - in case he log more than what he wants to by mistake

Planned calls represents the number of calls planned for you this week by our app RUA.This value is basically the average of values submitted by both parents and students in their surveys.(By the time only one party has filled the survey it represent the actual numbers filled by them) 

If a user is not a new user after logging he will land up on the dashboard directly.

6. Settings
On dashboard we have settings button, on clicking that user will land on settings page where he/she can 

6.1. Update his/her profile 

6.2. Modify his/her survey

6.3. See the communication preferences: which means what all preferences user select in his survey and what is filled by the other party(their child or parent as per the case)

6.4. See the plan suggested by RUA

6.5. Feedback:Users can submit their feedback where parents and students  can fill in whether they are happy with current communication or not. Students have one more option to answer if their parents are respecting their offlimit topics or not.
These feedback values are also utilized in sending notifications to users.Apart from that these values are used by RUA in order to work on their plan creation methods

6. Logout from the app

7. Notifications

Case1: A gentle reminder will be send to parents’ phone in form of text message in following case
A. If they will calling or texting more than planned per week

B. If students submit in their feedback form that their parents are not respecting offlimit topics

Case 2: A gentle reminder will be send to students’ phone in form of text message in following case

A. If they are have not called their parents since maximum  number of no calls days planned

In case of any trouble in running app you can reach out any of the following email ids:

Aastha : aasthasharma2022@u.northwestern.edu

Jiang: Jiangli2021@u.northwestern.edu

Cesar: cesarvazquez2021@u.northwestern.edu

Janea: janeawilson2022@u.northwestern.edu

Hongxu: HongxuSong2022@u.northwestern.edu

For development purpose

Setup:
 
Install the JAVA 8,Intellij and MySQL workbench

Set the environment variable: 

You may need to set your JAVA_HOME.

Clone the git repository https://github.com/nuvention-web/B-2021-Q2

Import the project into intellij

Run:
Mvn clean install

Deployment on AWS:

Generate war ,create EC2 instances and deploy the war on EC2 instances.

Programming language used:Java

DataBase : MqSQL

Framework:SpringBoot




