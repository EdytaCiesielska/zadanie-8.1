package pl.devopsi.akademia.medclinic;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor


public class PatientController {

    private final PatientService patientService;

    @PostMapping("/patients")
    public ResponseEntity<Void> registerPatient(@RequestBody @Valid Patient patient) {
        this.patientService.registerPatient(patient);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/patients/{personalID}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String personalID, @RequestBody Patient patient) {
        this.patientService.updatePatient(personalID, patient);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(patient);
    }

    @DeleteMapping("/patients/{personalID}")
    public ResponseEntity<Void> deletePatient(@PathVariable String personalID) {
        this.patientService.deletePatient(personalID);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getPatients() {
        List<Patient> patients = this.patientService.getPatients();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(patients);
    }
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> allPatients = this.patientService.getAllPatients();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allPatients);
    }


}

