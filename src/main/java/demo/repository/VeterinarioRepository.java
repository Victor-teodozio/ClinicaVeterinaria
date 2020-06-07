package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.domain.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer>{

}
