package com.one;

import com.one.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("Countries containing 'ou'");
        countryRepository.findByNameContaining("ou")
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Countries containing 'ou' (Ascending)");
        countryRepository.findByNameContainingOrderByNameAsc("ou")
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Countries starting with Z");
        countryRepository.findByNameStartingWith("Z")
                .forEach(System.out::println);
    }
}