# celery

```bash
sudo apt-get install rabbitmq-server
#virtualenv
pip install celery
```

```bash
django-admin createproject mysite
cd mysite

```
mysite/settings.py
```python
CELERY_BROKER_URL = 'amqp://localhost'
```

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTQyMTAzNDA1MSwxNDk1NzAzMDgwXX0=
-->