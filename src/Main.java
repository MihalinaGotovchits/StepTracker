import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int command = scanner.nextInt();

            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                System.out.println("Введите цель по количеству шагов за день.");
                stepTracker.changeStepGoal(scanner.nextInt());
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 4) {
                System.out.println("Выход");
                break;
            }else {
                System.out.println("Такой команды нет. Пожалуйста, повторите попытку.");
                System.out.println();
            }
        }
    }

    static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Напечатать статистику за определенный месяц");
        System.out.println("4 - Выйти из приложения");
    }
}