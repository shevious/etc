
#### [Preserve colors while piping to tee](https://superuser.com/questions/352697/preserve-colors-while-piping-to-tee)
```bash
sudo apt-get install expect-dev
unbuffer ls -l --color=auto | tee
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbNDE3NTQxMzk1XX0=
-->