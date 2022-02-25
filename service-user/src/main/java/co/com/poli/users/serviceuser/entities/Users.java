package co.com.poli.users.serviceuser.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;
    @NotEmpty(message = "El nombre no debe estar vacio")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "El segundo nombre no debe estar vacio")
    @Column(name = "last_name")
    private String lastName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
