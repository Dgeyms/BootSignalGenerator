package org.boottrading.service;

import java.util.ArrayList;

/**
 * The class calculates exponential moving averages based on quotes.
 */
public class EMA {
    private int period_21 = 21;
    private int period_5 = 5;

    ArrayList<Double> quoteDataList;

    public EMA(ArrayList<Double> quoteDataList) {
        this.quoteDataList = quoteDataList;
    }

    public void createEMA(){
        createEMAPrivate();
    }

    private void createEMAPrivate(){

    }
}
