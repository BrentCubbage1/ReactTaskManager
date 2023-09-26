package Task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//lombok maven dependency imported in pom.xml
//Creates the getters, setters and constructors
// automagically based off the annotations.
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String title;

    private String description;

    private enum status {
        NOTSTARTED,
        INPROGRESS,
        PAUSED,
        COMPLETED;
    }



}
