package demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Especie;
import demo.service.EspecieService;

@RestController
@RequestMapping("/especies")
public class EspecieResource {
	
	@Autowired
	EspecieService service;
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Especie obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
