# celery

http://docs.celeryproject.org/en/latest/getting-started/first-steps-with-celery.html  
https://simpleisbetterthancomplex.com/tutorial/2017/08/20/how-to-use-celery-with-django.html  

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
mysite/celery.py
```python
import os
from celery import Celery

os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'mysite.settings')

app = Celery('mysite')
app.config_from_object('django.conf:settings', namespace='CELERY')
app.autodiscover_tasks()
```
templates/generate_random_users.html
```html
   <form action="" method="post">
        {% csrf_token %}
        <table>
        {{ form }}
        </table>
        <input type="submit" value="Submit" />
    </form>
```
mysite/core/tasks.py
```python
import string

from django.contrib.auth.models import User
from django.utils.crypto import get_random_string

from celery import shared_task
import time

@shared_task
def sleeptask(total):
    time.sleep(total);
    return '{} sleeptask created with success!'.format(total)
```
mysite/forms.py
```python
from django import forms
from django.core.validators import MinValueValidator, MaxValueValidator

class GenerateRandomUserForm(forms.Form):
    total = forms.IntegerField(
        validators=[
            MinValueValidator(5),
            MaxValueValidator(500)
        ]
    )
```

mysite/views.py
```python
from django.contrib.auth.models import User
from django.contrib import messages
from django.views.generic.edit import FormView
from django.shortcuts import redirect

from .forms import GenerateRandomUserForm
from .core.tasks import sleeptask

class GenerateRandomUserView(FormView):
    template_name = 'generate_random_users.html'
    form_class = GenerateRandomUserForm

    def form_valid(self, form):
        print('########')
        total = form.cleaned_data.get('total')
        sleeptask.delay(total)
        messages.success(self.request, 'We are generating your random users! Wait a moment and refresh this page.')
        return redirect('/generate')
```
myste/urls.py
```python
#... 
#add generate url
urlpatterns = [
    path('admin/', admin.site.urls),
    path('generate/', GenerateRandomUserView.as_view()),
]
```

run
```bash
celery -A mysite worker -l info
```

install flower:
```bash
pip install flower
sudo rabbitmq-plugins enable rabbitmq_management
sudo service rabbitmq-server restart
```


# celery beat for multiple servers

[Single-beat](https://github.com/ybrs/single-beat)
(any daemon works!)   

[Red-beat](https://github.com/sibson/redbeat)  
(good for celery beat)

[celery-redundant-scheduler](https://github.com/MnogoByte/celery-redundant-scheduler)  
(looks good for celery.)  

[celerybeat - multiple instances & monitoring](https://stackoverflow.com/questions/28162338/celerybeat-multiple-instances-monitoring)  
(Q&A)  

[Distributed Task Locking in Celery](http://loose-bits.com/2010/10/distributed-task-locking-in-celery.html)  
(참고용)  

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTM3NzM5MDk2MSwtODcxNzI0NjI5LC0xMj
YyOTgwNTk0LC0zNjE0MjA2OTUsLTYwNTg5MTQyMCwxOTI3MDMz
NzU2LDE0OTU3MDMwODBdfQ==
-->