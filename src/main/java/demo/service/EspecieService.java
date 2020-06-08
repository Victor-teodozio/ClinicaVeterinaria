package demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.Especie;
import demo.repository.*;


@Service
public class EspecieService {
	
	@Autowired
	private EspecieRepository especieRepository;
	
	public List<Especie> list() {
		return especieRepository.findAll();
	}
	
	public Especie find(Integer id) {
		return especieRepository.findById(id).get();
	}
	
	public Especie buscar(Integer id) {
		Optional<Especie> obj = especieRepository.findById(id);
		
		return obj.orElse(null);
	}

}