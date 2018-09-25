# --- !Ups
create table LOGIN_USER
(
   userid varchar(100) NOT NULL PRIMARY KEY,
   userpw varchar(100) NOT NULL,
   username varchar(1000) NOT NULL,
   usercategory int  NOT NULL,
   lastlogin datetime  NOT NULL,
   gender varchar(100),
   email  varchar(100),
   lineid  varchar(100),
   telephone varchar(100),
   birhtdate date
);

# --- !Downs
drop table LOGIN_USER;