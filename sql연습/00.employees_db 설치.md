## employees_db 설치
1. employees db 생성
```sh
# mysql -p
MariaDB [(none)]> create database employees;
MariaDB [(none)]> create user 'hr'@'192.168.%' idenitified by 'hr';
MariaDB [(none)]> grant all privileges on employees.* to 'hr'@'192.168.%';
MariaDB [(none)]> flush privileges;
```

2. upload employees_db.zip
```sh
c:\ sftp kickscar@192.168.0.203
sftp:/home/kickscar> put D:\poscodx2024\강의\03.자료\MariaDB\employees_db.zip
```

3. restore employees db
```sh
# mv /home/kickscar/employees_db.zip .
# unzip employees_db.zip
# cd employees_db
# mysql -u root -D employees -p < employees.sql
```
    
