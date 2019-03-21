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
        
3. install eclipse  
  https://eclipse.org/downloads/eclipse-packages/  
  Select mirror at KAIST.
4. install maven  

        /Users/shevious/Documents/workspace/apache-maven-3.3.9
        $ vi ~/.profile
        export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home"
        export PATH=/Users/shevious/Documents/workspace/apache-maven-3.3.9/bin:$PATH
        $ mvn -v
        Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-11T01:41:47+09:00)
        Maven home: /Users/shevious/Documents/workspace/apache-maven-3.3.9
        Java version: 1.8.0_111, vendor: Oracle Corporation
        Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/jre
        Default locale: ko_KR, platform encoding: UTF-8
        OS name: "mac os x", version: "10.12.1", arch: "x86_64", family: "mac"
       
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
simple and working:
http://tecadmin.net/install-tomcat-7-on-ubuntu  

# gpg key error

For example,

    $ sudo add-apt-repository ppa:webupd8team/java
    gpg: requesting key EEA14886 from hkp server keyserver.ubuntu.com
    ?: [fd 4]: read error: Connection reset by peer

Try: (still error)

    $ sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys  EEA14886
    Executing: gpg --ignore-time-conflict --no-options --no-default-keyring --secret-keyring /tmp/tmp.alSdmyui9W --trustdb-name /etc/apt/trustdb.gpg --keyring /etc/apt/trusted.gpg --primary-keyring /etc/apt/trusted.gpg --keyserver keyserver.ubuntu.com --recv-keys EEA14886
    gpg: requesting key EEA14886 from hkp server keyserver.ubuntu.com
    ?: [fd 4]: read error: Connection reset by peer
    gpg: key EEA14886: "Launchpad VLC" not changed
    gpg: Total number processed: 1
    gpg:              unchanged: 1

simple python proxy server  
https://github.com/inaz2/proxy2  
The server works good. But the connection reset by peer continues.  
Maybe it is because of KT internet firewall.  
Try using hkps (https).

    $ sudo apt-key adv --keyserver hkps://keyserver.ubuntu.com --recv-keys  EEA14886

Then, certificate error.  
The workaround is install gnupg-curl

    $ sudo apt-get install gnupg-curl
    
The error gone. WHY?
https://packages.debian.org/sid/gnupg-curl  

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTg1ODU4ODU0XX0=
-->