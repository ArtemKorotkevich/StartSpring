package by.andersen.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@DiscriminatorValue(value = "Role")
public class Role extends Dictionary{

    @Column(name = "ext-id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int ext_id;

    public Role(String name) {
        super(name);
    }

    public Role() {
    }
}
