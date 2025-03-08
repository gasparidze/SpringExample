package com.example.springexample.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "clientAccounts")
@Data
@Builder
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String fio;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Builder.Default
    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<ClientAccount> clientAccounts = new ArrayList<>();
}
