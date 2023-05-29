package com.sistemaSincronizacao.stockexchange;

public class Stock {
    private String name;
    private int quantity;
    private double currentPrice;
    private long id;



    public Stock(long id,String name, int quantity, double currentPrice) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.currentPrice = currentPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
