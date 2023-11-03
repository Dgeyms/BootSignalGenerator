package org.boottrading;


import org.boottrading.service.EMA;
import org.boottrading.service.GeneratorData;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GeneratorData generatorData = new GeneratorData();
        ArrayList<Double> quoteDataList = generatorData.generateData();

        EMA ema = new EMA(quoteDataList);
    }
}

