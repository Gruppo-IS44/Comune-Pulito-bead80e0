CREATE TABLE UTENTE(
    Id_utente int NOT NULL AUTO_INCREMENT,
    Nome varchar(30),
    Cognome varchar(30),
    Email varchar(50) NOT NULL UNIQUE,
    Pwd varchar(100) NOT NULL,
    Bilancio int DEFAULT 0,
    Warn tinyint DEFAULT 0,
    Ban bit DEFAULT 0,
    PRIMARY KEY(Id_utente)
);

CREATE TABLE GESTORE(
    Id_gestore int NOT NULL AUTO_INCREMENT,
    Nome varchar(30),
    Cognome varchar(30),
    Pwd varchar(100),
    Email varchar(50) NOT NULL UNIQUE,
    Sede varchar(30),
    PRIMARY KEY(Id_gestore)
);

CREATE TABLE SEGNALAZIONE_STATO(
    Id int NOT NULL AUTO_INCREMENT,
    Stato varchar(20),
    PRIMARY KEY(id)
);

CREATE TABLE CLUSTER_STATO(
    Id int NOT NULL AUTO_INCREMENT,
    Stato varchar(20),
    PRIMARY KEY(id)
);

CREATE TABLE REWARD(
    Id_reward int NOT NULL AUTO_INCREMENT,
    Descrizione varchar(100),
    Nome varchar(20),
    Costo int,
    Stock int,
    PRIMARY KEY(Id_reward)
);

CREATE TABLE ORDINE(
    Id_ordine int NOT NULL AUTO_INCREMENT,
    Dataora datetime,
    Quantita tinyint default 1 NOT NULL,
    Id_utente int NOT NULL,
    Id_reward int NOT NULL,
    PRIMARY KEY(Id_ordine),
    FOREIGN KEY(Id_utente) REFERENCES utente(Id_utente),
    FOREIGN KEY(Id_reward) REFERENCES reward(Id_reward)
);

CREATE TABLE CLUSTER(
    Id_cluster int NOT NULL AUTO_INCREMENT,
    Posizione point,
    Id_gestore int NOT NULL,
    Raggio float, 
	Id_Stato int NOT NULL REFERENCES CLUSTER_STATO(Id),
    PRIMARY KEY(Id_cluster),
    FOREIGN KEY(Id_gestore) REFERENCES gestore(Id_gestore)
); 

CREATE TABLE TIPO(
Id_tipo int NOT NULL AUTO_INCREMENT,
Tipo varchar(10)
);

CREATE TABLE SEGNALAZIONE(
    Id_segnalazione int NOT NULL AUTO_INCREMENT,
    Dataora datetime,
    Foto blob,
    Latitudine float,
    Longitudine float,
	Id_Tipo int NOT NULL REFERENCES TIPO(Id_tipo),
    Id_Stato int NOT NULL REFERENCES SEGNALAZIONE_STATO(Id),
    Id_cluster int NOT NULL,
    Id_utente int NOT NULL,
    PRIMARY KEY(Id_segnalazione),
    FOREIGN KEY(Id_cluster) REFERENCES cluster(Id_cluster),
    FOREIGN KEY(Id_utente) REFERENCES utente(Id_utente)
);

