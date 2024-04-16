package co.istad.elearningapi.feature.User;

import co.istad.elearningapi.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

    boolean existsByName(String name);

    Optional<Role> findByName(String name);
}
