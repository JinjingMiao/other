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