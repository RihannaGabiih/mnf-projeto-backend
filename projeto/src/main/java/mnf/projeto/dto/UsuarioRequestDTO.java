package mnf.projeto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {
	
	@NotBlank(message = "O campo não pode estar vazio")
	private String nome;
	@NotBlank(message = "O campo não pode estar vazio")
	private String nomeUsuario;
	@NotBlank(message = "O campo não pode estar vazio")
	private String email;
	@Size(min=8, max=20, message = "A senha deve ter entre 8 e 20 caracteres")
	private String senha;
	
	private String fotoPerfil;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	
	


}
