package mnf.projeto.service;

import java.util.List;
import java.util.Optional;

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
	 
	 //login
	 public String login(Usuario user) {
		 Usuario findUser = usuarioRepository.findByEmail(user.getEmail());
		 if (findUser == null) {
			 return "Usuario não encontrado";
		 }
		 
		 else if (findUser.getSenha().equals(user.getSenha())) {
			 return "Login efetuado com sucesso";
		 }
		 else {
			 return "Senha incorreta";
		 }
	 }
	
	//buscar todos os usuarios
	public List<UsuarioResponseDTO>listarUsuario(){
		return usuarioRepository.findAll()
				.stream()
				.map(usuario -> new UsuarioResponseDTO(
						usuario.getNome(),
						usuario.getNomeUsuario(),
						usuario.getEmail()
						))
				.toList();
	}
	
	//buscar por id
	public UsuarioResponseDTO buscarUserId (long id) {
		return usuarioRepository.findById(id)
				.map(usuario -> (new UsuarioResponseDTO(usuario)))
				.orElse(null);
	}
	
	//buscar por nome_usuario
	public UsuarioResponseDTO buscarNomeUsuario(String nomeUsuario) {
	    Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario)
	            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

	    return new UsuarioResponseDTO(usuario);
	}
	
	//atualizar usuario
	public UsuarioResponseDTO atualizar (long id, UsuarioRequestDTO novoUser) {
		Optional<Usuario> userExistente = usuarioRepository.findById(id);
		
		if(userExistente.isPresent()) {
			Usuario usuario = userExistente.get();
			
			usuario.setFotoPerfil(novoUser.getFotoPerfil());
			usuario.setNome(novoUser.getNome());
			usuario.setNomeUsuario(novoUser.getNomeUsuario());
			usuario.setEmail(novoUser.getEmail());
			usuario.setSenha(novoUser.getSenha());
			
			Usuario userAtualizado = usuarioRepository.save(usuario);
			
			UsuarioResponseDTO response = new UsuarioResponseDTO(userAtualizado);
			return response;
		} else {
			return null;
		}
		
	}
	
	//deletar usuario
	public String deletar(long id) {
		if(usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
			return ("Usuario excluído");
		}
		else {
			return ("Esse id não existe");
		}
	}
	
	

}
