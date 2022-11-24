package couchpotatoes.spurven.repository;

import couchpotatoes.spurven.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@SuppressWarnings("unused")
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
