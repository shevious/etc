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
```json
"scripts": {
  "start": "react-native-scripts start",
  "eject": "react-native-scripts eject",
  "android": "react-native-scripts android",
  "ios": "react-native-scripts ios",
  "test": "jest"
}
```
```bash
npm install react-native-scripts --save
npm install
npm start
```

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTIxMjQ2ODEyNTcsLTE4NjA4ODcwODgsLT
E1OTEyNTYwNzVdfQ==
-->