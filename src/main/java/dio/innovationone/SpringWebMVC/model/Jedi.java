package dio.innovationone.SpringWebMVC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Jedi {

    @NotBlank
    private String name;

    @NotBlank
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
