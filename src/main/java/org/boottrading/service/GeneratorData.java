package org.boottrading.service;

import java.util.ArrayList;
import java.util.Random;

public class GeneratorData {
    private double initialPrice = 10; // Начальная цена акции
    private final double volatility = 2; //Волатильность (стандартное отклонение)
    private final int numberDataGenerates = 50; // Сколько данных сгенерировать


    // Method for generating exchange data
    public ArrayList<Double> generateData() {
        return resultGenerateData();
    }

    private ArrayList<Double> resultGenerateData(){
        Random random = new Random();
        ArrayList<Double> listGeneratesData = new ArrayList<>();
        System.out.println("-------Quote kripto--------");

        for (int x = 0; x < numberDataGenerates; x++) {
            listGeneratesData.add(initialPrice);
            System.out.println("День " + (x + 1) + ": " + String.format("%.2f", initialPrice));

            double generatePrise = (random.nextDouble() - 0.5) * 2.0 * volatility;
            initialPrice += generatePrise;
            if (initialPrice < 0){
                initialPrice += 1;
            }

        }
        return listGeneratesData;
    }
}
