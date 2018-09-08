
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
add path to ~/.profile
```bash
# brew python unversioned path
export PATH=/usr/local/opt/python/libexec/bin:$PATH
```
```bash
pip install virtualenv
virtualenv venv
surce venv/bin/activate

cd workspace # or the root directory of devstack
git clone https://github.com/edx/devstack
cd devstack
# git tag
make requirements
make dev.clone
export OPENEDX_RELEASE=hawthorn.master 
make dev.checkout
make pull
make dev.provision
```

#### provision error

[sudo apt-get update failes due to Hash Sum mismatch](https://askubuntu.com/questions/760574/sudo-apt-get-update-failes-due-to-hash-sum-mismatch)

#### pycharm
remote debugger
`DEVSTACK_WORKSPACE=/Users/<username>/workspace`
`OPENEDX_RELEASE=hawthorn.master`
interpreter path:
`/edx/app/edxapp/venvs/edxapp/bin/python`

debugger(django server);
additional options: `runserver 0.0.0.0:18000`
custom run command: `lms`
env variable: `DJANGO_SETTINGS_MODULE=lms.envs.devstack_docker`
working directory: `/edx/app/edxapp/edx-platform`



### docker commands
list all docker images:
```bash
docker container ls --all
docker-compose images
```

### pycharm remote resources
`~/Library/Caches/Pychar*`

<!--stackedit_data:
eyJoaXN0b3J5IjpbMjAxMjI1ODAxNywtNzUzOTY3NTAyLDk3NT
g5MjYyOSw4NTgyODk2MTksLTExOTAyNjgxOTUsMTExMjkyMTM1
MSwtMTA3MTMxODA4Nyw0ODU4MDIwLC02MTk4NjI2XX0=
-->