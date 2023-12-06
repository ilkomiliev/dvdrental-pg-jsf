package dvdrental.pg.jsf.repos;

import dvdrental.pg.jsf.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorJpaRepository extends JpaRepository<Actor, Integer> {
}
