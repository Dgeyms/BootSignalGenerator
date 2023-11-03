package org.boottrading.model;

import org.boottrading.service.GeneratorData;

/**
 * params token ARB
 */
public class ARB extends CryptoTokenParameters {
    private String marketPair = "ARB/USDT"; // Торговая пара
    private GeneratorData quoteTokenARB;

    public ARB(String nameToken, int periodEMALong, int periodEMAShort, String marketPair) {
        super(nameToken, periodEMALong, periodEMAShort);
        this.marketPair = marketPair;
        this.quoteTokenARB = new GeneratorData();
    }
}
