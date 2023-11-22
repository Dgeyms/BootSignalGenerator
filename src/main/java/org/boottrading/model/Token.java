package org.boottrading.model;

import java.util.ArrayList;

/**
 * parameters tokens
 */
public class Token {
    private final String nameToken;
    private String marketPair; // Торговая пара
    private final ArrayList<Double> quoteDataList; // data close price token
    private String time = "02.3.2023";


    public Token(ArrayList<Double> quoteDataList, String nameToken) {
        this.quoteDataList = quoteDataList;
        this.nameToken = nameToken;
    }

    public String getNameToken() {
        return nameToken;
    }
    public String getMarketPair() {
        return marketPair;
    }

    public ArrayList<Double> getQuoteDataList() {
        return quoteDataList;
    }

    public String getTime() {
        return time;
    }
}
