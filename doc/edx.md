
# Hawthorn

[Open edX Hawthorn - Latest Info](https://raccoongang.com/blog/open-edx-hawthorn-latest-info/)  


## devstack
[Open edX Devstack](https://github.com/edx/devstack/blob/master/README.rst)  

install docker
configure docker
    cpu:2, memory: 6G
```bash
brew uninstall python
brew install python
```
add path to ~/.profile (optional)
```bash
# brew python unversioned path(optional)
export PATH=/usr/local/opt/python/libexec/bin:$PATH
```
```bash
pip3 install virtualenv
virtualenv venv
surce venv/bin/activate

sudo gem install docker-sync

cd workspace # or the root directory of devstack
git clone https://github.com/edx/devstack
cd devstack
# git tag
make requirements
make dev.clone
export OPENEDX_RELEASE=hawthorn.master 
make dev.checkout
make pull
make dev.sync.provision
make dev.sync.up

# shutdown
make stop
```

#### provision error

[sudo apt-get update failes due to Hash Sum mismatch](https://askubuntu.com/questions/760574/sudo-apt-get-update-failes-due-to-hash-sum-mismatch)

## pycharm

#### remote debugger  
environments:
`DEVSTACK_WORKSPACE=/Users/<username>/workspace`  
`OPENEDX_RELEASE=hawthorn.master`  
interpreter path:  
`/edx/app/edxapp/venvs/edxapp/bin/python`  

#### Preferences -> Languages & Frameworks -> Django

 - [x] Enable Django Support  
 Django Project Root: `/Users/<username>/workspace/edx-platform`    
 Settings: `lms/envs/devstack_docker.py`  
 Manage Scripts: `manage.py` (Select file with browser button)  


#### debugger(django server);  

Edit debugger configuration -> Add Django Server
Erase PORT.
additional options: `runserver 0.0.0.0:18000 --noreload`  
custom run command: `lms`  
env variable:                 
 -  `DJANGO_SETTINGS_MODULE=lms.envs.devstack_docker`    
 -    `PYTHONUNBUFFERED=1` 
 - [ ]  Uncheck `Include Parent Environment Variable`
             
working directory: `/edx/app/edxapp/edx-platform`  
local directory: `/Users/<username>/workspace/edx-platform`   
remote directory: `/edx/app/edxapp/edx-platform`  
Deselect "Add content..." and "Add source..."  

#### hang issue for debug run

[Python remote debugging using docker-compose hangs](https://youtrack.jetbrains.com/issue/PY-24191)  
[Pycharm Debugger hangs when using with docker-compose](https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000210730-Pycharm-Debugger-hangs-when-using-with-docker-compose)  

solution: use `--noreload` option.

### docker commands

```bash
#list all docker images:
docker container ls --all
docker-compose images

#docker images location-mac
/Users/<username>/Library/Containers/com.docker.docker/Data/vms

#start docker-sync daemon for edx 
make dev.sync.daemon.start

# run lms service only
docker-compose -f docker-compose.yml -f docker-compose-sync.yml up -d lms
```
### docker compose
http://raccoonyy.github.io/docker-usages-for-dev-environment-setup/

### pycharm remote resources
`~/Library/Caches/Pychar*`


## insights

#### before insights
```bash
(venv) sheviousui-iMac:devstack shevious$ docker images
REPOSITORY                TAG                 IMAGE ID            CREATED             SIZE
intellij/docker/compose   1.10.0              6d14511e6aa4        46 hours ago        59.3MB
pycharm_helpers           PY-173.4127.16      e88cb11c90a6        2 days ago          34.7MB
edxops/edxapp             hawthorn.master     ce5c8a6ce344        3 days ago          2.59GB
mysql                     5.6                 1f47fade220d        6 days ago          256MB
edxops/ecommerce          hawthorn.master     423970a14e56        5 weeks ago         1.76GB
edxops/discovery          hawthorn.master     c7f7c968b346        5 weeks ago         1.74GB
edxops/credentials        hawthorn.master     86a89709c525        5 weeks ago         1.62GB
busybox                   latest              e1ddd7948a1c        5 weeks ago         1.16MB
edxops/forum              hawthorn.master     6c80012890d2        6 weeks ago         1.25GB
edxops/notes              hawthorn.master     96b9c4f2b7b3        7 weeks ago         1.05GB
edxops/devpi              hawthorn.master     7f05492b3fcf        2 months ago        1.02GB
edxops/firefox            hawthorn.master     64e4b04ae13b        2 months ago        860MB
edxops/chrome             hawthorn.master     bfc16ec25edd        2 months ago        892MB
eugenmayer/unison         2.51.2.1            8131aeebf904        5 months ago        80.7MB
mongo                     3.2.16              16149f61df57        12 months ago       301MB
docker/compose            1.11.2              61252c282969        18 months ago       59.4MB
edxops/elasticsearch      devstack            bff0a7ae0833        19 months ago       347MB
docker/compose            1.10.0              62fbca31c5ee        20 months ago       59.3MB
memcached                 1.4.24              66438aa20444        2 years ago         132MB
```

<!--stackedit_data:
eyJoaXN0b3J5IjpbNDQ3Nzg0NzgwLDkyNjU5NTgyLC04NzE5Nz
k5ODcsNzEzNTg5NjM3LC02NzY2Nzc5MiwxNTYwNjk0MjA1LC01
MDEwNTYyNzgsLTEzMzMzOTk2MDMsMjA3NzAwNzU3OSwtNzUzOT
Y3NTAyLDk3NTg5MjYyOSw4NTgyODk2MTksLTExOTAyNjgxOTUs
MTExMjkyMTM1MSwtMTA3MTMxODA4Nyw0ODU4MDIwLC02MTk4Nj
I2XX0=
-->