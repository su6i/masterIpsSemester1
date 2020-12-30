create table project_generated.commune select * from commune;       -- create table in another database
create table backup_commune select * from commune;                  -- create a table with the data of another table
insert into backup_commune select * from commune;                   -- insert data to a table from the result of another table
delete from backup_commune;                                         -- delete all tuples of a table
ALTER TABLE commune MODIFY longitude decimal(13,11);                -- change data type of a column
delete from commune where latitude is null;                         -- delete with condition
select * from commune limit 10;                                     -- limit the number of result tuples
update table commune set latitude = longitude where new !='NULL';   -- set a value
alter table commune drop column libelle;                            -- drop a column
source new.sql                                                      -- import sql file
select database() from dual;                                        -- display selected database
insert into lieu(codeInsee, nomCom, longitude, latitude) 
select codeinsee, nom_com, longitude, latitude from commune;        -- insert selected columns into another table
insert ignore into lieu(codeInsee, nomCom, longitude, latitude) 
select codeinsee, nom_com, longitude, latitude from commune;        -- insert data but ignore if already exists that data
mysqldump -uUsername -pPassword project_generated >  project_generated.sql -- dump (export) an entire database to a file
update lieu set dep = SUBSTR(code_insee, 1, 2);                     -- set a part of a value in a column from another column
update lieu_backup set dep = SUBSTR(code_insee, 1, 3) where code_insee like '97%'; -- set a part of a value in a column from another column with a condition
update departement g set chef_lieu = (select chefLieu from project_initial.departement i where g.num_dep = i.chefLieu);
insert ignore into monument(code_m, latitude, longitude, nom_m, proprietaire, type_monument, code_lieu) select codeM, longitude, latitude, nomM, proprietaire, typeMonument, codeLieu from project_initial.monument; 

create table backup_programmation_java.departement select * from departement;
create table backup_programmation_java.monument select * from monument;
create table backup_programmation_java.lieu select * from lieu;
create table backup_programmation_java.celebrite select * from celebrite;
create table backup_programmation_java.monument_celebrite select * from monument_celebrite;
create table backup_programmation_java.data select * from data;

SELECT COUNT(*) FROM ( SELECT DISTINCT prenom, nom FROM celebrite);