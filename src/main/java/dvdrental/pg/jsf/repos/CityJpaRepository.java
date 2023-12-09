package dvdrental.pg.jsf.repos;

import dvdrental.pg.jsf.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityJpaRepository extends JpaRepository<City, Integer> {
}
