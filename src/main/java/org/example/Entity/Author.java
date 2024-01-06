package org.example.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Enum.Gender;

import java.time.LocalDate;
import java.util.List;
    @Entity
    @Table(name = "authors")
    @Setter
    @Getter
    @NoArgsConstructor
    public class Author { // Bi direction
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author gen")
        @SequenceGenerator(
                name = "author gen",
                sequenceName = "author seq",
                allocationSize = 1
        )
        private Long id;
        @Column(name = "First_Name")
        private String firstName;
        @Column(name = "Last_Name")
        private String lastName;
        @Column(unique = true)
        private String email;
        private LocalDate date_of_birth;
        private String country;
        private Gender gender;

        @OneToMany(mappedBy = "author",
                cascade = {
                        CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.PERSIST,
                        CascadeType.REFRESH,
                        CascadeType.REMOVE
                })

        private List<Book> books;
        @ManyToOne
        @JoinColumn(name = "publisher_id")
        private Publisher publisher;

        public Author(String firstName, String lastName, String email, LocalDate date_of_birth, String country, Gender gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.date_of_birth = date_of_birth;
            this.country = country;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "\nAuthor{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", date_of_birth=" + date_of_birth +
                    ", country='" + country + '\'' +
                    ", gender=" + gender +
                    '}';
        }

        public List<Publisher> getPublishers() {
            return null;
        }

        public void setPublishers(List<Publisher> publishers) {
        }
    }
