package lk.ijse.helloshoeshopmanagement.repo;


import lk.ijse.helloshoeshopmanagement.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SupplierRepo extends JpaRepository <Supplier,String>{
    @Query(value = "SELECT code FROM supplier ORDER BY code DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT COUNT(code) FROM supplier", nativeQuery = true)
    int getSumEmployee();

    @Query(value = "SELECT * FROM supplier e WHERE e.code = :code OR e.name = :name", nativeQuery = true)
    Supplier findSupplierByCodeOrName(@Param("code") String code, @Param("name") String name);


}
