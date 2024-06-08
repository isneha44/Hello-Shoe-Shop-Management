package lk.ijse.helloshoeshopmanagement.repo;


import lk.ijse.helloshoeshopmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = "SELECT code FROM customer ORDER BY code DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT COUNT(code) FROM customer", nativeQuery = true)
    int getCustomerCount();

    @Query(value = "SELECT * FROM customer e WHERE e.code = :code OR e.name = :name", nativeQuery = true)
    Customer findCustomerByCodeOrName(@Param("code") String code, @Param("name") String name);

}
