// Device class (Superclass)
class Device {
    // Attributes for devices
    protected String deviceId;
    protected String status;

    // Constructor for Device
    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display device status
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Thermostat class (Subclass)
class Thermostat extends Device {
    // Attribute for Thermostat
    private double temperatureSetting;

    // Constructor for Thermostat
    public Thermostat(String deviceId, String status, double temperatureSetting) {
        // Call the superclass constructor
        super(deviceId, status); 
        this.temperatureSetting = temperatureSetting;
    }

    // Overriding displayStatus to include temperature setting
    @Override
    public void displayStatus() {
        // Call superclass method
        super.displayStatus(); 
        System.out.println("Temperature Setting: " + temperatureSetting + " °C");
    }

    // Method to update the temperature setting
    public void setTemperature(double temperature) {
        this.temperatureSetting = temperature;
        System.out.println("Temperature updated to: " + temperatureSetting + " °C");
    }
}

// Main class
class SmartHomeSystem {
    public static void main(String[] args) {
        // Create a Thermostat object
        Thermostat thermostat = new Thermostat("TH123", "Online", 22.5);

        // Display initial status
        System.out.println("Initial Status:");
        thermostat.displayStatus();

        // Update the temperature setting
        System.out.println("\nUpdating temperature...");
        thermostat.setTemperature(24.0);

        // Display updated status
        System.out.println("\nUpdated Status:");
        thermostat.displayStatus();
    }
}

