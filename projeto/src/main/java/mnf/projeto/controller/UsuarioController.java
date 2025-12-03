package mnf.projeto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import jakarta.validation.Valid;
import mnf.projeto.dto.UsuarioRequestDTO;
import mnf.projeto.service.UsuarioService;


@RestController
@RequestMapping("user")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	public UsuarioController (UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	//cadastrar
	@PostMapping(value = "criarUsuario")
	public ResponseEntity<?> criarUsuario(@Valid @RequestBody UsuarioRequestDTO dto){
		return ResponseEntity.ok(usuarioService.criarUsuario(dto));
	}

}
