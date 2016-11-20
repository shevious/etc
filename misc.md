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



    
