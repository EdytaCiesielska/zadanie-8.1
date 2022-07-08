package pl.devopsi.akademia.medclinic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@Entity

public class Patient {

   @NotEmpty
   @Size(min = 11, max = 11)
   @Id
   private String personalID;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    private String mobilePhone;
    private String note;

    public Patient() {
    }
}
