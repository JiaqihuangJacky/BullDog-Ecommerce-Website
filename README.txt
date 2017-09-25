07/10/2017
1)Update: adding fileupload functon
xml changed
create new Uploadservlet
putting two common jar into the libary
create message.jsp upload.jsp
download can be found from http://www.codejava.net/download-attachment?fid=153
file come from: http://www.codejava.net/java-ee/servlet/eclipse-file-upload-servlet-with-apache-common-file-upload

Adding the UI design from the website 
css html file are under the webContent

Adding login in view and function
http://www.javaknowledge.info/login-and-registration-example-in-jsp-with-session/

---------------------------------------------------------------------------------------------------------------------------
07/11/2017
Adding paypal demo under demo dir
Paypal account has been set up
You need to install springboot before you run your program
Since we are doing the develop paypal, we can create and manipulate the account money we want
Example: we set up 9999 in a business account, after we pay(fix amount such as 999).
         Then, if we login into out account, then we can pay 999 to the second account
         then the money will be 9000.
 Related link of tutorial: http://blog.csdn.net/change_on/article/details/73881791
 
---------------------------------------------------------------------------------------------------------------------------
07/12/2017 17:17
adding new item function has been update
Creating a new form
Making a new categries before inserting new product
There are 4 types error I have fixed, such as 
id, seller, and price, they need to be cast to int / double
before inserting into database

---------------------------------------------------------------------------------------------------------------------------
07/13/2017 17:17
adding
deleting
updating
function has been created in productController.java
You can modifiy it as a management system
Updating your library to use c 