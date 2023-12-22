import java.util.HashMap;
import java.util.Map;

public class DeviceFactory {
    private static final Map<DeviceType, Device> devices = new HashMap<>();

    static {
        devices.put(DeviceType.SMARTPHONE, new Smartphone());
        devices.put(DeviceType.LAPTOP, new Laptop());
    }

    public static Device createDevice(DeviceType deviceType) {
        Device device = devices.get(deviceType);
        if (device == null) {
            throw new IllegalArgumentException("Invalid device type: " + deviceType);
        }
        return device;
    }
}
