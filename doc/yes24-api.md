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
```



<!--stackedit_data:
eyJoaXN0b3J5IjpbLTEwNjMxNTY1NzcsLTE0Mzk3OTg4ODUsMz
UzOTQ5MzExXX0=
-->