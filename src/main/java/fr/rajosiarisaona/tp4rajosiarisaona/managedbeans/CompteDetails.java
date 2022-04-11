/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fr.rajosiarisaona.tp4rajosiarisaona.managedbeans;

import fr.rajosiarisaona.tp4rajosiarisaona.entities.CompteBancaire;
import fr.rajosiarisaona.tp4rajosiarisaona.session.GestionnaireCompte;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Iaina
 */
@Named(value = "compteDetails")
@ViewScoped
public class CompteDetails implements Serializable{

    /**
     * Creates a new instance of CompteDetails
     */
    private Long idCompte;
    private CompteBancaire compte;

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBancaire getDetails() {
        return compte;
    }

    public String update() {
        compte = gestionnaireCompte.update(compte);
        return "listeComptes?faces-redirect=true";
    }

    public void loadCompte() {
        this.compte = gestionnaireCompte.getCompte(idCompte);
    }

}
