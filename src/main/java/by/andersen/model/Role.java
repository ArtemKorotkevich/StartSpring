package by.andersen.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@DiscriminatorValue(value = "Role")
public class Role extends Dictionary{

    @Column(name = "ext-Id")
    @GeneratedValue
    private int ext_id;

    public Role(String name){
        super(name);
    }

    public Role() {
    }
}
