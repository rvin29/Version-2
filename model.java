package com.example.erovoutika;

public class model {

    String reference, application, caption, symbol, graph, number, descriplong, description, name, picture;

    public model() {
    }

    public model(String reference,String application, String caption, String symbol, String graph, String number, String descriplong, String description, String name, String picture ){
        this.reference = reference;
        this.application = application;
        this.caption = caption;
        this.symbol =symbol;
        this.graph = graph;
        this.number = number;
        this.descriplong = descriplong;
        this.description = description;
        this.name = name;
        this.picture = picture;

    }
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getDescriplong() {
        return descriplong;
    }

    public void setDescriplong(String descriplong) {
        this.descriplong = descriplong;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


}
