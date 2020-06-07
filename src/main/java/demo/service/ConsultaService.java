package demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.Consulta;
import demo.repository.ConsultaRepository;

@Service
public class ConsultaService {
	
	@Autowired
	ConsultaRepository repositorio;
	
	public Consulta buscar(Integer id) {
		Optional<Consulta> obj = repositorio.findById(id);
		
		return obj.orElse(null);

	}

}
