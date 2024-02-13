package com.ghobber.cutomerservice;

import com.ghobber.cutomerservice.config.GlobalConfig;
import com.ghobber.cutomerservice.entities.Customer;
import com.ghobber.cutomerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CutomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CutomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customerList = List.of(

                    Customer.builder()
                            .firstname("maryem")
                            .lastname("ghobber")
                            .email("maryem@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstname("ghassen")
                            .lastname("ghobber")
                            .email("maryem@gmail.com")
                            .build()
            );

            customerRepository.saveAll(customerList);
        };
    }
}
