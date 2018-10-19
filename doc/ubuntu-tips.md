
#### [Preserve colors while piping to tee](https://superuser.com/questions/352697/preserve-colors-while-piping-to-tee)
```bash
sudo apt-get install expect-dev
unbuffer ls -l --color=auto | tee

# or just
script --return -c "ls -l --color=auto" /dev/null
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbOTA5NTc4NDg1XX0=
-->