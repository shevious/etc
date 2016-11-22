## install memcached on ubuntu 12.04

    $ sudo apt-get install memcached
    $ sudo vi /etc/memcached.conf
    -l 0.0.0.0
    $ sudo service memcached restart
    
test:

    $ telnet <ipaddress> 11211
    quit
    
## memcached tomcat install

    $CATALINNA_HOME/lib
    
http://repo1.maven.org/maven2/de/javakaffee/msm/memcached-session-manager/  
http://repo1.maven.org/maven2/de/javakaffee/msm/memcached-session-manager-tc7/  
http://repo1.maven.org/maven2/net/spy/spymemcached/2.11.1/spymemcached-2.11.1.jar  

## tomcat 7 context.xml

     <Manager className='de.javakaffee.web.msm.MemcachedBackupSessionManager'
        memcachedNodes='n1:192.168.33.10:11211'
        requestUriIgnorePattern='.*\.(ico|png|gif|jpg|css|js)$' />

## memcached telnet  
Session Created :: C76B6318831695033A482A6803E845F3-n1

    $ telnet 192.186.33.10 11211
    stats items
    STAT items:6:number 1
    STAT items:6:age 15
    STAT items:6:evicted 0
    STAT items:6:evicted_nonzero 0
    STAT items:6:evicted_time 0
    STAT items:6:outofmemory 0
    STAT items:6:tailrepairs 0
    STAT items:6:reclaimed 0
    STAT items:6:expired_unfetched 0
    STAT items:6:evicted_unfetched 0
    END
    stats cachedump 6 1
    ITEM 50EA082CDFD57B313EC4711C84FB205E-n1 [168 b; 1479791320 s]
    END
    get 50EA082CDFD57B313EC4711C84FB205E-n1
    VALUE 50EA082CDFD57B313EC4711C84FB205E-n1 2048 168
    WXeX01XhXk#50EA082CDFD57B313EC4711C84FB205E-n1@srjava.lang.Integer⠤8Ivaluexrjava.lang.Number@
                                                                                             @xp
login:

    get 50EA082CDFD57B313EC4711C84FB205E-n1
    VALUE 50EA082CDFD57B313EC4711C84FB205E-n1 2048 195
    WXeX01X@X50EA082CDFD57B313EC4711C84FB205E-n1@srjava.lang.Integer⠤8Ivaluexrjava.lang.Number@
                                                                                           @xptidtadmintpwdtadmin

https://www.tutorialspoint.com/memcached/memcached_quick_guide.htm
