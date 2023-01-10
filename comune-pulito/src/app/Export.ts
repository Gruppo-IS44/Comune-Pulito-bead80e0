export class Login{
    email!:string;
    password!:string;
    isGestore!:boolean;
}

export class Token{
    token!:string;
    valido!:boolean;
    nome!:string;
    cognome!:string;
}

export class Signup{
    email!:string;
    username!:string;
    password!:string;
    nome!:string;
    cognome!:string;
}

export class SignupResponse{
    valido!:boolean;
    userLogin!:Token;
}

export class Segnalazione{
    foto!:string;
    descrizione!:string;
    tipo_rifiuto!:number;
    latitudine!:number;
    longitudine!:number;
    utente!:string;
}

export class Utente{
    email!:string;
    password!:string;
    nome!:string;
    cognome!:string;
}

export class Tipo{
    tipo!:string;
    signup!:boolean;
}

export class MenuGestore{
    id_cluster!:Cluster;
    segnalazioni!:Array<Segnalazione2>;
}

export class Cluster{
    raggio!:number;
    id_stato!:string;
    id_cluster!:string;
    id_gestore!:string;
    longitudine!:number;
    latitudine!:number;
}

export class Segnalazione2 extends Segnalazione{
    dataora!:string;
    id_Stato!:string;
    id_segnalazione!:string;
    id_Tipo!:string;
    id_utente!:string;
}