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
# add DIRS to templates folder
TEMPLATES = [
    {
        'BACKEND': 'django.template.backends.django.DjangoTemplates',
        'DIRS': ['templates'],
        'APP_DIRS': True,
        'OPTIONS': {
            'context_processors': [
                'django.template.context_processors.debug',
                'django.template.context_processors.request',
                'django.contrib.auth.context_processors.auth',
                'django.contrib.messages.context_processors.messages',
            ],
        },
    },
]
```
templates/
```html
   <form action="" method="post">
        {% csrf_token %}
        <table>
        {{ form }}
        </table>
        <input type="submit" value="Submit" />
    </form>
```

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTg3NjM2ODE0LDE0OTU3MDMwODBdfQ==
-->