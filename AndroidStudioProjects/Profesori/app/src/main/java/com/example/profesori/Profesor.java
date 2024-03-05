package com.example.profesori;

import android.widget.TextView;

import java.io.Serializable;

public class Profesor implements Serializable {
    private int id;
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private String naziv;
    private String cena;
    private String detalji;

    public Profesor(String ime, String prezime, String username, String password,
                    String naziv, String cena, String detalji) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.naziv = naziv;
        this.cena = cena;
        this.detalji = detalji;
    }

//    public Profesor(String ime, String prezime, String username, String password) {
////        this.id = id;
//        this.ime = ime;
//        this.prezime = prezime;
//        this.username = username;
//        this.password = password;
//    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getDetalji() {
        return detalji;
    }

    public void setDetalji(String detalji) {
        this.detalji = detalji;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
