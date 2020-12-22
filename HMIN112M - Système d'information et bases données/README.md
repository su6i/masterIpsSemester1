# HMIN112M - Système d'information et bases données

## Some useful MySQL queries

`create table project_generated.commune select * from commune;` -- create table in another database
`create table backup_commune select * from commune;` -- create a table with the data of another table
`insert into backup_commune select * from commune;` -- insert data to a table from the result of another table
`delete from backup_commune;` -- delete all tuples of a table
`ALTER TABLE commune MODIFY longitude decimal(13,11);` -- change data type of a column
`delete from commune where latitude is null;` -- delete with condition
`select * from commune limit 10;` -- limit the number of result tuples
`update table commune set latitude = longitude where new !='NULL';` -- set a value
`alter table commune drop column libelle;` -- drop a column
`source new.sql` -- import sql file
`select database() from dual;` -- display selected database
`select database();` -- display selected database
`insert into lieu(codeInsee, nomCom, longitude, latitude) select codeinsee, nom_com, longitude, latitude from commune;` -- insert selected columns into another table
`insert ignore into lieu(codeInsee, nomCom, longitude, latitude) select codeinsee, nom_com, longitude, latitude from commune;` -- insert data but ignore if already exists that data
