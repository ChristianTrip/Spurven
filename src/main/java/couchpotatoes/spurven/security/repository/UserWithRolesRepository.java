package couchpotatoes.spurven.security.repository;

import couchpotatoes.spurven.security.entity.UserWithRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
UserWithRolesRepository extends JpaRepository<UserWithRoles,String> {
}
