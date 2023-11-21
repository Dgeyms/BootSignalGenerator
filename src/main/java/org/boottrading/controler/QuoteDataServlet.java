package org.boottrading.controler;

import org.boottrading.model.ARB;
import org.boottrading.model.Token;
import org.boottrading.service.GeneratorData;
import org.boottrading.service.indicators.EMAIndicator;
import org.boottrading.service.repository.DatabaseServiceQuotes;
import org.boottrading.service.repository.DatabaseServiceQuotesImpl;

/**
 * Class
 */
public class QuoteDataServlet {
    private Token token;
    private EMAIndicator emaIndicator5;
    private EMAIndicator emaIndicator21;

    public void play() {
        // генерация данных (потом будут приходить с биржи)
        generatorData();
        saveClosingPricesInDatabase();
        //generateEMA5ForARB();
        //checkDataEMA5ForARB();
        //generateEMA21ForARB();
        //checkDataEMA21ForARB();
    }

    // method generator data token ARB
    private void generatorData() {
        GeneratorData generatorData = new GeneratorData();
        this.token = new ARB(generatorData.generateData(), "ARB");
    }

    // method create EMA_5
    private void generateEMA5ForARB() {
        emaIndicator5 = new EMAIndicator(token.getQuoteDataList(), 5);
    }

    // method create EMA_21
    private void generateEMA21ForARB() {
        emaIndicator21 = new EMAIndicator(token.getQuoteDataList(), 21);
    }

    // method save closing prices in database Quotes
    private void saveClosingPricesInDatabase() {
        DatabaseServiceQuotes databaseServiceQuotes = new DatabaseServiceQuotesImpl();
        databaseServiceQuotes.saveClosePricesInDatabase(token);
    }

    // method check EMA_5 ARB
    private void checkDataEMA5ForARB() {
        System.out.println("--------------------------------");
        for (int x = 0; x < emaIndicator5.getQuoteDataList().size(); x++) {
            double shortARB = emaIndicator5.getQuoteDataList().get(x);
            System.out.println("EMA_5 " + (x + 1) + "день " + String.format(" %.2f", shortARB));
        }
    }

    // method check EMA_21 ARB
    private void checkDataEMA21ForARB() {
        System.out.println("--------------------------------");
        for (int x = 0; x < emaIndicator21.getQuoteDataList().size(); x++) {
            double longARB = emaIndicator21.getQuoteDataList().get(x);
            System.out.println("EMA_21 " + (x + 1) + "день " + String.format(" %.2f", longARB));
        }
    }
}
