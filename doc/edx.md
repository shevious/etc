
# Hawthorn

[Open edX Hawthorn - Latest Info](https://raccoongang.com/blog/open-edx-hawthorn-latest-info/)  


## devstack

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
export 
```


<!--stackedit_data:
eyJoaXN0b3J5IjpbNDg1ODAyMCwtNjE5ODYyNl19
-->