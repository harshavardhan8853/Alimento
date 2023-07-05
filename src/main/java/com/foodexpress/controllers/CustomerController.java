package com.foodexpress.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import springboot.emp.exception.ResourceNotFoundException;
import springboot.emp.model.Employee;

@RestController
@RequestMapping("/api/f1")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(customer);
	}

	@PostMapping("/customer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
			@Valid @RequestBody Customer employeeDetails) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + employeeId));

		customer.setEmailId(customerDetails.getEmailId());
		customer.setLastName(customerDetails.getLastName());
		customer.setFirstName(ecustomerDetails.getFirstName());
		customer.setAddress(customerDetails.getAddress());
		customer.setContact(customerDetails.getContact());
		final Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
