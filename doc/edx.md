
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

<!--stackedit_data:
eyJoaXN0b3J5IjpbOTI2NTk1ODIsLTg3MTk3OTk4Nyw3MTM1OD
k2MzcsLTY3NjY3NzkyLDE1NjA2OTQyMDUsLTUwMTA1NjI3OCwt
MTMzMzM5OTYwMywyMDc3MDA3NTc5LC03NTM5Njc1MDIsOTc1OD
kyNjI5LDg1ODI4OTYxOSwtMTE5MDI2ODE5NSwxMTEyOTIxMzUx
LC0xMDcxMzE4MDg3LDQ4NTgwMjAsLTYxOTg2MjZdfQ==
-->