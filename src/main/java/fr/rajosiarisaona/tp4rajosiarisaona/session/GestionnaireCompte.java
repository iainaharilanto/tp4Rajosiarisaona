/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fr.rajosiarisaona.tp4rajosiarisaona.session;

import fr.rajosiarisaona.tp4rajosiarisaona.entities.CompteBancaire;
import fr.rajosiarisaona.tp4rajosiarisaona.entities.OperationBancaire;
import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Iaina
 */
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3307,
        user = "iaina", // nom et
        password = "1234", // mot de passe que vous avez donnés lors de la création de la base de données
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true"
        }
)
@Stateless
public class GestionnaireCompte {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;

    public void creerCompte(CompteBancaire object) {
        em.persist(object);
    }

    public int nbComptes() {
        Query query = em.createQuery("Select count(c) from compte c");
        Number num = (Number) query.getSingleResult();
        return num.intValue();
    }

    public List<CompteBancaire> getAllCompteBancaire() {
        Query query = em.createNamedQuery("compte.findAll");
        return query.getResultList();
    }

    public CompteBancaire update(CompteBancaire compte) {
        return em.merge(compte);
    }

    public CompteBancaire getCompte(Long idCompte) {
        return em.find(CompteBancaire.class, idCompte);
    }

    public void transferer(CompteBancaire source, CompteBancaire destination,
            int montant) {
        source.retirer(montant);
        destination.deposer(montant);
        update(source);
        update(destination);
    }

    /**
     * Dépôt d'argent sur un compte bancaire.
     *
     * @param compteBancaire
     * @param montant
     */
    public void deposer(CompteBancaire compteBancaire, int montant) {
        compteBancaire.deposer(montant);
        update(compteBancaire);
    }

    /**
     * Retrait d'argent sur un compte bancaire.
     *
     * @param compteBancaire
     * @param montant
     */
    public void retirer(CompteBancaire compteBancaire, int montant) {
        compteBancaire.retirer(montant);
        update(compteBancaire);
    }

    public void supprimerCompte(CompteBancaire c) {
        if (!em.contains(c)) {
            c = em.merge(c);
        }
        em.remove(c);
    }

    public void supprimerCompte(Long id) {
        CompteBancaire c = em.find(CompteBancaire.class, id);
        if (c != null) {
            em.remove(c);
        }
    }
}
