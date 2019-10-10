insert into person values (12,'Alice','wonder','Developer','alice','alice','alice@wonder.com','4321rewq');
  insert into person values (23,'Bob','Marley','Developer','bob','bob','bob@marley.com','5432trew');
  insert into person values (34,'Charlie','Garcia','Developer','charlie','charlie','chunch@garcia.com','6543ytre');
  insert into person values (45,'Dan','Mertin','User','dan','dan','dan@martin.com','N/A');
  insert into person values (56,'ED','Karaz','User','ed','ed','ed@kar.com','N/A');
  	
insert into  phone value (123,123-234-3456234-345-4566,'alice');
insert into  phone value(234,345-456-5677,'bob');
insert into  phone value (345,321-432-5435432-432-5433543-543-6544,'charile');

insert into address value (123 , '123 Adam St Alton, 01234','234 Birch St.','Boston','01112');
insert into address value (234 , '345 Charles St., Chelms, 03455','456 Down St','Dalton','04566');
insert into address value (345 , '543 East St., Everett, 01112','654 Frank St.','Foulton','04322');

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