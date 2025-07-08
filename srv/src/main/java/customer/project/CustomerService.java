// package customer.project;

// public class CustomerService {
    
// }
package customer.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return repository.findById(id);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer updated) {
        return repository.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setEmail(updated.getEmail());
            existing.setLocation(updated.getLocation());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
