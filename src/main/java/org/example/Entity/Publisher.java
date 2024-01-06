package org.example.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "publishers")
@Setter
@Getter
@NoArgsConstructor
public class Publisher { // Bi direction
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "publisher gen")
    @SequenceGenerator(
            name = "publisher gen",
            sequenceName = "publisher seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String address;


    @OneToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,//save
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                     CascadeType.REMOVE,
                    CascadeType.REFRESH
            })
    private List<Author> authors;
    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nPublisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", authors=" + authors +
                '}';
    }
}


