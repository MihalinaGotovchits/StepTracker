public class Converter {
    private static final int oneStep = 75;
    private static final int oneKiloCalorie = 1000;

    int convertToKm(int steps){//метод, конвертирующий шаги в километны
        return (steps * oneStep) / 100000;
    }

    int convertStepsToKilocalories(int steps){//метод, конвертирующий шаги в килокаллории
        return (steps * 50) / oneKiloCalorie;
    }
}
