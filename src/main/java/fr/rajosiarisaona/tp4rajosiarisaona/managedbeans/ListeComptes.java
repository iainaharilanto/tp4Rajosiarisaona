/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fr.rajosiarisaona.tp4rajosiarisaona.managedbeans;

import fr.rajosiarisaona.tp4rajosiarisaona.entities.CompteBancaire;
import fr.rajosiarisaona.tp4rajosiarisaona.session.GestionnaireCompte;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Iaina
 */

@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    @EJB
    private GestionnaireCompte gestionnaireCompte;
    // = gestionnaireCompte.getAllCompteBancaire();
    
    private  List<CompteBancaire> allComptes;

    /**
     * Get the value of allComptes
     *
     * @return the value of allComptes
     */
    public List<CompteBancaire> getAllComptes() {
        return allComptes;
    }

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
        this.allComptes = new ArrayList<>();
        
    }
   @PostConstruct
    public void init() {
        //System.out.println("fr.rajosiarisaona.tp4rajosiarisaona.managedbeans.ListeComptes.init()");
        allComptes.add(new CompteBancaire("Iaina", 150000));
        List<CompteBancaire> test = gestionnaireCompte.getAllCompteBancaire();
        System.out.println("fr.rajosiarisaona.tp4rajosiarisaona.managedbeans.ListeComptes.init()"+test.toString());
        allComptes = gestionnaireCompte.getAllCompteBancaire();
    }
    
}
