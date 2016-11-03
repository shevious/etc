
Getting Started
---------------
1. Get the code (e.g. clone the repository).
2. Install the Python/Node/Bower requirements:

        $ make develop

3. Setup your database:

        $ make migrate

4. Run the server:

        $ ./manage.py runserver 0.0.0.0:9000

By default the Django Default Toolbar is disabled. To enable it set the environmental variable ENABLE_DJANGO_TOOLBAR.

Alternatively, you can launch the server using:

        $ ENABLE_DJANGO_TOOLBAR=1 ./manage.py runserver

