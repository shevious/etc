# create-react-native

```bash
sudo sysctl -a | grep kern.maxfiles
kern.maxfiles: 49152
kern.maxfilesperproc: 24576

brew install watchman
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

```bash
#link
react-native link react-native-vector-icons
#unlink
react-native unlink react-native-vector-icons
```

java 9 error:
```
FAILURE: Build failed with an exception.
* What went wrong:
Could not determine java version from '9.0.1'.
```
install jdk: Java SE Development Kit 8u181



## react-native-app devtools: 

[react-devtools](https://github.com/facebook/react-devtools/tree/master/packages/react-devtools)  
[Using react-devtools with React Native](https://blog.expo.io/using-react-devtools-with-react-native-6c59e636a03b)  
[React Native Debugging Tools](https://codeburst.io/react-native-debugging-tools-3a24e4e40e4)   

## android https error on dev server

https://serverfault.com/questions/699853/ssl-will-not-work-on-android-mobile  
see production

<!--stackedit_data:
eyJoaXN0b3J5IjpbMTMxMzY0NDU1MSwtMTAzMzAxNzIxMSwtMT
IxMzczMjM1MywtMTEzMjM1NjQ2Myw4NjkzNTgxOTcsNzEyMzY1
Mjk4LDE1NDI2MzY0NTIsLTIxMjQ2ODEyNTcsLTE4NjA4ODcwOD
gsLTE1OTEyNTYwNzVdfQ==
-->