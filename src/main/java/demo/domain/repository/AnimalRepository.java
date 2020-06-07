package demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.domain.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
