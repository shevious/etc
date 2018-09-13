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

## component lifecycle
http://busypeoples.github.io/post/react-component-lifecycle/  


## run ios on device

```
RCT_METRO_PORT=8081 react-native run-ios --device
```

## android https error on dev server

https://serverfault.com/questions/699853/ssl-will-not-work-on-android-mobile  
see production

## splash screen

### android

https://android.jlelse.eu/change-splash-screen-in-react-native-android-app-d3f99ac1ebd1  

## android device log 

```
$ adb logcat | grep ReactNativeJS
```


<!--stackedit_data:
eyJoaXN0b3J5IjpbMTUxNjkyMDE5LC0xODcxMDcwNDk1LDI0OD
AzODk0NCwxMzE5NjcwOTE0LDEzMTM2NDQ1NTEsLTEwMzMwMTcy
MTEsLTEyMTM3MzIzNTMsLTExMzIzNTY0NjMsODY5MzU4MTk3LD
cxMjM2NTI5OCwxNTQyNjM2NDUyLC0yMTI0NjgxMjU3LC0xODYw
ODg3MDg4LC0xNTkxMjU2MDc1XX0=
-->