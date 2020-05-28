package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Societe extends User{
    private String logo;
    private String adresse;
    private String tel;
    private String ville;
    private String date_cre;


    //*******************
    @OneToMany(mappedBy = "societe")
    private List<Voiture> voiturelist;

    public Societe() {
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDate_cre() {
        return date_cre;
    }

    public void setDate_cre(String date_cre) {
        this.date_cre = date_cre;
    }
    @JsonIgnore
    public List<Voiture> getVoiturelist() {
        return voiturelist;
    }

    public void setVoiturelist(List<Voiture> voiturelist) {
        this.voiturelist = voiturelist;
    }
}
