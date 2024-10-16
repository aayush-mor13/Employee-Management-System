
Create database ems;
use ems;
Create Table login(username varchar(20), password varchar(20));

insert into login values("admin","1234");
select * from login;

Create Table employee(name varchar(20), sname varchar(20), dob varchar(30), salary varchar(20), address varchar(100), mob varchar(30), email varchar(30),highestedu varchar(20), designation varchar(30), aadhar varchar(40), empId varchar(15));
select * from employee;
