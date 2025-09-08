package ru.vlad.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlad.test.data.entity.Role;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
}
