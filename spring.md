# tomcat on windows
http://jijs.tistory.com/entry/Maven-Tomcat-plugin-%EC%84%A4%EC%B9%98-%EB%B0%8F-%EC%9B%B9%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%83%9D%EC%84%B1%EB%B0%A9%EB%B2%95  

1. Java 8 JDK  
  Java SE Development Kit 8 Downloads  
  http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
2. Tomcat 7 with exe  
  http://tomcat.apache.org/download-70.cgi  
  install path c:\tomcat7  
3. Install Eclipse IDE for Java Developers  
  https://eclipse.org/downloads/eclipse-packages/  
4. Install Maven

        echo %JAVA_HOME%
        C:\Program Files\Java\jdk1.8.0_111
       
  Extract files to c:\maven, and add the c:\maven\bin to PATH variable

        C:\Users\vagrant>mvn -v
        Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-11T01:41:47+09:00)
        Maven home: c:\maven\bin\..
        Java version: 1.8.0_111, vendor: Oracle Corporation
        Java home: C:\Program Files\Java\jdk1.8.0_111\jre
        Default locale: ko_KR, platform encoding: MS949
        OS name: "windows 10", version: "10.0", arch: "amd64", family: "dos"

        
