// package customer.project;

// public class CustomerRepository {
    
// }
package customer.project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
