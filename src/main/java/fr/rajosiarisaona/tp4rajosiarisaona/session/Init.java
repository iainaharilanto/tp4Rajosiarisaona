/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package fr.rajosiarisaona.tp4rajosiarisaona.session;

import fr.rajosiarisaona.tp4rajosiarisaona.entities.CompteBancaire;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Iaina
 */
@Singleton
@Startup
public class Init {

    @EJB
    private GestionnaireCompte gCompte;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct
    public void init() {
        if (gCompte.nbComptes() > 0) {
            return;
        }
        gCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
        gCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
        gCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
        gCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
    }

}
