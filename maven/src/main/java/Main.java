import calculator.Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Создание сканера для ввода с консоли
        Scanner in = new Scanner(System.in);
        // Создание объекта калькулятора
        Calculator calculator = new Calculator();

        // Цикл для бексонечной работы калькулятора
        while (true) {

            // Распечатка инструкции ввода выражения
            System.out.println("Введите первое число, операцию которую надо выполнить, и второе число:");

            // Сканер для ввода
            calculator.setNumericExpression(in.nextLine());

            // Выполнение операции
            calculator.performOperation();

            // Распечатка результата
            System.out.println(calculator);
        }
    }
}
