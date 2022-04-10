/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.rajosiarisaona.tp4rajosiarisaona.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Iaina
 */
//@Entity
@Entity(name="compte")
@NamedQueries({
    @NamedQuery(name = "compte.findAll", query = "SELECT c FROM compte c")})
public class CompteBancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    public CompteBancaire() {
    }

    public CompteBancaire(String nom, int solde) {
        this.Solde = solde;
        this.Nom = nom;
    }

    public Long getId() {
        return Id;
    }
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String Nom;

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.Nom = nom;
    }

    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int Solde;

    /**
     * Get the value of solde
     *
     * @return the value of solde
     */
    public int getSolde() {
        return Solde;
    }

    /**
     * Set the value of solde
     *
     * @param solde new value of solde
     */
    public void setSolde(int solde) {
        this.Solde = solde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Id != null ? Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire other = (CompteBancaire) object;
        if ((this.Id == null && other.Id != null) || (this.Id != null && !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.rajosiarisaona.tp4rajosiarisaona.entities.CompteBancaire[ id=" + Id + " ]";
    }

    public void deposer(int montant) {
        Solde += montant;
    }

    public void retirer(int montant) {
        if (montant < Solde) {
            Solde -= montant;
        } else {
            Solde = 0;
        }
    }

}
