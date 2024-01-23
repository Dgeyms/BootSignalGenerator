package org.boottrading.model;

public class BotParametersForm {
    private String nameBot;
    private String tokenPair;
    private TypeTradingDirection typeTradingDirection; // направление торговли
    private int creditLeverage;
    private double percentTakeProfit;
    private double dollarOrderVolume;
    private String strategy;

    public enum TypeTradingDirection {
        LONG, SHORT
    }
}
