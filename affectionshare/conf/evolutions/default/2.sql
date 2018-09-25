# --- !Ups
create table POST_CATEGORY
(
   categoryid BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
   categoryname varchar(1000) NOT NULL,
   lastupdate datetime  NOT NULL,
   categorysort varchar(1000) NOT NULL
);

# --- !Downs
drop table POST_CATEGORY;