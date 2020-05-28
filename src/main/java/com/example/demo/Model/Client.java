package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="client")
public class Client extends User {

    private String genre;
    private String profession;
    private String civilite;

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    private String date_nais;
    private String permis;
    private String date_permis;
    private String ville;
    private String adresse;

    //*******************************
    @OneToMany(mappedBy = "client")
    private List<Reclamation> reclamationList;

    @OneToMany(mappedBy = "client")
    private List<Reservation> reservationList;

    @JsonIgnore
    public List<Reclamation> getReclamationList() {
        return reclamationList;
    }

    @JsonIgnore
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public void setReclamationList(List<Reclamation> reclamationList) {
        this.reclamationList = reclamationList;



    //*******************************

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }



    public String getDate_nais() {
        return date_nais;
    }

    public void setDate_nais(String date_nais) {
        this.date_nais = date_nais;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public String getDate_permis() {
        return date_permis;
    }

    public void setDate_permis(String date_permis) {
        this.date_permis = date_permis;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Client() {
    }
}
