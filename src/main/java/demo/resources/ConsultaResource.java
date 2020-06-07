package demo.resources;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="consulta")
public class ConsultaResource{

	@RequestMapping(method = RequestMethod.GET)
	public String Listar() {

		return "REST Funcionando...";
	}
	
}
