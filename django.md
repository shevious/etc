# django with pyc only

```bash
virtualenv venv
. venv/bin/activate
pip install django==1.10
pip install gunicorn
django-admin startproject mysite
cd mysite
python manage.py migrate
gunicorn --env DJANGO_SETTINGS_MODULE=mysite.settings mysite.wsgi -b 0.0.0.0:8000
rm mysite/*.py

```

# python 3.6 local install
```bash
sudo apt-get install build-essential checkinstall 
sudo apt-get install libreadline-gplv2-dev libncursesw5-dev libssl-dev libsqlite3-dev tk-dev libgdbm-dev libc6-dev libbz2-dev
# for mysql
sudo apt-get install python-dev libmysqlclient-dev

cd ~
mkdir tmp
cd tmp
wget https://www.python.org/ftp/python/3.6.6/Python-3.6.6.tgz
tar zxvf Python-3.6.6.tgz   
cd Python-3.6.6   
./configure --prefix=$HOME/opt/python-3.6.6
make
make install

export PATH=$HOME/opt/python-3.6.6/bin:$PATH
virtualenv --python=python3 venv
source venv/bin/activate
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbOTEzOTQ2NzE5LC0xNjQzMDY1MTE2LC0xOT
ExNjA0NzMzXX0=
-->