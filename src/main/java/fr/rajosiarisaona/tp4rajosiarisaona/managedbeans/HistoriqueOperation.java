/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fr.rajosiarisaona.tp4rajosiarisaona.managedbeans;

import fr.rajosiarisaona.tp4rajosiarisaona.entities.CompteBancaire;
import fr.rajosiarisaona.tp4rajosiarisaona.entities.OperationBancaire;
import fr.rajosiarisaona.tp4rajosiarisaona.session.GestionnaireCompte;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Iaina
 */
@Named(value = "historiqueOperation")
@ViewScoped
public class HistoriqueOperation implements Serializable {

    private Long idCompte;
    
    private CompteBancaire compte;
    
    public Long getIdCompte() {
        return idCompte;
    }
    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }
    public CompteBancaire getDetails() {
        return compte;
    }
    /**
     * Creates a new instance of HistoriqueOperation
     */
    @EJB
    private GestionnaireCompte gestionnaireCompte;

    private List<OperationBancaire> allOperations;

    public List<OperationBancaire> getAllOperations() {
        return allOperations;
    }

    public HistoriqueOperation() {
        this.allOperations = new ArrayList<>();

    }
    public void loadHistorique() {
        this.compte = gestionnaireCompte.getCompte(idCompte);
        this.allOperations = compte.getOperations();
    }

}
