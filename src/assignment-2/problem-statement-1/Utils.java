public class Utils {
    int integer;
    double decimal;
    String text;

    public void sum(int firstValue, int secondValue) {
        int sum = firstValue + secondValue;
        System.out.println("Result: " + sum);
    }

    public void convertToUpperCase(String inputString) {
        text = inputString.toUpperCase();
        System.out.println("Updated String: " + text);
    }
}