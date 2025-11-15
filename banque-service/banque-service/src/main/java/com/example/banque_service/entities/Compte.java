package com.example.banque_service.entities;


import jakarta.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double soldeInitial; // solde de départ

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;

    // Relation avec Transaction
    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    // --- Constructeurs ---
    public Compte() {
    }

    public Compte(Long id, double soldeInitial, Date dateCreation, TypeCompte type) {
        this.id = id;
        this.soldeInitial = soldeInitial;
        this.dateCreation = dateCreation;
        this.type = type;
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSoldeInitial() {
        return soldeInitial;
    }

    public void setSoldeInitial(double soldeInitial) {
        this.soldeInitial = soldeInitial;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public TypeCompte getType() {
        return type;
    }

    public void setType(TypeCompte type) {
        this.type = type;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    // --- Méthode calcul du solde dynamique ---
    public double getSolde() {
        double totalTransactions = transactions.stream()
                .mapToDouble(t -> t.getType() == TypeTransaction.DEPOT ? t.getMontant() : -t.getMontant())
                .sum();
        return soldeInitial + totalTransactions;
    }
}
