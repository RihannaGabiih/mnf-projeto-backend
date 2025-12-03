package mnf.projeto.service;

import org.springframework.stereotype.Service;

import mnf.projeto.dto.UsuarioRequestDTO;
import mnf.projeto.dto.UsuarioResponseDTO;
import mnf.projeto.entity.Usuario;
import mnf.projeto.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	//cadastrar
	 public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
	        Usuario user = new Usuario(dto);
	        usuarioRepository.save(user);
	        UsuarioResponseDTO response = new UsuarioResponseDTO(user);
	        return response;
	    }
	    
	
	

}
