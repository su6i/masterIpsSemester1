--------------------------------- Les notes -------------------------------
-- rlwrap sqlplus e20190009681/yourPassword@oracle.etu.umontpellier.fr:1523/pmaster
-- @tp1.sql
-- select * from cat; or select * from users;
-- select constraint_name from user_constraints;
-- select table_name from user_tables;
-- purge recyclebin;
-- set linesize 200;
-- col table_name for A30;
-- cl scr; clear screen;
-- How to find repeated name?
-- select nom,count (*) from EMP group by nom;
--------------------------------- La fin des notes -------------------------------primary key (nomf)




----------------------------------------- TP3 -------------------------------------
-- ALTER TABLE | Sur la table DEPT rajouter la contrainte dept_pk définissant n dept comme clé primaire.
alter table DEPT add constraint dept_pk primary key (n_dept);

-- ALTER TABLE |
-- Sur la table EMP rajouter les contraintes suivantes :
-- 1. EMP_pk définissant num comme clé primaire,
alter table EMP add constraint EMP_pk primary key (num);

-- 2. nom_u définissant nom comme nom unique,
select nom,count (*) from EMP group by nom;

UPDATE EMP SET nom='Amir' WHERE num = '16712';
alter table EMP add constraint nom_u unique (nom);

-- 3. responsable définissant n_sup comme Foreign key référençant num (CI intra table)
alter table EMP add constraint responsable foreign key (n_sup) references EMP (num);

-- 4. dept définissant n dept comme Foreign key référençant n dept de la table DEPT (CI inter table)
INSERT INTO DEPT VALUES (100,'myDepartment','Ahvaz');
alter table EMP add constraint dept foreign key (n_dept) references DEPT (n_dept);


-- 5. commission définissant un controle tel que seuls les EMPloyés dont la fonction est commercial
-- aient une commission comm non nulle (null).
select * from EMP where fonction='commercial';
UPDATE EMP SET comm='0' WHERE nom = 'BARAQ';
alter table EMP add constraint commission 
  check ((fonction='commercial' AND comm is not null) or (fonction !='commercial' AND comm IS NULL));

----------------------------------------- 2.2 Vérification-------------------------------------
 
-- Vérifier que les contraintes ont été créées en consultant la vue du dictionnaire de données nommée user constraints.
select CONSTRAINT_NAME,SEARCH_CONDITION from user_constraints;

-- Lorsque certaines contraintes sont introduites dans la conception du schéma sans les nommer, le
select constraint_name, STATUS from user_constraints;
----------------------------------------- 2.3 Désactiver/Activer des Contraintes-------------------------------------
-- 1. désactiver la contrainte commission ;
select TABLE_NAME, STATUS from user_constraints where CONSTRAINT_NAME='COMMISSION';
alter table EMP disable constraint commission;

-- 2. insérer des n-uplets dans EMP transgressant la contrainte commission ;
insert into EMP values('Fahima',55555,'commercial',24833,'10/09/2008',6000,NULL,10);


-- 3. essayer de rétablir la contrainte. Conclusion ? ;
-- impossible: erreur: ORA-02293: impossible de valider (E20190009681.COMMISSION) - violation d'une contrainte de controle

-- 4. détecter les n-uplets qui provoquent l’erreur afin de pouvoir les supprimer 
-- et rétablir la contrainte.
select * from emp where rowid='AAAdfLAAMAAAGIzAAA';
delete from EMP where rowid='AAAdfLAAMAAAGIzAAA';
alter table EMP enable constraint commission;

----------------------------------------- 2.4 Exploiter les vues du dictionnaire de données-------------------------------------
-- Donner le nom et le type de chacune des contraintes posées sur la table EMP 
-- (vue user constraints). Vous vérifierez également que ces contraintes 
-- sont actives et valides.
select table_name,CONSTRAINT_NAME,CONSTRAINT_TYPE,STATUS from user_constraints 
  where table_name='EMP';

-- — Donner le nom des contraintes et le nom des attributs auquelles elles 
-- s’appliquent (vue user_cons_columns)
select CONSTRAINT_NAME, COLUMN_NAME from user_cons_columns;

-- — Donner le nom de vos tables, ainsi que le nombre de tuples insérés dans 
-- ces tables (vue user_tables)
select TABLE_NAME,NUM_ROWS from user_tables;

-- — Donner le nom des tables auquelles vous avez accès, ainsi que le nom de leurs 
-- propriétaires (vue all_tables)
desc all_tables;
select TABLE_NAME,OWNER from all_tables where owner='E20190009681';

-- — Donner le nom de toutes les tables (et de leurs propriétaires) de l’ensemble 
-- des schémas utilisateurs de la base de données master (vue dba_tables)




----------------------------------------- 2.5 Suppression des contraintes-------------------------------------
-- Supprimer les contraintes de la table EMP.
