

-- SET FOREIGN_KEY_CHECKS=0;
-- DROP TABLE IF EXISTS person;
-- SET FOREIGN_KEY_CHECKS=1;
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
  
  
  
  insert into person values (12,'Alice','wonder','Developer','alice','alice','alice@wonder.com','4321rewq');
  insert into person values (23,'Bob','Marley','Developer','bob','bob','bob@marley.com','5432trew');
  insert into person values (34,'Charlie','Garcia','Developer','charlie','charlie','chunch@garcia.com','6543ytre');
  insert into person values (45,'Dan','Mertin','User','dan','dan','dan@martin.com','N/A');
  insert into person values (56,'ED','Karaz','User','ed','ed','ed@kar.com','N/A');
  

 
  


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


insert into  phone value (123,123-234-3456234-345-4566,'alice');
insert into  phone value(234,345-456-5677,'bob');
insert into  phone value (345,321-432-5435432-432-5433543-543-6544,'charile');

insert into address value (123 , '123 Adam St Alton, 01234','234 Birch St.','Boston','01112');
insert into address value (234 , '345 Charles St., Chelms, 03455','456 Down St','Dalton','04566');
insert into address value (345 , '543 East St., Everett, 01112','654 Frank St.','Foulton','04322');


DELIMITER $$

CREATE TRIGGER after_page_priviledge_update
    After UPDATE ON page_priviledge
   

    FOR EACH ROW 
  
BEGIN
 delete from page_priviledge where developer=old_Developer_person_generalization;
	
	if  new_role = ('owner') 
    then
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('create',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ( 'read',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ( 'update',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('delete',New_Developer_person_generalization,new_page);
    end if;
	
    if  new_role = ('admin ')
    then
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('create',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('read',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('update',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('delete',New_Developer_person_generalization,new_page);
    end if;
    
	if new_role=( 'writer')
	then
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('create',new_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('read',new_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('update',new_Developer_person_generalization,new_page);
    
    end if;
    
	if new_role= ('editor ')
	then
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('read',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('update',New_Developer_person_generalization,new_page);
   
    end if;
    
	if new_role=( 'reviewer')
	then 
   
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('read',New_Developer_person_generalization,new_page);
  
    end if;
    
END; $$




DELIMITER $$
CREATE TRIGGER after_page_priviledge_insert
    After INSERT ON page_priviledge
    FOR EACH ROW 
  
BEGIN
	
	if  new_role = ('owner') 
    then
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('create',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ( 'read',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ( 'update',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('delete',New_Developer_person_generalization,new_page);
    end if;
	
    if  new_role = ('admin ')
    then
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('create',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('read',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('update',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('delete',New_Developer_person_generalization,new_page);
    end if;
    
	if new_role=( 'writer')
	then
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('create',new_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('read',new_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('update',new_Developer_person_generalization,new_page);
    
    end if;
    
	if new_role= ('editor ')
	then
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('read',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('update',New_Developer_person_generalization,new_page);
   
    end if;
    
	if new_role=( 'reviewer')
	then 
   
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('read',New_Developer_person_generalization,new_page);
  
    end if;
    
END; $$


DELIMITER $$
CREATE TRIGGER after_page_priviledge_delete
    After DELETE ON page_priviledge
    FOR EACH ROW 
  
BEGIN
	
	if  new_role = ('owner') 
    then
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('create',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ( 'read',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ( 'update',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('delete',New_Developer_person_generalization,new_page);
    end if;
	
    if  new_role = ('admin ')
    then
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('create',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('read',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('update',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('delete',New_Developer_person_generalization,new_page);
    end if;
    
	if new_role=( 'writer')
	then
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('create',new_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('read',new_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,page) values ('update',new_Developer_person_generalization,new_page);
    
    end if;
    
	if new_role= ('editor ')
	then
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('read',New_Developer_person_generalization,new_page);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('update',New_Developer_person_generalization,new_page);
   
    end if;
    
	if new_role=( 'reviewer')
	then 
   
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,page) values ('read',New_Developer_person_generalization,new_page);
  
    end if;
    
END; $$




 DELIMITER $$

CREATE TRIGGER after_website_priviledge_update
    After UPDATE ON website_priviledge
   

    FOR EACH ROW 
  
BEGIN
 
	 delete from website_priviledge where Developer_person_generalization=old_Developer_person_generalization;
	if  new_role = ('owner') 
    then
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('create',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ( 'read',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ( 'update',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('delete',New_Developer_person_generalization,new_website);
    end if;
	
    if  new_role = ('admin ')
    then
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('create',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('read',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('update',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('delete',New_Developer_person_generalization,new_website);
    end if;
    
	if new_role=( 'writer')
	then
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('create',new_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('read',new_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('update',new_Developer_person_generalization,new_website);
    
    end if;
    
	if new_role= ('editor ')
	then
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('read',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('update',New_Developer_person_generalization,new_website);
   
    end if;
    
	if new_role=( 'reviewer')
	then 
   
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('read',New_Developer_person_generalization,new_website);
  
    end if;
    
END; $$

 

DELIMITER $$
CREATE TRIGGER after_website_priviledge_insert
    After INSERT ON website_priviledge
   

    FOR EACH ROW 
  
BEGIN
 
	
	if  new_role = ('owner') 
    then
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('create',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ( 'read',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ( 'update',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('delete',New_Developer_person_generalization,new_website);
    end if;
	
    if  new_role = ('admin ')
    then
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('create',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('read',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('update',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('delete',New_Developer_person_generalization,new_website);
    end if;
    
	if new_role=( 'writer')
	then
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('create',new_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('read',new_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('update',new_Developer_person_generalization,new_website);
    
    end if;
    
	if new_role= ('editor ')
	then
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('read',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('update',New_Developer_person_generalization,new_website);
   
    end if;
    
	if new_role=( 'reviewer')
	then 
   
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('read',New_Developer_person_generalization,new_website);
  
    end if;
    
END; $$

DELIMITER $$
CREATE TRIGGER after_website_priviledge_delete
    After DELETE ON website_priviledge
   

    FOR EACH ROW 
  
BEGIN
 
	
	if  new_role = ('owner') 
    then
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('create',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ( 'read',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ( 'update',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('delete',New_Developer_person_generalization,new_website);
    end if;
	
    if  new_role = ('admin ')
    then
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('create',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('read',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('update',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('delete',New_Developer_person_generalization,new_website);
    end if;
    
	if new_role=( 'writer')
	then
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('create',new_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('read',new_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge(priviledge,Developer_person_generalization,website) values ('update',new_Developer_person_generalization,new_website);
    
    end if;
    
	if new_role= ('editor ')
	then
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('read',New_Developer_person_generalization,new_website);
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('update',New_Developer_person_generalization,new_website);
   
    end if;
    
	if new_role=( 'reviewer')
	then 
   
    INSERT INTO page_priviledge (priviledge,Developer_person_generalization,website) values ('read',New_Developer_person_generalization,new_website);
  
    end if;
    
END; $$



insert into website value (123,'Facebook','an online social media and social networking service','2019-10-09','2019-10-09',1234234);
insert into website value (234,'Twitter','an online news and social networking service','2019-10-09','2019-10-09',4321543);
insert into website value (345,'Wikipedia','a free online encyclopedia','2019-10-09','2019-10-09',3456654);
insert into website value (456,'CNN','an American basic cable and satellite television news channel','2019-10-09','2019-10-09',6543345);
insert into website value (567,'Wikipedia','an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics','2019-10-09','2019-10-09',5433455);
insert into website value (678,'Gizmodo','a design, technology, science and science fiction website that also writes articles on politics','2019-10-09','2019-10-09',4322345);

insert into page value (123,'Home','Landing page','2019-10-09','2019-10-09','CNET','123434');
insert into page value (234,'About','Website description','2019-10-09','2019-10-09','Gizmodo','234545');
insert into page value (345,'Contact','Addresses, phones, and contact info','2019-10-09','2019-10-09','Wikipedia','345656');
insert into page value (456,'Preferebces','Where users can configure their preferences','2019-10-09','2019-10-09','CNN','456776');
insert into page value (567,'Profile','Users can configure their personal information','2019-10-09','2019-10-09','CNET','567878');


INSERT INTO `cs5200`.`widget` (`dtype`, `id`, `name`, `width`, `height`, `cssClass`, `cssStyle`, `text`, `order`, `src`, `url`, `page`, `shareable`, `expandable`, `size`, `html`) VALUES ('heading', '123', 'head123', '0', '0', 'null', 'null', 'Welcome', '0', 'null', 'null', 'Home', 'null', 'null', 'No', 'null');
INSERT INTO `cs5200`.`widget` (`dtype`, `id`, `name`, `width`, `height`, `cssClass`, `cssStyle`, `text`, `order`, `src`, `url`, `page`, `shareable`, `expandable`, `size`, `html`) VALUES ('html', '234', 'post234', '0', '0', 'null', 'null', '<p>Lorem</p>', '0', 'null', 'null', 'About', 'null', 'null', 'No', 'null');
INSERT INTO `cs5200`.`widget` (`dtype`, `id`, `name`, `width`, `height`, `cssClass`, `cssStyle`, `text`, `order`, `src`, `url`, `page`, `shareable`, `expandable`, `size`, `html`) VALUES ('heading', '345', 'head345', '0', '0', 'null', 'null', 'Hi', '1', 'null', 'null', 'Contact', 'null', 'null', '0', 'null');
INSERT INTO `cs5200`.`widget` (`dtype`, `id`, `name`, `width`, `height`, `cssClass`, `cssStyle`, `text`, `order`, `src`, `url`, `page`, `shareable`, `expandable`, `size`, `html`) VALUES ('html', '456', 'intro456', '0', '0', 'null', 'null', '<h1>Hi</h1>', '2', 'null', 'null', 'Contact', 'null', 'null', '0', 'null');
INSERT INTO `cs5200`.`widget` (`dtype`, `id`, `name`, `width`, `height`, `cssClass`, `cssStyle`, `text`, `order`, `src`, `url`, `page`, `shareable`, `expandable`, `size`, `html`) VALUES ('image', '567', 'image345', '50', '100', 'null', 'null', 'null', '3', 'null', '/img/567.png', 'Contact', 'null', 'null', '0', 'null');
INSERT INTO `cs5200`.`widget` (`dtype`, `id`, `name`, `width`, `height`, `cssClass`, `cssStyle`, `text`, `order`, `src`, `url`, `page`, `shareable`, `expandable`, `size`, `html`) VALUES ('youtube', '678', 'video456', '400', '300', 'null', 'null', 'null', '0', 'null', 'https://youtu.be/h67VX51QXiQ', 'Preferences', 'null', 'null', '0', 'null');


select * from person where type in ('Developer');
select * from person where type in ('Developer') and id in (34);



select * from website where id in (678) ;


select * from website_priviledge;

   
   update phone 
   set phone = '3334445555'
   where username = 'charlie'
   
   
   
   
   
    
 



