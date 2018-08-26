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

## splash screen

### android

https://android.jlelse.eu/change-splash-screen-in-react-native-android-app-d3f99ac1ebd1  



<!--stackedit_data:
eyJoaXN0b3J5IjpbMTMxOTY3MDkxNCwxMzEzNjQ0NTUxLC0xMD
MzMDE3MjExLC0xMjEzNzMyMzUzLC0xMTMyMzU2NDYzLDg2OTM1
ODE5Nyw3MTIzNjUyOTgsMTU0MjYzNjQ1MiwtMjEyNDY4MTI1Ny
wtMTg2MDg4NzA4OCwtMTU5MTI1NjA3NV19
-->