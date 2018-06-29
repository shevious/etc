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
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE5MDY0NDMwMTUsMTQ5NTcwMzA4MF19
-->