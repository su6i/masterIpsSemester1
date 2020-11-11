-- rlwrap sqlplus e20190009681/yourPassword@oracle.etu.umontpellier.fr:1523/pmaster
-- @tp1.sql
-- select * from cat; or select * from users;
-- select constraint_name from user_constraints;
-- select table_name from user_tables;
-- purge recyclebin;
-- set linesize 200;
-- col table_name for A30;
-- ALTER TABLE "table_name" DROP [CONSTRAINT|INDEX] "CONSTRAINT_NAME";

drop table fournisseur 
  cascade constraints
;

drop table PRODUIT 
  cascade constraints
;

drop table COMMANDE 
  cascade constraints
;

drop table CLIENT 
  cascade constraints
;

create table fournisseur (
	nomf varchar(20),
	adrsf varchar(50)
);

create table PRODUIT(
	nomp varchar(20), 
	nomf varchar(20),
	cout int,
	constraint pk_produit primary key (nomp, nomf)
);

create table COMMANDE(
	ncom int,
	nomc varchar(50),
	nomp varchar(20),
	nomf varchar(20),
	qte int,
	constraint qte_produit primary key (ncom)
); 

create table CLIENT(
	nomc varchar(50),
	adrsc varchar(50),
	solde int,
	constraint nom_client primary key (nomc)
); 

-- 1. Les coûts des produits proposés dans le schéma PRODUIT sont > 0.
alter table produit 
	add constraint cout_produit 
	check (cout>0)
;

alter table fournisseur 
	add constraint nom_fournisseur 
	primary key (nomf)
; -- Why I can't remove it?
-- alter table produit drop constraint fournisseur_fk;
-- alter table fournisseur drop constraint nom_fournisseur;
-- I have to add something here!!!!!

-- 2. Les noms de fournisseurs dans le schéma PRODUIT sont des noms de fournisseurs référencés dans le schéma FOURNISSEUR.
alter table produit 
	add constraint fournisseur_fk 
	foreign key (nomf) 
	references fournisseur (nomf)
;

-- 3. Les clients qui passent des commandes sont des clients à part entière.
alter table commande 
	add constraint nom_client_qui_pass_commande 
	foreign key (nomc) 
	references client (nomc)
;

-- 4. Les commandes concernent des produits (nomp, nomf) connus dans le schéma PRODUIT
alter table commande 
	add constraint commande_concernent_produits 
	foreign key (nomp,nomf) 
	references PRODUIT (nomp, nomf)
;

-- 5. Les quantités commandées sont > 0.
alter table COMMANDE 
	add constraint quantites_commandees 
	check (qte>0)
;

@ClientFournisseurTuples19.sql

select * from FOURNISSEUR;
select * from CLIENT;
select * from COMMANDE;
select * from PRODUIT;

-- Nom et adresse des clients dont le nom commence par un ”J” (attention à la casse de la police de caractères) ;
select * from CLIENT where solde < 0;

-- Nom des fournisseurs qui proposent le produit ”brique” ou le produit ”parpaing” ;
select nomf 
	from PRODUIT 
	where (nomp = 'brique' OR nomp = 'parpaing')
;

-- Nom et adresse des clients dont le nom commence par un ”J” (attention à la casse de la police de caractères) ;
select nomc,adrsc 
	from CLIENT 
	where nomc LIKE 'j%'
;

-- Nom et adresse des clients ayant commandé du produit ”brique”, la quantité commandée étant comprise entre 5 et 10 ;
select nomc,adrsc 
	from client 
	where nomc 
	in (
	     select nomc 
	     from commande 
	     where nomp ='brique' AND qte >= 5 AND qte <= 10
	)
;

select nomc,adrsc 
	from client 
	where nomc in (
			select nomc 
			from commande 
			where nomp ='brique' AND qte between 5 AND 10
		   )
; -- 5 et 10 ne sont pas inclus;

-- Nom et coût moyen des articles proposés par les fournisseurs ;
select nomp,AVG(cout) 
  from PRODUIT 
  group by nomp
;

-- 4.2 Requêtes de définition et de mises à jour

-- Insérer les tuples correspondant aux commandes suivantes :
-- 6,paul,ciment,Samaco,12
insert into COMMANDE 
  values (6,'paul','ciment','Samaco',12)
;

-- 7,pierre,parpaing,Abounayan,8
insert into COMMANDE values (7,'pierre','parpaing','Abounayan',8);

-- Modifier l’adresse du client Jean qui devient 83000 Toulon ;
UPDATE CLIENT
  SET adrsc='83000 Toulon'
  WHERE nomc = 'jean'
;


-- Les produits du fournisseur Samaco ont augmenté de 15%, réaliser la mise à jour ;
UPDATE PRODUIT
  SET cout=1.15*cout
  WHERE nomf = 'Samaco'
;

-- Le fournisseur Samaco est racheté par la firme Technal d’adresse 69005 Lyon (changement de nom et d’adresse) ;
UPDATE FOURNISSEUR 
  SET nomf='Firme Technal' 
  WHERE nomf = 'Samaco'
;

UPDATE FOURNISSEUR 
  SET adrsf='69005 Lyon' 
  WHERE nomf = 'Samaco'
;

-- 4.2.2 Rétro-conception
-- À partir du schéma relationnel de la base de données, vous donnerez le diagramme de classes UML correspondant. 
-- Vous proposerez également un diagramme d’objets conforme au diagramme de classes, en prenant pour exemple les tuples de la base de données.

-- 4.2.3 Requêtes
-- Vous écrirez et testerez les requêtes suivantes en SQL. Vous pouvez aussi écrire les requêtes 1 et 5 en algèbre relationnelle
-- 1. Nom des fournisseurs qui proposent le produit ”brique” mais pas le produit ”parpaing” ;
-- 2. Nom et coût moyen des produits proposés par au moins deux fournisseurs ;
-- 3. Nom des produits et de leurs fournisseurs qui sont proposés par ces mêmes fournisseurs à des coûts supérieurs à leurs coûts moyens.
-- 4. Nom des produits dont le prix est > au coût moyen de tous les produits ;
-- 5. Nom des fournisseurs qui proposent tous les produits commandés par Jean (à l’instant de l’exécution de la requête) ;





























