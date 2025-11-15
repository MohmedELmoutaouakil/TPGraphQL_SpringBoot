package com.example.banque_service.entities;

import java.util.Date;

public class TransactionRequest {

    private Long compteId;       // ID du compte concerné
    private double montant;      // Montant de la transaction
    private Date date;           // Date de l'opération
    private TypeTransaction type; // DEPOT ou RETRAIT

    // --- Constructeurs ---
    public TransactionRequest() {}

    public TransactionRequest(Long compteId, double montant, Date date, TypeTransaction type) {
        this.compteId = compteId;
        this.montant = montant;
        this.date = date;
        this.type = type;
    }

    // --- Getters & Setters ---
    public Long getCompteId() {
        return compteId;
    }

    public void setCompteId(Long compteId) {
        this.compteId = compteId;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }
}
