package com.example.banknifty.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties
public class BankNiftyDAO {

    @JsonProperty("data")
    private List<StocksDataDAO> data;

    public BankNiftyDAO(List<StocksDataDAO> data) {
        this.data = data;
    }

    public List<StocksDataDAO> getData() {
        return data;
    }

    public void setData(List<StocksDataDAO> data) {
        this.data = data;
    }

    public BankNiftyDAO() {
    }
}
