package mnf.projeto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import jakarta.validation.Valid;
import mnf.projeto.dto.UsuarioRequestDTO;
import mnf.projeto.dto.UsuarioResponseDTO;
import mnf.projeto.entity.Usuario;
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
	
	//login
	@PostMapping(value = "login")
	public ResponseEntity<?> login (@RequestBody Usuario user){
		String resposta = usuarioService.login(user);
		
		if (resposta.equals("Usuario logado com sucesso")) {
			return ResponseEntity.ok(resposta);
		}
		else {
			HttpStatus status = resposta.equals("Usuario não encontrado") ? HttpStatus.NOT_FOUND : HttpStatus.UNAUTHORIZED;
			return ResponseEntity.status(status).body(resposta);
		}
	}
	
	//buscar todos
	@GetMapping(value = "buscarTodos")
	public List<UsuarioResponseDTO> listarUsuario(){
		return usuarioService.listarUsuario();
	}
	
	//buscar por id
	@GetMapping(value = "buscarId/{id}")
	public ResponseEntity<?> usuarioId(@PathVariable long id){
		UsuarioResponseDTO usuario = usuarioService.buscarUserId(id);
		
		if(usuario != null) {
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
		}
		
	}
		
	//buscar por nomeUsuario
	@GetMapping(value = "buscarNomeUsuario/{nomeUsuario}")
	public ResponseEntity<?> buscarNomeUsuario(@PathVariable String nomeUsuario){
		UsuarioResponseDTO user = usuarioService.buscarNomeUsuario(nomeUsuario);
		
		if (user != null) {
			return ResponseEntity.ok(user);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		}
	}
	
	//atualizar usuario por id
	@PutMapping(value = "atualizarUsuario/{id}")
	public ResponseEntity<?> atualizarUsuario(@PathVariable long id, @RequestBody UsuarioRequestDTO novo) {
		return ResponseEntity.ok(usuarioService.atualizar(id, novo));
	}
	
	//atualizar usuario por nomeUsuario
		@PutMapping(value = "atualizarUsuarioNome/{nomeUsuario}")
		public ResponseEntity<?> atualizarUsuarioNome(@PathVariable String nomeUsuario, @RequestBody UsuarioRequestDTO novo) {
			return ResponseEntity.ok(usuarioService.atualizarNomeUsuario(nomeUsuario, novo));
		}
	
	//deletar usuario
	@DeleteMapping(value = "deletarUsuario/{id}")
	public ResponseEntity<?> deletarUsuario(@PathVariable long id){
		return ResponseEntity.ok(usuarioService.deletar(id));
	}
	
	//deletar por nomeUsuario
	@DeleteMapping(value = "/deletarNomeUsuario/{nomeUsuario}")
	public ResponseEntity<String> deletarPorNomeUsuario(@PathVariable String nomeUsuario) {
	    return ResponseEntity.ok(usuarioService.deletarPorNomeUsuario(nomeUsuario));
	}
		
		
	
	
	

}
