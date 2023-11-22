package com.upc.FinanazasGrupo4.domain.persistence.repository;

import com.upc.FinanazasGrupo4.domain.model.Cronograma;
import com.upc.FinanazasGrupo4.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    Customer getCustomerByEmailAndPassword(String email,String password);
    @Query("SELECT cr FROM Customer c JOIN c.cronograma cr WHERE c.id = :customerId AND cr.id = :cronogramaId")
    Optional<Cronograma> findCronogramaByCustomerAndCronogramaIds(Long customerId,Long cronogramaId);

}
