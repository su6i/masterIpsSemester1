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
--------------------------------- La fin des notes -------------------------------




----------------------------------------- TP2 -------------------------------------

-- Créer la base
-- @Tp2MastereCreation_v2.sql;

-- vérifier le contenu des tables créées.
select * from cat;
select * from DEPT;
select * from EMP;

--2. Requêtes
-- 1. Donner les nom, fonction et date d’embauche de tous les employés,
select nom,fonction,embauche 
  from EMP
;

-- 2. Donner les numéros, nom et salaire des employés dont le salaire est <= 2000 euros,
select num,nom,salaire 
  from EMP 
  where salaire <= 2000
;

-- 3. Donner la liste des employés ayant une commission, classée par commission décroissante,
select * 
  from EMP 
  where comm >= 0 
  order by comm desc
; -- exprès, j'ai inclus la commission 0 dedans.

-- 4. Donner le nom des personnes embauchées depuis janvier 1991,
select nom,embauche 
  from EMP 
  where embauche >= '01-01-1991'
; -- J'ai ajouté embauche pour plus de lisibilité

-- 5. Donner pour chaque employé son nom et son lieu de travail,
select EMP.nom, DEPT.lieu 
  from EMP, DEPT 
  where EMP.n_dept = DEPT.n_dept
;

-- 6. Donner pour chaque employé le nom de son supérieur hiérarchique,
select EMP.nom as employee, MGR.nom as manager 
  from EMP, EMP MGR 
  where EMP.n_sup = MGR.num
;-- J'ai copié la table EMP comme MGR et ...

-- 7. Quels sont les employés ayant la même fonction que ”CODD” ?
select * 
  from EMP 
  where fonction 
	in (
    select fonction 
    from EMP 
    where nom = 'CODD'
	)
;

-- 8. Quels sont les employés gagnant plus que tous les employés du département 30 ?
select nom, salaire 
  from EMP 
  where salaire >  ALL (
		select salaire 
		from EMP 
		where n_dept = 30
	)
;-- avec >, il ya personne, mais avec >= il y a une

-- 9. Quels sont les employés ne travaillant pas dans le même département que leur supérieur hiérarchique ?
select  nom  
  from  EMP  MGR  
  where  n_dept  !=  (
		select  n_dept  
		from  EMP 
		where MGR.n_sup = num
	) 
	AND n_sup 
	IS NOT NULL
;
-- Deuxième solution
select EMP.nom 
  from EMP, EMP MGR 
  where EMP.n_sup = MGR.num 
  AND EMP.n_dept != MGR.n_dept
;

-- 10. Quels sont les employés travaillant dans un département qui a procédé à des embauches depuis le début de l’année 98,
select * from EMP TEMP where exists (select * from EMP where embauche >= '01-01-98' AND n_dept = TEMP.n_dept);

-- 11. Donner le nom, la fonction et le salaire de l’employé (ou des employés) ayant le salaire le plus élevé.
select nom,fonction,salaire 
  from EMP 
  where salaire = (
 		select max(salaire) 
      from EMP
  )
;

-- 12. Donner le total des salaires, le nombre de salariés, ainsi que le salaire minimal, moyen et maximal pour l’ensemble des salariés de chaque département,
select n_dept,sum(salaire),count (nom),min(salaire),avg(salaire),max(salaire) 
  from EMP 
  group by n_dept
;

-- 13. Donner le ou les départements ayant le plus d’employés,
select nom from dept where n_dept= (
  select n_dept from emp group by n_dept having count(*)= (
    select max(count(*)) from emp group by n_dept
  )
);

-- deuxième solution avec la table EMP pour avoir le nombre d'emplyés
select n_dept , count(*) from EMP group by n_dept having count(*) = (select max(count(*)) from EMP group by n_dept);

-- 14. Donner les départements qui ne possèdent pas d’employés exerçant la fonction d’ingénieur,
select nom,n_dept from DEPT where n_dept not in (select n_dept from EMP where fonction ='ingenieur');

-- 15. Donner les départements possédant des employés exerçant l’ensemble des fonctions référencées au sein de la société.
select n_dept, count (distinct fonction) from emp group by n_dept having count(distinct fonction)= ( select max(count(distinct fonction)) from emp group by n_dept);

----------------------------------------- La fin de TP2 -------------------------------------