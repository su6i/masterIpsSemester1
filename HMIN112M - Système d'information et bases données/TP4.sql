--------------------------------- Les notes -------------------------------
-- rlwrap sqlplus e20190009681/yourPassword@oracle.etu.umontpellier.fr:1523/pmaster
-- @tp1.sql
-- select * from cat; or select * from user_tables;
-- select constraint_name from user_constraints;
-- select table_name from user_tables;
-- purge recyclebin;
-- set linesize 200;
-- col table_name for A30;
-- cl scr; clear screen;
-- How to find repeated name?
-- select nom,count (*) from emp group by nom;

--------------------------------- La fin des notes -------------------------------primary key (nomf)
desc cols;

select table_name, column_name from cols where table_name='EMP';

select count(*) from cols where table_name='EMP';

select table_name, column_name from cols;
select constraint_name, table_name from user_constraints where table_name='EMP';

desc USER_TAB_PRIVS;



-- 1. Donner toutes les informations sur les tables sur lesquelles vous avez des droits
SELECT * from ALL_TABLES;

-- 2. Donner le nombre d’attributs de la table EMP
select count(*) from cols where table_name='EMP';

-- 3. Donner la liste des contraintes (avec leur statut) créées au cours du TP précédent
select constraint_name, status from USER_CONSTRAINTS; 


-- 4. Donner les informations sur les contraintes de type clé primaire que vous aviez créées au cours de ce TP
select constraint_name, constraint_type from USER_CONSTRAINTS where CONSTRAINT_TYPE='P';

-- 5. Utilisez à bon escient la table USER TAB COLUMNS de manière à avoir un maximum d’infor-
-- mations sur une table donnée (partageant des similarités avec la commande desc de SQL*Plus).
select TABLE_NAME,COLUMN_NAME from USER_TAB_COLUMNS;

----------------------------------------- TP4 -------------------------------------




----------------------------------------- 2.2 Vérification-------------------------------------
