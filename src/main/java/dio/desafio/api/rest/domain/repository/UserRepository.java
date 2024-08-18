package dio.desafio.api.rest.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import dio.desafio.api.rest.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
