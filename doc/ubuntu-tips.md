
#### bash colors output 

[Preserve colors while piping to tee](https://superuser.com/questions/352697/preserve-colors-while-piping-to-tee)
[Trick an application into thinking its stdout is a terminal, not a pipe](https://stackoverflow.com/questions/1401002/trick-an-application-into-thinking-its-stdout-is-a-terminal-not-a-pipe)  
```bash
sudo apt install expect tcl
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


## apt-get update hash mismatch

```bash
sudo rm -rf /var/lib/apt/lists/*
```

# X11



```bash
# for bento/ubuntu-18.04
sudo apt-get install xbase-clients

#check
sudo apt-get install vim-gtk

#firefox
sudo apt-get install firefox

```
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTEzMjc0NTgxNDksMTY3Njc1MTQ3NCwtOT
U3NjM4MDA3LC0xMDM2NDYyMjQsLTE4NjczOTQ4NjYsOTA5NTc4
NDg1XX0=
-->