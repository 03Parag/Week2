// Patient (Abstract Class)
abstract class Patient {
    // Attributes for Patient
    private int patientId;
    private String name;
    private int age;

    // Constructor for Patient
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Get the patient ID
    public int getPatientId() {
        return patientId;
    }

    // Get the patient name
    public String getName() {
        return name;
    }

    // Get the patient age
    public int getAge() {
        return age;
    }

    // Method to display patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Method to calculate the bill
    public abstract double calculateBill();
}

// InPatient (Subclass)
class InPatient extends Patient {
    // Attributes for InPatient
    private int numberOfDays;
    private double dailyRoomCharge;
    private double treatmentCharge;

    // Constructor for InPatient
    public InPatient(int patientId, String name, int age, int numberOfDays, double dailyRoomCharge, double treatmentCharge) {
        // Call the abstract class constructor
        super(patientId, name, age);
        this.numberOfDays = numberOfDays;
        this.dailyRoomCharge = dailyRoomCharge;
        this.treatmentCharge = treatmentCharge;
    }

    // Overriding calculateBill() method
    @Override
    public double calculateBill() {
        return (numberOfDays * dailyRoomCharge) + treatmentCharge;
    }

    // Get details of InPatient
    public void getInPatientDetails() {
        getPatientDetails();
        System.out.println("Number of Days: " + numberOfDays);
        System.out.println("Daily Room Charge: " + dailyRoomCharge);
        System.out.println("Treatment Charge: " + treatmentCharge);
    }
}

// OutPatient (Subclass)
class OutPatient extends Patient {
    // Attributes for OutPatient
    private double consultationFee;
    private double diagnosticFee;

    // Constructor for OutPatient
    public OutPatient(int patientId, String name, int age, double consultationFee, double diagnosticFee) {
        // Call the abstract class constructor
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.diagnosticFee = diagnosticFee;
    }

    // Overriding calculateBill() method
    @Override
    public double calculateBill() {
        return consultationFee + diagnosticFee;
    }

    // Get details for OutPatient
    public void getOutPatientDetails() {
        getPatientDetails();
        System.out.println("Consultation Fee: " + consultationFee);
        System.out.println("Diagnostic Fee: " + diagnosticFee);
    }
}

// MedicalRecord (Interface )
interface MedicalRecord {
    // Method to add a medical record
    void addRecord(String record);

    // Method to view medical records
    void viewRecords();
}

// AllPatient class
class AllPatient implements MedicalRecord {
    // Attributes for all patient
    private InPatient inPatient;
    private OutPatient outPatient;
    private String medicalHistory;

    // Constructor for InPatient
    public AllPatient(InPatient inPatient) {
        this.inPatient = inPatient;
        // Initialize as an empty string
        this.medicalHistory = "";
    }

    // Constructor for OutPatient
    public AllPatient(OutPatient outPatient) {
        this.outPatient = outPatient;
        // Initialize as an empty string
        this.medicalHistory = "";
    }

    // Overriding to add a medical record
    @Override
    public void addRecord(String record) {
        if (!medicalHistory.isEmpty()) {
            // Add a separator for multiple records
            medicalHistory += "; ";
        }
        medicalHistory += record;
    }

    // Overriding to view all medical records
    @Override
    public void viewRecords() {
        System.out.println("Medical History:");
        System.out.println(medicalHistory.isEmpty() ? "No records available" : medicalHistory);
    }

    // Display patient details
    public void displayPatientDetails() {
        if (inPatient != null) {
            inPatient.getInPatientDetails();
            System.out.println("Total Bill: " + inPatient.calculateBill());
        } else if (outPatient != null) {
            outPatient.getOutPatientDetails();
            System.out.println("Total Bill: " + outPatient.calculateBill());
        }
    }
}

// Main Class
class HospitalManagementSystem {
    public static void main(String[] args) {
        // Create InPatient and OutPatient objects
        InPatient inPatient = new InPatient(101, "Alice", 45, 5, 2000.0, 5000.0);
        OutPatient outPatient = new OutPatient(102, "Bob", 32, 500.0, 1500.0);

        // Create AllPatient objects for both patients
        AllPatient inPatientRecord = new AllPatient(inPatient);
        AllPatient outPatientRecord = new AllPatient(outPatient);

        // Add medical history records
        inPatientRecord.addRecord("Admitted on 2023-01-10");
        inPatientRecord.addRecord("Discharged on 2023-01-15");
        outPatientRecord.addRecord("Visited on 2023-01-20");

        // Display details and bills for all patients
        System.out.println("InPatient Details:");
        inPatientRecord.displayPatientDetails();
        inPatientRecord.viewRecords();

        System.out.println("\nOutPatient Details:");
        outPatientRecord.displayPatientDetails();
        outPatientRecord.viewRecords();
    }
}

