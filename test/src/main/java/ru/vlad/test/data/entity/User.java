package ru.vlad.test.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.net.URL;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @Column(name = "uuid")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "fio", nullable = false, length = 255)
    private String fio;

    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    @Column(name = "avatar", length = 255)
    private URL avatar;

    @ManyToOne
    @JoinColumn(name = "role_uuid", referencedColumnName = "uuid")
    private Role role;

}
