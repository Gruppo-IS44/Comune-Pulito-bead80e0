export interface Login{
    username:string,
    password:string
    isGestore:boolean
}

export interface Signup{
    email:string,
    username:string,
    password:string,
    nome:string,
    cognome:string
}

export interface Utente{
    email:string,
    username:string,
    password:string,
    nome:string,
    cognome:string
}

export interface Tipo{
    tipo:string,
    signup:boolean
}