// Create Patient class to check if a object is an instance of patient
public class Patient {
    // Static variable for the hospital name
    private static String hospitalName = "City Hospital";

    // Static variable to track the total number of patients
    private static int totalPatients = 0;

    // Final variable for the patient ID
    private final int patientID;

    // Instance variables for the patient's name, age, and ailment
    private String name;
    private int age;
    private String ailment;

    // Parameterized constructor to initialize patient details
    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment; `
        totalPatients++;
    }

    // Method to get the total number of patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Method to set the hospital name
    public static void setHospitalName(String name) {
        hospitalName = name;
    }

    // Method to display patient details
    public void displayPatientDetails() {
        if (this instanceof Patient) { // Check if the object is an instance of Patient
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.out.println("Invalid patient object.");
        }
    }

    public static void main(String[] args) {
        // Set a custom hospital name
        Patient.setHospitalName("Bansal Hospital");

        // Create patient objects
        Patient patient1 = new Patient(101, "Alice", 30, "Fever");
        Patient patient2 = new Patient(102, "Bob", 45, "Cold");

        // Display patient details
        patient1.displayPatientDetails();
        System.out.println();
        patient2.displayPatientDetails();

        // Display the total number of patients
        System.out.println();
        Patient.getTotalPatients();
    }
}