package com.ghobber.accountservice.web;

import com.ghobber.accountservice.clients.CustomerRestClient;
import com.ghobber.accountservice.entities.BankAccount;
import com.ghobber.accountservice.model.Customer;
import com.ghobber.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public BankAccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList() {

        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach(a->{
            a.setCustomer(customerRestClient.findCustomerById(a.getCustomerId()));
        });
        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id) {
        BankAccount bankAccount= bankAccountRepository.findById(id).orElseThrow();
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
