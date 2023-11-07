package org.boottrading;


import org.boottrading.model.ARB;
import org.boottrading.service.EMACalculator;
import org.boottrading.service.GeneratorData;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GeneratorData generatorData = new GeneratorData();
        //ArrayList<Double> quoteDataListARB = generatorData.generateData();
        ARB tokenARB = new ARB(generatorData.generateData(),"ARB");
        EMACalculator emaCalculatorShortARB = new EMACalculator(tokenARB.quoteDataList, 5);
        ArrayList<Double> emaShortARB = emaCalculatorShortARB.calculateEMA();
        System.out.println("--------------------------------");
        for(int x = 0; x < emaShortARB.size(); x++ ){
            double shortARB = emaShortARB.get(x);
            System.out.println("EMA_5 " +  (x + 1) + "день " +  String.format(" %.2f", shortARB));
        }
        EMACalculator emaCalculatorLongARB = new EMACalculator(tokenARB.quoteDataList, 21);
        ArrayList<Double> emaLongARB = emaCalculatorLongARB.calculateEMA();
        for(int x = 0; x < emaLongARB.size(); x++ ){
            double longARB = emaLongARB.get(x);
            System.out.println("EMA_21 " +  (x + 1) + "день " +  String.format(" %.2f", longARB));
        }
    }
}

