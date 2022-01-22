package com.example.banknifty.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class StocksDataDAO {

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("open")
    private double open;
    @JsonProperty("dayHigh")
    private double dayHigh;
    @JsonProperty("dayLow")
    private double dayLow;
    @JsonProperty("change")
    private double change;
    @JsonProperty("pChange")
    private double pChange;

    public StocksDataDAO(String symbol, double open, double dayHigh, double dayLow, double change, double pChange) {
        this.symbol = symbol;
        this.open = open;
        this.dayHigh = dayHigh;
        this.dayLow = dayLow;
        this.change = change;
        this.pChange = pChange;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(double dayHigh) {
        this.dayHigh = dayHigh;
    }

    public double getDayLow() {
        return dayLow;
    }

    public void setDayLow(double dayLow) {
        this.dayLow = dayLow;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getpChange() {
        return pChange;
    }

    public void setpChange(double pChange) {
        this.pChange = pChange;
    }

    public StocksDataDAO() {
    }
}
