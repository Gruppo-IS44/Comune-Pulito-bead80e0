export class Login{
    email!:string;
    password!:string;
    isGestore!:boolean;
}

export class Signup{
    email!:string;
    username!:string;
    password!:string;
    nome!:string;
    cognome!:string;
}

export class Utente{
    email!:string;
    username!:string;
    password!:string;
    nome!:string;
    cognome!:string;
}

export class Tipo{
    tipo!:string;
    signup!:boolean;
}