package com.example.onetoone;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class App implements CommandLineRunner {
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Address address =  Address.builder().address("Thanh Hoa").build();



        Person person1 = Person.builder().firstName("Le").lastName("Quan").address(address).build();

        Person person2 = Person.builder().firstName("Le").lastName("Minh").address(address).build();


        addressRepository.save(address);


    }
}
