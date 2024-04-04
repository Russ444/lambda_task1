import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> y == 0 ? devideByZero() : x / y;

    /* Лямбда-выражение выше создает объект devide типа BinaryOperator<Integer>,
     * который принимает два аргумента <Integer> и выполняет операцию деления
     * В случае, указанном в классе Main, создается ситуация деления на ноль, что,
     * в свою очередь, приводит к ошибке ArithmeticException.
     * Для решения указанной проблемы и обработки исключения реализован метод devideByZero(),
     * при создании объекта devide используется ссылка на указанный метод, если знаменатель равен 0*/

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;

    private static Integer devideByZero() {
        throw new IllegalArgumentException("Ошибка! Деление на ноль невозможно!");
    }
}
