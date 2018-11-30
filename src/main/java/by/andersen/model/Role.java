package by.andersen.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@DiscriminatorValue(value = "role")
public class Role extends Dictionary{

    @Column(name = "ext_Id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer ext_Id;

    public Role(String name) {
        super(name);
    }

    public Role() {
    }
}
