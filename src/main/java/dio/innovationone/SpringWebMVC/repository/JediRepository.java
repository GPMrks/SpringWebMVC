package dio.innovationone.SpringWebMVC.repository;

import dio.innovationone.SpringWebMVC.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

    List<Jedi> findByName(final String name);

}
