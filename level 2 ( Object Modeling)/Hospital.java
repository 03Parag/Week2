import java.util.ArrayList;
import java.util.List;

// Hospital class 
class Hospital {
    // Attributes of hospital
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    // Constructor to initialize the hospital 
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Get the hospital name
    public String getHospitalName() {
        return hospitalName;
    }

    // Get the list of doctors
    public List<Doctor> getDoctors() {
        return doctors;
    }

    // Get the list of patients
    public List<Patient> getPatients() {
        return patients;
    }

    // Add a doctor to the hospital
    public void addDoctor(String doctorName) {
        doctors.add(new Doctor(doctorName));
    }

    // Add a patient to the hospital
    public void addPatient(String patientName) {
        patients.add(new Patient(patientName));
    }

    // Doctor class
    class Doctor {
        // Attributes of doctor
        private String doctorName;
        // Association with Patient
        private List<Patient> patients; 

        // Constructor to initialize the doctor  
        public Doctor(String doctorName) {
            this.doctorName = doctorName;
            this.patients = new ArrayList<>();
        }

        // Get the doctor name 
        public String getDoctorName() {
            return doctorName;
        }

        // Get the list of patients 
        public List<Patient> getPatients() {
            return patients;
        }

        // Method for consultation
        public void consult(Patient patient) {
            if (!patients.contains(patient)) {
                patients.add(patient);
                // Establish mutual relationship
                patient.addDoctor(this); 
            }
            System.out.println("Doctor " + doctorName + " is consulting with Patient " + patient.getPatientName());
        }
    }

    // Patient class
    class Patient {
        // Attributes of patient 
        private String patientName;
        // Association with Doctor
        private List<Doctor> doctors; 

        // Constructor to initialize the patient
        public Patient(String patientName) {
            this.patientName = patientName;
            this.doctors = new ArrayList<>();
        }

        // Get the patient name
        public String getPatientName() {
            return patientName;
        }

        // Get the list of doctors
        public List<Doctor> getDoctors() {
            return doctors;
        }

        // Add a doctor to the patient's list
        public void addDoctor(Doctor doctor) {
            if (!doctors.contains(doctor)) {
                doctors.add(doctor);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Create a hospital
        Hospital hospital = new Hospital("City Hospital");

        // Add doctors to the hospital
        hospital.addDoctor("Dr. Smith");
        hospital.addDoctor("Dr. John");

        // Add patients to the hospital
        hospital.addPatient("Alice");
        hospital.addPatient("Bob");

        // Access doctors and patients
        Hospital.Doctor doctor1 = hospital.getDoctors().get(0);
        Hospital.Doctor doctor2 = hospital.getDoctors().get(1);
        Hospital.Patient patient1 = hospital.getPatients().get(0);
        Hospital.Patient patient2 = hospital.getPatients().get(1);

        // Simulate consultations
        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);

        // Show doctor-patient relationships
        System.out.println("\nDoctor-Patient relationships:");
        for (Hospital.Doctor doctor : hospital.getDoctors()) {
            System.out.println("Doctor: " + doctor.getDoctorName());
            for (Hospital.Patient patient : doctor.getPatients()) {
                System.out.println("  - Consulted with: " + patient.getPatientName());
            }
        }

        // Show patient-doctor relationships
        System.out.println("\nPatient-Doctor relationships:");
        for (Hospital.Patient patient : hospital.getPatients()) {
            System.out.println("Patient: " + patient.getPatientName());
            for (Hospital.Doctor doctor : patient.getDoctors()) {
                System.out.println("  - Consulted by: " + doctor.getDoctorName());
            }
        }
    }
}
