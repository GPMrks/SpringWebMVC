package dio.innovationone.SpringWebMVC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Jedi {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "User's name cannot be empty.")
    @Size(min = 3, max = 20, message = "Name must have between 3 and 20 letters")
    private String name;

    @Column(name = "lastName")
    @NotBlank(message = "User's last name cannot be empty.")
    @Size(min = 3, max = 20, message = "Last Name must not have more than 20 letters")
    private String lastName;

    //Lombok @Data, @NoArgsConstructor e @AllArgsContructor simplifica toda essa construção

//    public Jedi (final String name, final String lastName) {
//        this.name = name;
//        this.lastName = lastName;
//    }
//
//    public Jedi () {
//
//    }
//
//    public String getName () {
//        return name;
//    }
//
//    public void setName (final String name) {
//        this.name = name;
//    }
//
//    public String getLastName () {
//        return lastName;
//    }
//
//    public void setLastName (final String lastName) {
//        this.lastName = lastName;
//    }

}
