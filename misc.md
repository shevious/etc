#Tomcat 7 source
ubuntu svn client

    $ sudo apt-get install subversion
        
apache tomcat source  
http://tomcat.apache.org/download-70.cgi  

#Eclipse on mac
1. install jdk on mac  
  http://www.oracle.com/technetwork/java/javase/downloads/index.html?ssSourceSiteId=otnjp
2. check java folders

        $ cd /Library/Java/JavaVirtualMachines
        $ ls
        jdk1.8.0_111.jdk
        $ export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home"
        $ java -version

#Tomcat on ubuntu 12.04
https://www.digitalocean.com/community/tutorials/how-to-install-apache-tomcat-7-on-ubuntu-14-04-via-apt-get  
Installing JDK

    $ sudo add-apt-repository ppa:webupd8team/java
    $ sudo apt-get update
    $ sudo apt-get -y install oracle-java8-installer
    $ java -version
    java version "1.8.0_111"
    Java(TM) SE Runtime Environment (build 1.8.0_111-b14)
    Java HotSpot(TM) 64-Bit Server VM (build 25.111-b14, mixed mode)
    
Installing Tomcat 

    $ sudo update-alternatives --config java
    There is 1 choice for the alternative java (providing /usr/bin/java).

    Selection    Path                                     Priority   Status
    ------------------------------------------------------------
      0            /usr/lib/jvm/java-8-oracle/jre/bin/java   1081      auto mode
    * 1            /usr/lib/jvm/java-8-oracle/jre/bin/java   1081      manual mode
    
    $ sudo vi /etc/default/tomcat7
    JAVA_HOME="/usr/lib/jvm/java-8-oracle/jre/"

This tomcat version 7.0.26 is not working with JRE 8  
https://www.mkyong.com/tomcat/how-to-check-tomcat-version-installed/  
http://stackoverflow.com/questions/23484098/org-apache-tomcat-util-bcel-classfile-classformatexception-invalid-byte-tag-in  
tomcat log view  
http://stackoverflow.com/questions/4178605/tomcat-view-catalina-out-log-file  

running tomcat debugging mode  
https://confluence.sakaiproject.org/display/BOOT/Setting+Up+Tomcat+For+Remote+Debugging  

eclypse how to start/stop remote tomcat server:  
http://stackoverflow.com/questions/1681017/start-stop-tomcat-using-maven  

tomcat 7 versions for ubuntu 12.04
7.0.52 debian package  
http://packages.ubuntu.com/trusty/all/tomcat7/download 
latest version  
http://askubuntu.com/questions/339169/how-to-install-tomcat-7-0-42-on-ubuntu-12-04-3-lts  
http://tecadmin.net/install-tomcat-7-on-ubuntu  

#GPT key error
For example,

    $ sudo add-apt-repository ppa:webupd8team/java
    gpg: requesting key EEA14886 from hkp server keyserver.ubuntu.com
    ?: [fd 4]: read error: Connection reset by peer

Try:

    $ sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys  EEA14886



    
