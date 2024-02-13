package com.ghobber.cutomerservice.repositories;

import com.ghobber.cutomerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource :annotation de spring data rest permet de demarrer automatiquement
// un web service restful qui permet de gerer les customers
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
