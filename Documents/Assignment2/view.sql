CREATE VIEW deleveloper_roles_and_privileges AS
SELECT e.id, e.firstName,e.lastName,e.username,e.email, w.name, w.visits, w.updated,  p.title, p.views, p.updated

FROM  person e, website w, page p

Where e.id= w.name


And  w.updated = p.updated
