public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth(){// метод, выводящий количество шагов по днямза конкретный месяц
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " День: " + days[i]);
        }
    }

    int sumStepsFromMonth(){//метод, подсчитывающий сумму шагов за месяц
        int sumStepsOfMonth = 0;
        for (int i = 0; i < days.length; i++) {
            sumStepsOfMonth += days[i];
        }
        return sumStepsOfMonth;
    }

    int maxSteps(){//метод, находящий максимальное количество шагов в месяце
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps){
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay){//метод с поиском максимальной серии
        int currentSeries = 0;
        int finalSeries = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            }
            else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}
