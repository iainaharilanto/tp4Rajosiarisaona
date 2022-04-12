/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fr.rajosiarisaona.tp4rajosiarisaona.managedbeans;

import fr.rajosiarisaona.tp4rajosiarisaona.entities.CompteBancaire;
import fr.rajosiarisaona.tp4rajosiarisaona.session.GestionnaireCompte;
import fr.rajosiarisaona.tp4rajosiarisaona.utilities.Util;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Iaina
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte implements Serializable {

    private String name;
    private int solde;

    /**
     * Get the value of solde
     *
     * @return the value of solde
     */
    public int getSolde() {
        return solde;
    }

    /**
     * Set the value of solde
     *
     * @param solde new value of solde
     */
    public void setSolde(int solde) {
        this.solde = solde;
    }


    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of nom
     *
     * @param name new value of nom
     */
    public void setName(String name) {
        this.name = name;
    }

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    public String action(){
        CompteBancaire object = new CompteBancaire(name, solde);
        
        gestionnaireCompte.creerCompte(object);
        
        Util.addFlashInfoMessage("correctement effectué");
                return "listeComptes?faces-redirect=true";
    }

}
