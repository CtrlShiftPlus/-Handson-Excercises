public class App {

    interface CustomerRepository {
        String findCustomerById(int id);
    }

    static class CustomerRepositoryImpl implements CustomerRepository {
        public String findCustomerById(int id) {
            if (id == 1) return "Rahul - Bangalore";
            if (id == 2) return "Amit - Mysore";
            return "Customer not found";
        }
    }

    static class CustomerService {
        private CustomerRepository repository;

        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public void getCustomer(int id) {
            String customer = repository.findCustomerById(id);
            System.out.println(customer);
        }
    }

    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        service.getCustomer(1);
        service.getCustomer(2);
        service.getCustomer(5);
    }
}