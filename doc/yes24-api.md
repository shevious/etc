## mysql설정 
```
create database loginapi;
grant all privileges on loginapi.* to appuser@'%';
```

## sequelize cli 설치
```
npm install sequelize-cli -g
```

## app설치
```bash
git clone https://github.com/hckim0707/yes24-api.git
cd yes24-api
npm install
sequelize db:migrate
node createuser.js
^C

DEBUG=yes24-api:* npm start
```
browse http://localhost:4000



<!--stackedit_data:
eyJoaXN0b3J5IjpbMTA2ODA2MTM3OCwtODA3OTE0OTA2LC0xMD
YzMTU2NTc3LC0xNDM5Nzk4ODg1LDM1Mzk0OTMxMV19
-->