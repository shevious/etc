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
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTY5MzYxMDI0LC0xNjQzMDY1MTE2LC0xOT
ExNjA0NzMzXX0=
-->