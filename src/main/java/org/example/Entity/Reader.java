package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Entity
    @Table(name = "readers")
    @Setter
    @Getter
    @NoArgsConstructor
    public class Reader {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reader gen")
        @SequenceGenerator(
                name = "reader gen",
                sequenceName = "publisher seq",
                allocationSize = 1
        )
        private Long id;
        private String name;
        private int age;

        public Reader(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "\nReader{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
