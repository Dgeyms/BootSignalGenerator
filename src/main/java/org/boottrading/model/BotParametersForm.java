package org.boottrading.model;

import java.util.List;

import org.boottrading.service.repository.BotParametersService;

public class BotParametersForm {
    private String nameBot;
    private List<String> listTokenPair; // database
    private TypeTradingDirection typeTradingDirection; // направление торговли
    private int creditLeverage;
    private double percentTakeProfit;
    private double dollarOrderVolume;
    private String strategy; // database

    public enum TypeTradingDirection {
        LONG, SHORT
    }

    List listTokenPair = privateGetTokenPairFromDataBase();
    BotParametersService botParametersService = new BotParametersService();

    private List<String> privateGetTokenPairFromDataBase() {
        return botParametersService.getTokenPairFromDataBase();
    }
}
