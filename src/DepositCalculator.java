import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, int period) {
        double pay = amount * Math.pow((1 + 0.06 / 12), 12 * period);
        return round(pay);
    }

    double calculateSimplePercent(double amount, int period) {
        return round(amount + amount * 0.06 * period);
    }

    double round(double value) {
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }

    void getPercentageOfDeposit( ) {
        int period;
        int action;
        int amount;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double totalAmount = 0;
        if (action ==1) {
            totalAmount = calculateSimplePercent(amount, period);
        } else if (action == 2){
            totalAmount = calculateComplexPercent(amount, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().getPercentageOfDeposit();
    }
}
