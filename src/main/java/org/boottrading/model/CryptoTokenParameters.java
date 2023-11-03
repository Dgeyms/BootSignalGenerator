package org.boottrading.model;

/**
 * parameters tokens
 */
public class CryptoTokenParameters {
    public String nameToken;
    public int periodEMALong = 21;
    public int periodEMAShort = 5;

    public CryptoTokenParameters(String nameToken, int periodEMALong, int periodEMAShort) {
        this.nameToken = nameToken;
        this.periodEMALong = periodEMALong;
        this.periodEMAShort = periodEMAShort;
    }
}
