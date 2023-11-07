package org.boottrading.service.indicators;


import java.util.ArrayList;

/**
 * The class calculates exponential moving averages based on quotes.
 */
public class EMACalculator {
    private final ArrayList<Double>  quoteDataList; // quote data token
    private final int  period;

    public EMACalculator(ArrayList<Double>  quoteDataList, int period) {
        this.quoteDataList = quoteDataList;
        this.period = period;

    }

    public ArrayList<Double> calculateEMA() {
        return calculateEMAPrivate();
    }

    private ArrayList<Double> calculateEMAPrivate() {
        if (quoteDataList == null || quoteDataList.size() < period) {
            throw new IllegalArgumentException("Insufficient quoteDataList for EMA calculation");
        }

        ArrayList<Double> emaValues = new ArrayList<>();
        double multiplier = 2.0 / (period + 1);

        // Вычисление первой EMA как простого скользящего среднего (SMA)
        double sma = 0;
        for (int i = 0; i < period; i++) {
            sma += quoteDataList.get(i);
        }
        sma /= period;
        emaValues.add(sma);

        // Вычисление остальных EMA
        for (int i = period; i < quoteDataList.size(); i++) {
            double ema = (quoteDataList.get(i) - emaValues.get(i - period)) * multiplier + emaValues.get(i - period);
            emaValues.add(ema);
        }
        return emaValues;
    }
}
