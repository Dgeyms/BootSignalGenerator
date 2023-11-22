package org.boottrading.controler;

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
        Token tokenARB = generatorDataPriceClose();
        saveClosingPricesInDatabase(tokenARB);
        //generateEMA_5();
        //checkDataEMA5ForARB();
        //generateEMA21ForARB();
        //checkDataEMA21ForARB();
    }

    private Token generatorDataPriceClose() {
        GeneratorData generatorData = new GeneratorData();
        Token token = new Token(generatorData.generateData(), "ARB");
        return token;
    }
    // method create EMA_5
    private void generateEMA_5() {
        emaIndicator5 = new EMAIndicator(token.getQuoteDataList(), 5 );
    }

    // method create EMA_21
    private void generateEMA21ForARB() {
        emaIndicator21 = new EMAIndicator(token.getQuoteDataList(), 21);
    }

    private void saveClosingPricesInDatabase(Token tokenARB) {
        DatabaseServiceQuotes databaseServiceQuotes = new DatabaseServiceQuotesImpl();
        databaseServiceQuotes.saveClosePricesInDatabase(tokenARB);
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
