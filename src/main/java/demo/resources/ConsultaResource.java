package demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Consulta;
import demo.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaResource {
	
	@Autowired
	ConsultaService service;
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Consulta> find(@PathVariable Integer id){
		Consulta obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
