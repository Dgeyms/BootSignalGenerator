package org.boottrading.model;

import java.util.ArrayList;

/**
 * parameters tokens
 */
public class Token {
    public String nameToken;
    public String marketPair; // Торговая пара
    public ArrayList<Double> quoteDataList; // quote data token


    public Token(ArrayList<Double> quoteDataList, String nameToken) {
        this.nameToken = nameToken;
        this.quoteDataList = quoteDataList;
    }
}
