
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


### docker commands
list all docker images:
```bash
docker container ls --all
docker-compose images
```

### pycharm remote resources
`~/Library/Caches/Pychar*`

<!--stackedit_data:
eyJoaXN0b3J5IjpbOTc1ODkyNjI5LDg1ODI4OTYxOSwtMTE5MD
I2ODE5NSwxMTEyOTIxMzUxLC0xMDcxMzE4MDg3LDQ4NTgwMjAs
LTYxOTg2MjZdfQ==
-->