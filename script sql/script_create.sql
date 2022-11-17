CREATE TABLE UTENTE(
    Id_utente int NOT NULL,
    Nome varchar(30),
    Cognome varchar(30),
    Email varchar(25) NOT NULL,
    Bilancio int DEFAULT 0,
    Warn tinyint DEFAULT 0,
    Ban bit DEFAULT 0,
    PRIMARY KEY(Id_utente)
);

CREATE TABLE GESTORE(
    Id_gestore int NOT NULL,
    Nome varchar(30),
    Cognome varchar(30),
    Email varchar(25) NOT NULL,
    Sede varchar(30),
    PRIMARY KEY(Id_gestore)
);

CREATE TABLE REWARD(
    Id_reward int NOT NULL,
    Descrizione varchar(100),
    Nome varchar(20),
    Costo int,
    Stock int,
    PRIMARY KEY(Id_reward)
);

CREATE TABLE ORDINE(
    Id_ordine int NOT NULL,
    Dataora datetime,
    Id_utente int NOT NULL,
    Id_reward int NOT NULL,
    PRIMARY KEY(Id_ordine),
    FOREIGN KEY(Id_utente) REFERENCES utente(Id_utente),
    FOREIGN KEY(Id_reward) REFERENCES reward(Id_reward)
);

CREATE TABLE CLUSTER(
    Id_cluster int NOT NULL,
    Posizione point,
    Id_gestore int NOT NULL,
    Raggio float, 
    Risolto bit default 0,
    Valido bit default 1,
    PRIMARY KEY(Id_cluster),
    FOREIGN KEY(Id_gestore) REFERENCES gestore(Id_gestore)
); 

CREATE TABLE SEGNALAZIONE(
    Id_segnalazione int NOT NULL,
    Posizione point,
    Dataora datetime,
    Tipo varchar(10),
    Foto blob,
    Id_cluster int NOT NULL,
    Id_utente int NOT NULL,
    PRIMARY KEY(Id_segnalazione),
    FOREIGN KEY(Id_cluster) REFERENCES cluster(Id_cluster),
    FOREIGN KEY(Id_utente) REFERENCES utente(Id_utente)
)