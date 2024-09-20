// Smart Home System Example

// Abstract class for smart home devices
abstract class SmartDevice {
    protected String name;

    public SmartDevice(String name) {
        this.name = name;
    }

    // Abstract method to turn the device on
    public abstract void turnOn();

    // Abstract method to turn the device off
    public abstract void turnOff();

    // Abstract method to check if the device is on
    protected abstract boolean isOn();

    // Concrete method to display device status
    public void displayStatus() {
        System.out.println(name + " is currently " + (isOn() ? "ON" : "OFF"));
    }
}

// Interface for controllable devices
interface Controllable {
    void setBrightness(int level);
    void setTemperature(double temp);
}

// Concrete class for a smart light
class SmartLight extends SmartDevice implements Controllable {
    private int brightness;
    private boolean on;



    public SmartLight(String name) {
        super(name);
        this.brightness = 0;
        this.on = false;
    }

    @Override
    public void setTemperature(double temp) {
        // Empty implementation or throw an exception
        throw new UnsupportedOperationException("SmartLight does not support temperature control");
    }

    @Override
    public void turnOn() {
        on = true;
        System.out.println(name + " light is now ON");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println(name + " light is now OFF");
    }

    @Override
    public void setBrightness(int level) {
        brightness = level;
        System.out.println(name + " light brightness set to " + brightness);
    }
    
    @Override
    protected boolean isOn() {
        return on;
    }
}

// Concrete class for a smart thermostat
class SmartThermostat extends SmartDevice implements Controllable {
    private double temperature;
    private boolean on;

    public SmartThermostat(String name) {
        super(name);
        this.temperature = 22.0; // Default temperature
        this.on = false;
    }

    @Override
    public void setBrightness(int level) {
        throw new UnsupportedOperationException("SmartThermostat does not support brightness control");
    }

    @Override
    public void turnOn() {
        on = true;
        System.out.println(name + " thermostat is now ON");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println(name + " thermostat is now OFF");
    }

    @Override
    public void setTemperature(double temp) {
        temperature = temp;
        System.out.println(name + " thermostat temperature set to " + temperature + "°C");
    }

    @Override
    protected boolean isOn() {
        return on;
    }
    
}

// Enum for device actions
enum DeviceAction {
    ON, OFF
}

// Interface for user control
interface UserControl {
    void controlDevice(SmartDevice device, DeviceAction action);
}

// Concrete class for controlling smart devices
class SmartHomeController implements UserControl {
    @Override
    public void controlDevice(SmartDevice device, DeviceAction action) {
        switch (action) {
            case ON:
                device.turnOn();
                break;
            case OFF:
                device.turnOff();
                break;
            default:
                System.out.println("Invalid action: " + action);
                break;
        }
        device.displayStatus();
    }
}

// Main class to demonstrate the new logic
public class AbstractInterfaceExample {
    public static void main(String[] args) {
        // Create smart devices
        SmartLight livingRoomLight = new SmartLight("Living Room Light");
        SmartThermostat homeThermostat = new SmartThermostat("Home Thermostat");

        // Create a smart home controller
        SmartHomeController controller = new SmartHomeController();

        // Control devices
        System.out.println("Controlling Devices:");
        controller.controlDevice(livingRoomLight, DeviceAction.ON);
        livingRoomLight.setBrightness(75);
        controller.controlDevice(livingRoomLight, DeviceAction.OFF);
        
        System.out.println();

        controller.controlDevice(homeThermostat, DeviceAction.ON);
        homeThermostat.setTemperature(20.5);
        controller.controlDevice(homeThermostat, DeviceAction.OFF);
    }
}
