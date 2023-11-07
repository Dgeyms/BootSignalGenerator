package org.boottrading.service.strategies;

import java.util.ArrayList;

/**
 * Implementation of the strategy EMA + KDJ
 */
public class TradingStrategyEmaKdj {
    private ArrayList<Double> emaLongData;
    private ArrayList<Double> emaShortData;
    private ArrayList<Double> kdjData;

    public TradingStrategyEmaKdj(ArrayList<Double> emaLongData, ArrayList<Double> emaShortData, ArrayList<Double> kdjData) {
        this.emaLongData = emaLongData;
        this.emaShortData = emaShortData;
        this.kdjData = kdjData;
    }

    public void generateSignal(){
        generateSignalPrivate();
    }

    private void generateSignalPrivate(){

    }
    // defines where EMA 5 is located relative to EMA 21
    private String determineEMAPosition(){
        /**
         * используется для определения минимального размера данных между ema5Data и ema21Data.
         * Это делается, чтобы убедиться, что мы сравниваем значения EMA 5 и EMA 21 только на доступных данных и не выходим за пределы размера наименьшего списка.
         */
        int dataSize = Math.min(emaLongData.size(), emaShortData.size());

        // Проверяем последние значения EMA 5 и EMA 21
        double emaLongValue = emaLongData.get(dataSize - 1);
        double emaShortValue = emaShortData.get(dataSize - 1);

        if(emaShortValue > emaLongValue){
            return "EMA 5 выше EMA 21. Восходящий тренд";
        }else if(emaShortValue < emaLongValue){
            return "EMA 5 ниже EMA 21. Нисходящий тренд";
        }else{
            return "EMA 5 равны EMA 21.";
        }
    }


}
