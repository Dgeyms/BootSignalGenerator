package org.boottrading.service;

import java.util.ArrayList;

/**
 * Quote service
 * Blings quotes from the exchange (using the API Exchange).
 * Saves quotes in the database
 */
public class QuoteService {

    // request of quotations from the exchange
    public ArrayList<Double> requestQuotationsFromExchange(){
        GeneratorData generatorData = new GeneratorData();
        ArrayList<Double> cryptoQuotesList = generatorData.generateData();
        return cryptoQuotesList;
    }

    // save quotes in database
    public void saveQuotesInDatabase(){

    }
}
