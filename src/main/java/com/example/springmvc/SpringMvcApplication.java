package com.example.springmvc;
import com.example.springmvc.entities.Patient;
import com.example.springmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"hajar", new Date(),false, 27));
            patientRepository.save(new Patient(null,"meriem", new Date(),false, 30));
            patientRepository.save(new Patient(null,"nassim", new Date(),false, 39));
            patientRepository.save(new Patient(null,"amina", new Date(),false, 40));
            patientRepository.findAll().forEach(p->{
                System.out.println("Name = " + p.getNom());
            });
        };
    }
}
