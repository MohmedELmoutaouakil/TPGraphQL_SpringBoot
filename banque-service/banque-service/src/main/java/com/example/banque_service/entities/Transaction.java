package com.example.banque_service.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    private TypeTransaction type; // DEPOT ou RETRAIT

    @ManyToOne
    @JoinColumn(name = "compte_id", nullable = false)
    private Compte compte;

    // --- Constructeurs ---
    public Transaction() {}

    public Transaction(double montant, Date date, TypeTransaction type, Compte compte) {
        this.montant = montant;
        this.date = date;
        this.type = type;
        this.compte = compte;
    }

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public TypeTransaction getType() { return type; }
    public void setType(TypeTransaction type) { this.type = type; }

    public Compte getCompte() { return compte; }
    public void setCompte(Compte compte) { this.compte = compte; }
}
