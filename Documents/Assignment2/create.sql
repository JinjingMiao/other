create TABLE person (
  id int (10) NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(255) default NULL,
  lastName VARCHAR(255) default NULL,
  type varchar (255) default null,
  userName VARCHAR(255) default NULL,
  password VARCHAR(255) default NULL,
  email VARCHAR(255) default NULL,
  keyword varchar (255) default null,
  PRIMARY KEY (id)
  
  
  );
  
  
  drop table if exists User_person_generalization;
 CREATE TABLE User_person_generalization(
  id int (10) NOT NULL,
  userAgreement boolean not null,
  FOREIGN KEY (id) REFERENCES cs5200.person(id)
  );

 CREATE TABLE Developer_person_generalization(
  id int (10) NOT NULL AUTO_INCREMENT,
  developerKey varchar(255) not null,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES person(id)
  );
  
  
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS website;
SET FOREIGN_KEY_CHECKS=1;

  CREATE TABLE website (
  id int (10) NOT NULL AUTO_INCREMENT,
  name VARCHAR(40) NOT NULL,
  description VARCHAR(255) NOT NULL,
  created DATETIME NOT NULL,
  updated DATETIME NOT NULL,
  visits INT NOT NULL,
  PRIMARY KEY (id));
  
  
drop table if exists page;
 
  CREATE TABLE page (
  id int (10) NOT NULL AUTO_INCREMENT,
  title VARCHAR(20) NOT NULL,
  description VARCHAR(255) NOT NULL,
  created DATETIME NOT NULL,
  updated DATETIME NOT NULL,
  website varchar(255) not null,
  views INT(20) NOT NULL,
  PRIMARY KEY (id)
  
  );
  
 




create table page_role(
 role varchar(20) default null,
 
 FOREIGN KEY(role) REFERENCES role (name)

);
 insert role (name) values ('owner');
 insert role (name) values ('admin');
 insert role (name) values ('writer');
 insert role (name) values ('editor');
 insert role (name) values ('reviewer');
 
 
 
  
  
 drop table widget;
CREATE TABLE widget (
dtype varchar(31) NOT NULL,
id int (10) NOT NULL AUTO_INCREMENT,
name varchar (20) not null,
width varchar(40) not null,
height varchar(40) not null,
cssClass varchar(40) not null,
cssStyle varchar(40) not null,
 text varchar(40) not null,
`order`  int(20) not null,
src varchar(255) not null,
url varchar(255) not null,
page varchar(255) not null,
shareable varchar (255) default null,
expandable varchar (255) default null,
size boolean default null,
html varchar(255) default null,
PRIMARY KEY (id)
);


 
drop table if exists priviledge; 
  
create table priviledge(
name varchar (255)  NOT NULL,
PRIMARY KEY (name)

 );
 
 drop table if exists page_priviledge;
 
  create table page_priviledge(
 priviledge varchar (255) default null,
 
 FOREIGN KEY
 (priviledge) REFERENCES priviledge (name)

);
insert priviledge (name) values ('create');
 insert priviledge (name) values ('read');
 insert priviledge (name) values ('update');
 insert priviledge (name) values ('delete');

 drop table  if exists website_priviledge;
 create table website_priviledge(
 priviledge varchar (255) default null,
 
 FOREIGN KEY
 (priviledge) REFERENCES priviledge (name)

);
  -- drop table role;
  create table role(
 name varchar(255) NOT NULL ,
  PRIMARY KEY (name)
 );
 
 insert role (name) values ('owner');
 insert role (name) values ('admin');
 insert role (name) values ('writer');
 insert role (name) values ('editor');
 insert role (name) values ('reviewer');
 
 
 
 create table website_role(
 role varchar(20) default null,
 
 FOREIGN KEY
 (role) REFERENCES role (name)

);
 
 
 insert into website_role(role) values ('owner');
 insert into website_role (role) values ('admin');
 insert into website_role(role) values ('editor');
 
 insert into page_role (role) values ('owner');
 select * from  page_priviledge;


drop table if exists phone;
create table phone(
  id int (10) NOT NULL AUTO_INCREMENT,
  phone VARCHAR(40) NOT NULL,
  username varchar (255) Not null,
  PRIMARY KEY (id)
   );

drop table if exists address;
create table address(
id int (10) NOT NULL AUTO_INCREMENT,
street1 varchar(255) NOT NULL,
street2 varchar (255) NOT NULL,
state varchar (255) NOT NULL,
zip varchar (255) NOT NULL,


PRIMARY KEY (id),
foreign key (id) references phone (id)
);