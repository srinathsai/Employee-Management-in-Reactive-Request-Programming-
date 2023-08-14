package Spring.reactive.springboot.webflux.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="employees") //similar to @Entity meaning it is object relational mapping class for monogodb.
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
