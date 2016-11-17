## Spring session
spring session using memchached  
http://stackoverflow.com/questions/25788969/memcached-with-spring-boot  

Spring Session - Spring Boot  
http://docs.spring.io/spring-session/docs/current/reference/html5/guides/boot.html  

Spring MVC 컨트롤러에서 Session 객체 사용하기  
http://blog.naver.com/PostView.nhn?blogId=moe61&logNo=150169887527  

Spring에서 Session을 이용한 로그인 처리 예제  
http://mungchung.com/xe/spring/21229  

Spring3 인터셉터와 세션을 이용하여 로그인 처리해보기  
http://hellogk.tistory.com/90  

persistent session store in tomcat  
https://gerrydevstory.com/2013/08/21/tomcat-7-jdbc-session-persistence/  

tomcat 7 official session configuration site  
http://tomcat.apache.org/tomcat-7.0-doc/config/manager.html  

tomcat 7 change session cookie name  
sessionCookieName attribute for the global context.xml (in CATALINA_BASE/conf/context.xml).  
http://tomcat.apache.org/migration-7.html#Session_manager_configuration  

set custom session id java  
http://stackoverflow.com/questions/15947407/set-custom-session-id-java-apache-tomcat  

    public class MySessionManager extends StandardManager {

        @Override
        protected synchronized String generateSessionId() { 
            String sessionId = <Your session id generation algo>;
            return sessionId;
        }
    }
    
하지만 generateSessionId가 SessionIdGenerator를 이용해서 사용하는 부분도 있음. 소스 추적 필요.  

