package co.com.poli.users.serviceuser.repository;

import co.com.poli.users.serviceuser.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
