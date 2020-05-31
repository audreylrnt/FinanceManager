package com.example.financemanager;

public class Transaction {
    public int id;
    public String type;
    public String wallet;
    public String notes;
    public String date;
    public double amount;

    public Transaction(int id, String type, String wallet, String notes, String date, double amount) {
        this.id = id;
        this.type = type;
        this.wallet = wallet;
        this.notes = notes;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
