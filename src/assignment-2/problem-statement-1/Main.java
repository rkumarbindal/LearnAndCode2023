public class Main {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.integer = 10;
        utils.decimal = 20.5;
        utils.text = "hello";

        utils.sum(utils.integer, 5);
        utils.convertToUpperCase("world");
    }
}
