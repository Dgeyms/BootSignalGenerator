package org.boottrading.service.indicators;

import java.util.ArrayList;
import java.util.List;

public class KDJIndicator {

        private final double N = 9;
        private final double MA1 = 3;
        private final double MA2 = 3;

        private final List<Double> closePrices;
        private final List<Double> kValues;
        private final List<Double> dValues;
        private final List<Double> jValues;

        public KDJIndicator(List<Double> closePrices) {
            this.closePrices = closePrices;
            this.kValues = new ArrayList<>();
            this.dValues = new ArrayList<>();
            this.jValues = new ArrayList<>();

            calculate();
        }

        private void calculate() {
            // Инициализация
            double maxPrice = Double.MIN_VALUE;
            double minPrice = Double.MAX_VALUE;
            for (double closePrice : closePrices) {
                maxPrice = Math.max(maxPrice, closePrice);
                minPrice = Math.min(minPrice, closePrice);
            }

            // Расчет K
            for (int i = 0; i < closePrices.size(); i++) {
                double k = (closePrices.get(i) - minPrice) / (maxPrice - minPrice) * 100;
                kValues.add(k);
            }

            // Расчет D
            for (int i = 3; i < closePrices.size(); i++) {
                dValues.add(3 * kValues.get(i - 1) - 2 * kValues.get(i - 2) + kValues.get(i - 3));
            }

            // Расчет J
            for (int i = 3; i < closePrices.size(); i++) {
                jValues.add(3 * kValues.get(i) - 3 * dValues.get(i - 1) + kValues.get(i - 2));
            }
        }

        public List<Double> getKValues() {
            return kValues;
        }

        public List<Double> getDValues() {
            return dValues;
        }

        public List<Double> getJValues() {
            return jValues;
        }


}
