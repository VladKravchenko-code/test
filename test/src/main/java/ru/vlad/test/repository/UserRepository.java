package ru.vlad.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlad.test.data.entity.User;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
