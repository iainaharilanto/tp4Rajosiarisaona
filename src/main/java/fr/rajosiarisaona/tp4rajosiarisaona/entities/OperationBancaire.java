/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.rajosiarisaona.tp4rajosiarisaona.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Entity(name = "operationbancaire")
public class OperationBancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }
    private LocalDateTime dateOperation;

    public LocalDateTime getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(LocalDateTime dateOp){
        this.dateOperation = dateOp;
    }
    
    private int montant;
    
    public int getMontant() {
        return montant;
    }

    public void setMontant(int amount) {
        this.montant = amount;
    }

    public OperationBancaire() {
    }

    public OperationBancaire(String description, int montant) {
        this.description = description;
        this.montant = montant;
        dateOperation = LocalDateTime.now();
    }
}
