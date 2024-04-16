package co.istad.elearningapi.feature.User;

import co.istad.elearningapi.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.isDeleted = false WHERE u.username = ?1")
    int enableUserByUsername(String username);

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
