
#### [Preserve colors while piping to tee](https://superuser.com/questions/352697/preserve-colors-while-piping-to-tee)
```bash
sudo apt-get install expect-dev
unbuffer ls -l --color=auto | tee

# or just
script --return -c "ls -l --color=auto" /dev/null

faketty() {
    script -qfc "$(printf "%q " "$@")" /dev/null
}
$ python -c "import sys; print sys.stdout.isatty()"
True
$ python -c "import sys; print sys.stdout.isatty()" | cat
False
$ faketty python -c "import sys; print sys.stdout.isatty()" | cat
True
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTgzNjQzODMyOCw5MDk1Nzg0ODVdfQ==
-->