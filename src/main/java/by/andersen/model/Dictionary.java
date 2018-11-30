package by.andersen.model;

import javax.persistence.*;

@Entity
@Table(name = "dictionary")
@Inheritance
@DiscriminatorColumn(name ="discriminator", discriminatorType = DiscriminatorType.STRING)
public abstract class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private  String name;

    public Dictionary( String name){
        this.name = name;
    }

    public Dictionary(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
