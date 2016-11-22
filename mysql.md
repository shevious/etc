## mysql 5.6 windows
my.ini:
    
    basedir = C:/mysql-5.6.34-winx64
    datadir = C:/mysql-5.6.34-winx64/data

## mysql 5.6 ubuntu 12.04
method1:

    sudo add-apt-repository 'deb http://ppa.launchpad.net/ondrej/mysql-5.6/ubuntu precise main'
    sudo apt-get update
    sudo apt-get install mysql-server-5.6
    
method2:
http://askubuntu.com/questions/422612/installing-mysql-5-6-using-ppa

    #apt-get -y remove mysql-server
    #apt-get -y autoremove
    #sudo apt-get -y install software-properties-common
    sudo add-apt-repository -y ppa:ondrej/mysql-5.6
    sudo apt-get update
    sudo apt-get -y install mysql-server-5.6
    
