# Active = 1 / Inactive = 2
INSERT INTO status_users(code) VALUES (1),(2);
INSERT INTO privileges(name) VALUES ("ROL_TEACHER"),("ROL_STUDENT");
INSERT INTO status_sheets(code) VALUES ("ACTIVE"),("FINISHED");
INSERT INTO status_sheet_students(code) VALUES ("IN_TIME"),("LATE"),("JUSTIFIED");

INSERT INTO users (email, identifier_number, last_name, name, password, user_status_id) VALUES ("admin@gmail.com",1,"NOM","Enseigant","$2y$12$uxX33Gc3zdvN5eEUhTksju1PsDU9pegKXKv3N6wQxiC3ES1nrz3NO",1);
INSERT INTO user_privileges (user_id, privilege_id) VALUES (1,1),(1,2);
INSERT INTO teachers(user_id) VALUES (1);

INSERT INTO users (email, identifier_number, last_name, name, password, user_status_id) VALUES ("student@gmail.com","7070","RAMOS","Ruben","$2y$12$uxX33Gc3zdvN5eEUhTksju1PsDU9pegKXKv3N6wQxiC3ES1nrz3NO",1);
INSERT INTO user_privileges (user_id, privilege_id) VALUES (1,2);
INSERT INTO students(user_id) VALUES (2);

INSERT INTO users (email, identifier_number, last_name, name, password, user_status_id) VALUES ("student2@gmail.com","70707","SANTOS","Edson","$2y$12$uxX33Gc3zdvN5eEUhTksju1PsDU9pegKXKv3N6wQxiC3ES1nrz3NO",1);
INSERT INTO user_privileges (user_id, privilege_id) VALUES (1,2);
INSERT INTO students(user_id) VALUES (3);

INSERT INTO users (email, identifier_number, last_name, name, password, user_status_id) VALUES ("student3@gmail.com","123","ATTAQUE","Louis","$2y$12$uxX33Gc3zdvN5eEUhTksju1PsDU9pegKXKv3N6wQxiC3ES1nrz3NO",1);
INSERT INTO user_privileges (user_id, privilege_id) VALUES (1,2);
INSERT INTO students(user_id) VALUES (4);


# FORMATIONS
INSERT INTO formations(acronyme,code_specialite,type_parcours,titre_officiel,formation_code,version,titre,id) VALUES ("DUT INFO","",100,"DUT Informatique","FCOD1",5,"DUT Informatique (PPN 2013)","FORM14923");
INSERT INTO formations(acronyme,code_specialite,type_parcours,titre_officiel,formation_code,version,titre,id) VALUES ("LP MobiNum","",200,"LP Métiers de l'informatique : applications web","FCOD14",1,"LP Mobilité numérique","FORM10035");

# SEMESTRES
INSERT INTO semestres(semestre,formation_id) VALUES (1,"FORM14923"),(2,"FORM14923"),(3,"FORM14923"),(4,"FORM14923"),(5,"FORM14923"),(6,"FORM14923"),(1,"FORM10035"),(2,"FORM10035"),(3,"FORM10035"),(4,"FORM10035"),(5,"FORM10035"),(6,"FORM10035");

INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type,formation_id) VALUES ("UE11",0,"",17.0,"UCOD11",1,"Bases de l'informatique",0,"FORM14923"),("UE12",0,"",13.0,"UCOD12",2,"Bases de culture scientifique, sociale et humaine",0,"FORM14923"),("Bonus Sport/Langue 1",0,"",0.0,"UCOD13",3,"Bonus",1,"FORM14923"),("UE21", 0, "", 16.0, "UCOD21", 4, "Approfondissements en informatique", 0, "FORM14923"),("UE22",0,"",14.0, "UCOD22",5,"Approfondissements en culture scientifique, sociale et humaine",0,"FORM14923"),("Bonus Sport 2",0,"", 0.0, "UCOD23",6,"Bonus",1,"FORM14923"),("UE31",0,"",12.0, "UCOD31",7,"Informatique avancée",0,"FORM14923"),("UE32",0,"",12.0,"UCOD32",8,"Culture scientifique, sociale et humaine",0,"FORM14923"),("UE33",0,"",6.0,"UCOD33",9,"Méthodologie et Projets",0,"FORM14923"),("Bonus Sport 3",0,"",0.0,"UCOD34",10,"Bonus",1,"FORM14923"),("UE41",0,"",10.0,"UCOD4113",11,"Compléments d'informatique",0,"FORM14923"),("UE42",0,"",8.0,"UCOD4213",12,"Compléments de culture scientifique, sociale et humaine",0,"FORM14923"),("UE43",0,"",12.0, "UCOD4313",13,"Mise en situation professionnelle",0,"FORM14923"),("Bonus Sport 4",0,"", 0.0,"UCOD44",14,"Bonus",1,"FORM14923");
INSERT INTO matiers(titre, numero, unite_enseignement_id) VALUES ("Bases de l'informatique",1,1),("Bases de culture scientifique, sociale et humaine",1,2),("Bonus",1,3),("Approfondissements en informatique",1,4),("Approfondissements en culture scientifique, sociale et humaine",1,5),("Bonus",1,6),("Informatique avancée",1,7),("Culture scientifique, sociale et humaine",1,8),("Méthodologie et Projets",1,9),("Bonus",1,10),("Compléments d'informatique",1,11),("Compléments de culture scientifique, sociale et humaine",1,12),("Mise en situation professionnelle",1,13),("Bonus",1,14);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3.5,"M1101",1,"","",30.0,"Introduction aux systèmes informatiques",10,10.0,0,"Introduction aux systèmes informatiques",20.0,1),( 3.5,"M1102",1,"","",30.0,"Introduction à l'algorithmique et à la programmation",20,10.0,0,"Introduction à l'algorithmique et à la programmation",20.0,1),(2.5,"M1103",1,"","",20.0,"Structures de données et algorithmes fondamentaux",30,10.0,0,"Structures de données et algorithmes fondamentaux",15.0,1),(3.5,"M1104",1,"","",25.0,"Introduction aux bases de données",40,10.0,0,"Introduction aux bases de données",25.0,1),(2.5, "M1105", 1, "", "", 25.0,"Conception de documents et d'interfaces num.",50,0.0,0,"Conception de documents et d'interfaces numériques",20.0,1),(1.5, "M1106", 1, "", "", 0.0,"Projet tutoré - Découverte",60,0.0,0,"Projet tutoré - Découverte",0.0,1),(2.5,"M1201",1,"","",17.0,"Mathématiques discrètes",10,10.0,0,"Mathématiques discrètes",18.0,2),(2.0,"M1202",1,"","",12.0,"Algèbre linéaire",20,6.0,0,"Algèbre linéaire",12.0,2),(1.5,"M1203",1,"","",10.0,"Environnement économique",30,10.0,0,"Environnement économique",10.0,2),(2.5,"M1204",1,"","",15.0,"Fonctionnement des organisations",40,10.0,0,"Fonctionnement des organisations",20.0,2),(2.0,"M1205",1,"","",15.0,"Expr.-Com. - Fondamentaux de la com.",50,0.0,0,"Expr.-Com. - Fondamentaux de la com.",15.0,2),(1.5,"M1206",1,"","",15.0,"Anglais et informatique",60,0.0,0,"Anglais et informatique",15.0,2),(1.0,"M1207",1,"","",10.0,"PPP - Connaître le monde professionnel",70,0.0,0,"PPP - Connaître le monde professionnel",10.0,2),(1.0,"M_SP_1",1,"","",0.0,"Sport",10,0.0,0,"Sport",0.0,3),(1.5,"M2101", 2, "","", 12.0,"Archi. et prog. des mécanismes de base",10, 8.0, 0,"Architecture et programmation des mécanismes de base d'un système informatique", 10.0,4),(1.5,"M2102", 2, "","", 12.0,"Architecture des réseaux",20, 8.0, 0,"Architecture des réseaux", 10.0,4),(3.5,"M2103", 2, "","", 30.0,"Bases de la programmation orientée objet",30, 10.0, 0,"Bases de la programmation orientée objet", 20.0,4),(2.5,"M2104", 2, "","", 20.0,"Bases de la conception orientée objet",40, 10.0, 0,"Bases de la conception orientée objet", 15.0,4),(2.5,"M2105", 2, "","", 20.0,"Introduction aux IHM",50, 10.0, 0,"Introduction aux IHM", 15.0,4),(2.5,"M2106", 2, "","", 20.0,"Prog. et administration des bases de données",60, 10.0, 0,"Programmation et administration des bases de données", 15.0,4),(2.0,"M2107", 2, "","", 0.0,"Projet tutoré - Description et planification de projet",70, 0.0, 0,"Projet tutoré - Description et planification de projet", 0.0,4),(2.5,"M2201",2,"","",18.0,"Graphes et langages",10,11.0,0,"Graphes et langages",16.0,5),(2.0,"M2202",2,"","",10.0,"Analyse et méthodes numériques",20,8.0,0,"Analyse et méthodes numériques",12.0,5),(3.0,"M2203",2,"","",15.0,"Environnement compta., financier, juridique et social",30,12.0,0,"Environnement comptable, financier, juridique et social",18.0,5),(1.5,"M2204",2,"","",10.0,"Gestion de projet informatique",40,8.0,0,"Gestion de projet informatique",12.0,5),(1.5,"M2205",2,"","",15.0,"Expr.-Com. - Communication, info. et argumentation",50,0.0,0,"Expr.-Com. - Communication, information et argumentation",15.0,5),(2.5,"M2206",2,"","",22.0,"Communiquer en anglais",60,0.0,0,"Communiquer en anglais",23.0,5),(1.0,"M2207",2,"","",10.0,"PPP - Identifier ses compétences",70,0.0,0,"PPP - Identifier ses compétences",10.0,5),(1.0,"M_SP_2",2,"","",0.0,"Sport",10,0.0,0,"Sport",0.0,6),(2.5,"M3101",3,"","",0.0,"Principes des systèmes d'exploitation",10,0.0,0,"Principes des systèmes d'exploitation",0.0,7),(1.5,"M3102",3,"","",0.0,"Services réseaux",20,0.0,0,"Services réseaux",0.0,7),(1.5,"M3103",3,"","",0.0,"Algorithmique avancée",30,0.0,0,"Algorithmique avancée",0.0,7),(2.5,"M3104",3,"","",0.0,"Programmation Web - côté serveur",40,0.0,0,"Programmation Web - côté serveur",0.0,7), (2.5,"M3105",3,"","",0.0,"Conception et programmation objet avancées",50,0.0,0,"Conception et programmation objet avancées",0.0,7), (1.5,"M3106C",3,"","",0.0,"Bases de données avancées",60,0.0,0,"Bases de données avancées",0.0,7),(2.5,"M3201",3,"","",0.0,"Probabilités et statistiques",10,0.0,0,"Probabilités et statistiques",0.0,8),(1.5,"M3202C",3,"","",0.0,"Modélisations mathématiques",20,0.0,0,"Modélisations mathématiques",0.0,8),(1.5,"M3203",3,"","",0.0,"Droit des TIC",30,0.0,0,"Droit des technologies de l'information et de la communication (TIC)",0.0,8),(2.5,"M3204",3,"","",0.0,"Gestion des systèmes d'information",40,0.0,0,"Gestion des systèmes d'information",0.0,8),(1.5,"M3205",3,"","",0.0,"Expr.-Com. - Communication professionnelle",50,0.0,0,"Expr.-Com. - Communication professionnelle",0.0,8),(2.5,"M3206",3,"","",0.0,"Collaborer en anglais",60,0.0,0,"Collaborer en anglais",0.0,8),(3.0,"M3301",3,"","",0.0,"Méthodologie de la production d'applications",10,0.0,0,"Méthodologie de la production d'applications",0.0,9),(2.0,"M3302",3,"","",0.0,"Projet tutoré - Mise en situation professionnelle",20,0.0,0,"Projet tutoré - Mise en situation professionnelle",0.0,9),(1.0,"M3303",3,"","",0.0,"PPP - Préciser son projet",30,0.0,0,"PPP - Préciser son projet",0.0,9),(1.0,"M_SP_3",3,"","",0.0,"Sport",10,0.0,0,"Sport",0.0,10),(1.5,"M4101C-IPI",4,"","",0.0,"Administration système et réseau",10,0.0,0,"Administration système et réseau",0.0,11),(1.5,"M4101C-OS",4,"","",0.0,"Traitement de l'information",20,0.0,0,"Traitement de l'information",0.0,11),(1.5,"M4102C-IPI",4,"","",0.0,"Développement iOS",30,0.0,0,"Développement iOS",0.0,11),(1.5,"M4102C-OS",4,"","",0.0,"Programmation répartie",40,0.0,0,"Programmation répartie",0.0,11),(1.5,"M4103C-IPI",4,"","",0.0,"Programmation Web - client riche",50,0.0,0,"Programmation Web - client riche",0.0,11),(1.5,"M4103C-OS",4,"","",0.0,"Programmation Web - client riche",60,0.0,0,"Programmation Web - client riche",0.0,11),(1.5,"M4104C-IPI",4,"","",0.0,"Conception et développement d'appli. mobiles",70,0.0,0,"Conception et développement d'appli. mobiles",0.0,11),(1.5,"M4104C-OS",4,"","",0.0,"Conception et développement d'appli. mobiles",80,0.0,0,"Conception et développement d'appli. mobiles",0.0,11),(1.5,"M4105C-IPI",4,"","",0.0,"Compléments d'informatique",90,0.0,0,"Compléments d'informatique",0.0,11),(1.5,"M4105C-OS",4,"","",0.0,"Compléments d'algorithmique",100,0.0,0,"Compléments d'algorithmique",0.0,11),(2.5,"M4106",4,"","",0.0,"Projet tutoré - Compléments",110,0.0,0,"Projet tutoré - Compléments",0.0,11),(2.0,"M4201C-IPI",4,"","",0.0,"Ateliers de création d'entreprise",10,0.0,0,"Ateliers de création d'entreprise",0.0,12),(2.0,"M4201C-OS",4,"","",0.0,"Ateliers de création d'entreprise",20,0.0,0,"Ateliers de création d'entreprise",0.0,12),(2.0,"M4202C-IPI",4,"","",0.0,"Recherche opérationnelle et aide à la décision",30,0.0,0,"Recherche opérationnelle et aide à la décision",0.0,12),(2.0,"M4202C-OS",4,"","",0.0,"Recherche opérationnelle et compléments d'algèbre",40,0.0,0,"Recherche opérationnelle et compléments d'algèbre",0.0,12),(2.0,"M4203",4,"","",0.0,"Expr.-Com. - Communication dans les entreprises",50,0.0,0,"Expr.-Com. - Communication dans les organisations",0.0,12),(2.0,"M4204",4,"","",0.0,"Travailler en anglais",60,0.0,0,"Travailler en anglais",0.0,12),(12.0,"M4301",4,"","",0.0,"Stage professionnel",10,0.0,0,"Stage professionnel",0.0,13);

INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE1",0,"",6,"UCOD1",1,"Communication, Anglais, Gestion de projet",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Communication, Anglais, Gestion de projet",15);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC11",1,"VMRREC11","",0,"Communication",10,0,0,"Communication",0,15);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC12",1,"VMRREC12","",0,"Anglais",20,0,0,"Anglais",0,15);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC13",1,"VMRREC13","",0,"Gestion de projet",30,0,0,"Gestion de projet",0,15);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE2",0,"",6,"UCOD2",2,"Convergence réseaux et mobilité",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Convergence réseaux et mobilité",16);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC21",1,"VMRREC21","",0,"Base de données : PHP/MySQL Big Data",10,0,0,"Base de données : PHP/MySQL Big Data",0,16);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC22",1,"VMRREC22","",0,"Remise à niveau R&amp;T",20,0,0,"Remise à niveau R&amp;T",0,16);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC13",1,"VMRREC23","",0,"Remise à niveau prog. obj. mobiles",30,0,0,"Remise à niveau programmation objets mobiles",0,16);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE3",0,"",6,"UCOD3",3,"Interfaces et sécurité",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Interfaces et sécurité",17);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC31",1,"VMRREC31","",0,"Interfaces",10,0,0,"Interfaces",0,17);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC32",1,"VMRREC32","",0,"Sécurité",20,0,0,"Sécurité",0,17);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE4",0,"",6,"UCOD4",4,"Développement mobile",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Développement mobile",18);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC41",1,"VMRREC41","",0,"Mobilité dév. mobile Android",10,0,0,"Mobilité dév. mobile Android",0,18);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC42",1,"VMRREC42","",0,"Développement iOS",20,0,0,"Développement iOS",0,18);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE5 - R&amp;T",0,"",6,"UCD51",5,"Réseau sans fil",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Réseau sans fil",19);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC51 - R&amp;T",1,"VMRREC51","",0,"Techno. des réseaux sans fil",10,0,0,"Technologies des réseaux sans fil",0,19);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC52 - R&amp;T",1,"VMRREC52","",0,"Gest. des réseaux sans fil",20,0,0,"Gestion des réseaux sans fil",0,19);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC53 - R&amp;T",1,"VMRREC53","",0,"IPv6 pour mobile, 6lo WAN",30,0,0,"IPv6 pour mobile, 6lo WAN",0,19);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE5 - TeProW",0,"",6,"UCOD52",6,"Développement mobile avancé",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Développement mobile avancé",20);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC51 - TeProW",1,"VMRTEC51","",0,"Dvpt sur OS classique",10,0,0,"Dvpt sur OS classique",0,20);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC52 - TeProW",1,"VMRTEC52","",0,"Dvpt multiplateforme",20,0,0,"Développement multiplateforme",0,20);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC53 - TeProW",1,"VMRTEC53","",0,"Applications innovantes",30,0,0,"Applications innovantes",0,20);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE6",0,"",9,"UCOD6",7,"Services mobiles et Big data",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Services mobiles et Big data",21);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC61",1,"VMRREC61","",0,"Mobile Cloud",10,0,0,"Mobile Cloud",0,21);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC62",1,"VMRREC62","",0,"Syst. transport intellig. (ITS)",20,0,0,"Système de transport intelligent (ITS)",0,21);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (4,"EC63",1,"VMRREC63","",0,"Composants pour l'internet des objets",30,0,0,"Composants pour l'internet des objets",0,21);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE7 - R&amp;T",0,"",6,"UCOD71",8,"Localisation et données mobiles",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Localisation et données mobiles",22);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC71 - R&amp;T",1,"VMRREC71","",0,"Sécurité avancée des réseaux sans fil",10,0,0,"Sécurité avancée des réseaux sans fil",0,22);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC72 - R&amp;T",1,"VMRREC72","",0,"Capteurs et composants",20,0,0,"Capteurs et composants",0,22);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC73 - R&amp;T",1,"VMRREC73","",0,"Fonctions de localisation et réseaux associés",30,0,0,"Fonctions de localisation et réseaux associés",0,22);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE7 - TeProW",0,"",6,"UCOD72",9,"Applications web avancées",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Applications web avancées",23);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC71 - TeProW",1,"VMRTEC71","",0,"Développement web client",10,0,0,"Développement web client",0,23);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC72 - TeProW",1,"VMRTEC72","",0,"Développement web serveur",20,0,0,"Développement web serveur",0,23);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC73 - TeProW",1,"VMRTEC73","",0,"Dvpt web avec frameworks",30,0,0,"Dvpt web avec frameworks",0,23);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE8",0,"",6,"UCOD8",10,"Projet tutoré",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Projet tutoré",24);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (6,"Projet",1,"","",0,"Projet tutoré",10,0,0,"Projet tutoré",0,24);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE9",0,"",9,"UCOD9",11,"Stage",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Stage",25);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (9,"Stage",1,"","",0,"Stage",10,0,0,"Stage",0,25);

# EDSON
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Communication, Anglais, Gestion de projet",15);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC11",1,"VMRREC11","",0,"Communication",10,0,0,"Communication",0,15);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC11",1,"VMRREC11","",0,"Communication",10,0,0,"Communication",0,15);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE1",0,"",6,"UCOD1",1,"Communication, Anglais, Gestion de projet",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Communication, Anglais, Gestion de projet",15);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC11",1,"VMRREC11","",0,"Communication",10,0,0,"Communication",0,15);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC12",1,"VMRREC12","",0,"Anglais",20,0,0,"Anglais",0,15);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC13",1,"VMRREC13","",0,"Gestion de projet",30,0,0,"Gestion de projet",0,15);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE2",0,"",6,"UCOD2",2,"Convergence réseaux et mobilité",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Convergence réseaux et mobilité",16);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC21",1,"VMRREC21","",0,"Base de données : PHP/MySQL Big Data",10,0,0,"Base de données : PHP/MySQL Big Data",0,16);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC22",1,"VMRREC22","",0,"Remise à niveau R&amp;T",20,0,0,"Remise à niveau R&amp;T",0,16);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC13",1,"VMRREC23","",0,"Remise à niveau prog. obj. mobiles",30,0,0,"Remise à niveau programmation objets mobiles",0,16);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE3",0,"",6,"UCOD3",3,"Interfaces et sécurité",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Interfaces et sécurité",17);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC31",1,"VMRREC31","",0,"Interfaces",10,0,0,"Interfaces",0,17);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC32",1,"VMRREC32","",0,"Sécurité",20,0,0,"Sécurité",0,17);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE4",0,"",6,"UCOD4",4,"Développement mobile",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Développement mobile",18);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC41",1,"VMRREC41","",0,"Mobilité dév. mobile Android",10,0,0,"Mobilité dév. mobile Android",0,18);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC42",1,"VMRREC42","",0,"Développement iOS",20,0,0,"Développement iOS",0,18);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE5 - R&amp;T",0,"",6,"UCD51",5,"Réseau sans fil",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Réseau sans fil",19);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC51 - R&amp;T",1,"VMRREC51","",0,"Techno. des réseaux sans fil",10,0,0,"Technologies des réseaux sans fil",0,19);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC52 - R&amp;T",1,"VMRREC52","",0,"Gest. des réseaux sans fil",20,0,0,"Gestion des réseaux sans fil",0,19);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC53 - R&amp;T",1,"VMRREC53","",0,"IPv6 pour mobile, 6lo WAN",30,0,0,"IPv6 pour mobile, 6lo WAN",0,19);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE5 - TeProW",0,"",6,"UCOD52",6,"Développement mobile avancé",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Développement mobile avancé",20);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC51 - TeProW",1,"VMRTEC51","",0,"Dvpt sur OS classique",10,0,0,"Dvpt sur OS classique",0,20);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC52 - TeProW",1,"VMRTEC52","",0,"Dvpt multiplateforme",20,0,0,"Développement multiplateforme",0,20);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC53 - TeProW",1,"VMRTEC53","",0,"Applications innovantes",30,0,0,"Applications innovantes",0,20);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE6",0,"",9,"UCOD6",7,"Services mobiles et Big data",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Services mobiles et Big data",21);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (3,"EC61",1,"VMRREC61","",0,"Mobile Cloud",10,0,0,"Mobile Cloud",0,21);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC62",1,"VMRREC62","",0,"Syst. transport intellig. (ITS)",20,0,0,"Système de transport intelligent (ITS)",0,21);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (4,"EC63",1,"VMRREC63","",0,"Composants pour l'internet des objets",30,0,0,"Composants pour l'internet des objets",0,21);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE7 - R&amp;T",0,"",6,"UCOD71",8,"Localisation et données mobiles",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Localisation et données mobiles",22);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC71 - R&amp;T",1,"VMRREC71","",0,"Sécurité avancée des réseaux sans fil",10,0,0,"Sécurité avancée des réseaux sans fil",0,22);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC72 - R&amp;T",1,"VMRREC72","",0,"Capteurs et composants",20,0,0,"Capteurs et composants",0,22);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC73 - R&amp;T",1,"VMRREC73","",0,"Fonctions de localisation et réseaux associés",30,0,0,"Fonctions de localisation et réseaux associés",0,22);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE7 - TeProW",0,"",6,"UCOD72",9,"Applications web avancées",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Applications web avancées",23);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC71 - TeProW",1,"VMRTEC71","",0,"Développement web client",10,0,0,"Développement web client",0,23);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC72 - TeProW",1,"VMRTEC72","",0,"Développement web serveur",20,0,0,"Développement web serveur",0,23);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (2,"EC73 - TeProW",1,"VMRTEC73","",0,"Dvpt web avec frameworks",30,0,0,"Dvpt web avec frameworks",0,23);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE8",0,"",6,"UCOD8",10,"Projet tutoré",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Projet tutoré",24);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (6,"Projet",1,"","",0,"Projet tutoré",10,0,0,"Projet tutoré",0,24);
INSERT INTO unites_enseignements(acronyme,is_external,code_apogee,ects,ue_code,numero,titre,type, formation_id) VALUES ("UE9",0,"",9,"UCOD9",11,"Stage",0,"FORM10035");
INSERT INTO matiers(numero,titre,unite_enseignement_id) VALUES (1,"Stage",25);
INSERT INTO modules(coefficient,code,semestre_id,code_apogee,ects,heures_tp,abbrev,numero,heures_cours,module_type,titre,heures_td,matiere_id) VALUES (9,"Stage",1,"","",0,"Stage",10,0,0,"Stage",0,25);

INSERT INTO groupes(name, semestre_id) VALUES ('S1',1),('S1A',1),('S1B',1),('S1A1',1),('S1A2',1),('S1B1',1),('S1B2',1);
INSERT INTO groupes(name, semestre_id) VALUES ('S1',2),('S1A',2),('S1B',2),('S1A1',2),('S1A2',2),('S1B1',2),('S1B2',2);
INSERT INTO groupes(name, semestre_id) VALUES ('S1',3),('S1A',3),('S1B',3),('S1A1',3),('S1A2',3),('S1B1',3),('S1B2',3);
INSERT INTO groupes(name, semestre_id) VALUES ('S1',4),('S1A',4),('S1B',4),('S1A1',4),('S1A2',4),('S1B1',4),('S1B2',4);
INSERT INTO groupes(name, semestre_id) VALUES ('S1',5),('S1A',5),('S1B',5),('S1A1',5),('S1A2',5),('S1B1',5),('S1B2',5);
INSERT INTO groupes(name, semestre_id) VALUES ('S1',6),('S1A',6),('S1B',6),('S1A1',6),('S1A2',6),('S1B1',6),('S1B2',6);
INSERT INTO groupes(name, semestre_id) VALUES ('S1',7),('S1A',7),('S1B',7),('S1A1',7),('S1A2',7),('S1B1',7),('S1B2',7);
INSERT INTO groupes(name, semestre_id) VALUES ('S1',8),('S1A',8),('S1B',8),('S1A1',8),('S1A2',8),('S1B1',8),('S1B2',8);
INSERT INTO groupes(name, semestre_id) VALUES ('S1',9),('S1A',9),('S1B',9),('S1A1',9),('S1A2',9),('S1B1',9),('S1B2',9);
INSERT INTO groupes(name, semestre_id) VALUES ('S1',10),('S1A',10),('S1B',10),('S1A1',10),('S1A2',10),('S1B1',10),('S1B2',10);
INSERT INTO groupes(name, semestre_id) VALUES ('S1',11),('S1A',11),('S1B',11),('S1A1',11),('S1A2',11),('S1B1',11),('S1B2',11);
INSERT INTO groupes(name, semestre_id) VALUES ('S1',12),('S1A',12),('S1B',12),('S1A1',12),('S1A2',12),('S1B1',12),('S1B2',12);