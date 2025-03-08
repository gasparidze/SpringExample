package com.example.springexample.repository;

import com.example.springexample.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findClientByBirthDateOrFio(LocalDate birthday , String fio);

    @Modifying
    @Query("update Client c set c.phone = ?1 where c.id = ?2")
    int updatePhoneByIdHQL(String phone , Integer id);

    @Modifying
    @Query(value = """
            UPDATE client SET phone = :phone WHERE id = :id;
            """, nativeQuery = true)
    int updatePhoneById(String phone , Integer id);
}