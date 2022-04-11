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

/**
 *
 * @author Iaina
 */
@Named(value = "transfert")
@ViewScoped
public class Transfert implements Serializable {

    /**
     * Creates a new instance of Transfert
     */
    private Long idSource;
    private Long idDestination;

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    public Long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    public Long getIdSource() {
        return idSource;
    }

    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }
    private int amount;

    /**
     * Get the value of amount
     *
     * @return the value of amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Set the value of amount
     *
     * @param amount new value of amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String transferAmount() {
        boolean erreur = false;
        CompteBancaire source = gestionnaireCompte.getCompte(idSource);
        if (source == null) {
            erreur = true;
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:idSource");
        }
        CompteBancaire destination = gestionnaireCompte.getCompte(idDestination);
        if (destination == null) {
            erreur = true;
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:idDestination");
        }
        if (!erreur) {
            if (source.getSolde() < amount) {
                Util.messageErreur("Montant insuffisant", "Montant insuffisant", "form:amount");
                return null;
            } else {
                gestionnaireCompte.transferer(source, destination, amount);
                Util.addFlashInfoMessage("Transfert correctement effectué");
                return "listeComptes?faces-redirect=true";
            }
        }
        
        return null;
    }

}
