# create-react-native

```bash
sudo sysctl -a | grep kern.maxfiles
kern.maxfiles: 49152
kern.maxfilesperproc: 24576
```
```bash
sudo sysctl -w kern.maxfiles=5242880
sudo sysctl -w kern.maxfilesperproc=524288
```


<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE1OTEyNTYwNzVdfQ==
-->