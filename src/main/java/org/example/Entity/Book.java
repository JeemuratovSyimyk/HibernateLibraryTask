package org.example.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Enum.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

    @Entity
    @Table(name = "books")
    @Setter
    @Getter
    @NoArgsConstructor
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book gen")
        @SequenceGenerator(
                name = "book gen",
                sequenceName = "book seq",
                allocationSize = 1
        )
        private Long id;
        private String name;
        private String country;
        private LocalDate published_year;
        private BigDecimal price;
        private Genre genre;

        @ManyToOne(
                cascade = {
                        CascadeType.PERSIST,
                        CascadeType.MERGE,
                        CascadeType.DETACH,
                        // CascadeType.REMOVE,
                        CascadeType.REFRESH

                })
        private Author author;

        @ManyToOne(
                cascade = {
                        CascadeType.PERSIST,
                        CascadeType.MERGE,
                        CascadeType.DETACH,
                        CascadeType.REMOVE,
                        CascadeType.REFRESH

                })
        private Publisher publisher;
        public Book(String name, String country, LocalDate published_year, BigDecimal price, Genre genre) {
            this.name = name;
            this.country = country;
            this.published_year = published_year;
            this.price = price;
            this.genre = genre;
        }

        @Override
        public String toString() {
            return "\nBook{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", country='" + country + '\'' +
                    ", published_year=" + published_year +
                    ", price=" + price +
                    ", genre=" + genre +
                    '}';
        }
    }
