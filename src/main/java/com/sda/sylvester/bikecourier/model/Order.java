package com.sda.sylvester.bikecourier.model;

public class Order {

    private String from;
    private String to;
    private String term;

    public Order() {
    }

    public Order(String from, String to, String term) {
        this.from = from;
        this.to = to;
        this.term = term;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Order{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}