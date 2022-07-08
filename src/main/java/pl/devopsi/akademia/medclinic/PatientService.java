package pl.devopsi.akademia.medclinic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {

    private final Map<String, Patient> patients;
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        this.patients = new HashMap<>();
    }

    public void registerPatient(Patient patient) {
        if (!this.patients.containsKey(patient.getPersonalID())) {
            this.patients.put(patient.getPersonalID(), patient);

            patientRepository.save(patient);
        }
    }

    public void updatePatient(String personalID, Patient patient) {
        if (this.patients.containsKey(personalID)) {
            this.patients.put(personalID, patient);
        }

        if (patientRepository.existsById(personalID)){
            Patient changedPatient = patientRepository.findById(personalID).get();
            changedPatient.setFirstName(patient.getFirstName());
            changedPatient.setLastName(patient.getLastName());
            changedPatient.setMobilePhone(patient.getMobilePhone());
            changedPatient.setNote(patient.getNote());
            patientRepository.save(changedPatient);
        }
        }

    public void deletePatient(String personalID) {
        this.patients.remove(personalID);
        patientRepository.deleteById(personalID);
    }

    public List<Patient> getPatients() {
        List<Patient> tmpPatients = new ArrayList<>();
        for (String personalID : this.patients.keySet()) {
            tmpPatients.add(this.patients.get(personalID));
        }
       return tmpPatients;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

}
