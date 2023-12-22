public class Main {
    public static void main(String[] args) {
        Device smartphone = DeviceFactory.createDevice(DeviceType.SMARTPHONE);
        Device laptop = DeviceFactory.createDevice(DeviceType.LAPTOP);
        smartphone.displayDetails();
        laptop.displayDetails();
    }
}