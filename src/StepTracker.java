import java.util.Scanner;

public class StepTracker {
    private int monthNumber;
    int goalByStepsPerDay = 10000;
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();

    StepTracker(Scanner scan){
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {//метод, для ввода пройденных шагов в день
        System.out.println("Введите номер месяца.");
        monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Введено некорректное значение месяца.");
            System.out.println();
            return;
        }

        System.out.println("Введите день от 1 до 30 включительно.");
        int dayNumber = scanner.nextInt();
        if (dayNumber < 1 || dayNumber > 30) {
            System.out.println("Введено некорректное значение дня.");
            System.out.println();
            return;
        }

        System.out.println("Введите количество шагов.");
        int stepsNumber = scanner.nextInt();
        if (stepsNumber < 0) {
            System.out.println("Вводимое число должно быть положительным.");
            System.out.println();
            return;
        }

        MonthData monthData = monthToData[monthNumber - 1];
        monthData.days[dayNumber - 1] = stepsNumber;
        System.out.println();
        }

    void changeStepGoal(int stepGoal) {//метод для изменения цели по количеству шагов в день
        if (stepGoal <= 0){
            System.out.println("Вводимое значение должно быть положительным.");
        }
        else {
            goalByStepsPerDay = stepGoal;
        }
        System.out.println();
    }

    void printStatistic() {//метод, выводящий статистику за конкретный месяц
        System.out.println("Введите номер месяца");
        monthNumber = scanner.nextInt();

        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Введен некорректный номер месяца.");
            System.out.println();
        } else {
            int sumSteps = monthToData[monthNumber - 1].sumStepsFromMonth();

            System.out.println("Количество пройденных шагов подням:");
            monthToData[monthNumber - 1].printDaysAndStepsFromMonth();

            System.out.println("Общее количество шагов за месяц: " + sumSteps);

            System.out.println("Максимальное количество шагов в месяце: " + monthToData[monthNumber - 1].maxSteps());

            System.out.println("Среднее количество шагов за месяц: " + sumSteps / 31);

            System.out.println("Пройденная дистанция в километрах: " + converter.convertToKm(sumSteps));

            System.out.println("Количество сожженых килокалорий: " + converter.convertStepsToKilocalories(sumSteps));

            System.out.println("Лучшая серия: " + monthToData[monthNumber - 1].bestSeries(goalByStepsPerDay));
            System.out.println();
        }
    }
}
