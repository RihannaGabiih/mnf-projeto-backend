package mnf.projeto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import mnf.projeto.dto.UsuarioRequestDTO;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	@Column(unique = true)
	private String nomeUsuario;
	@Column(unique = true)
	private String email;
	private String senha;
	private String fotoPerfil;
	private String dataCadastro;
	
	public Usuario() {
	
	}
	
	public Usuario(UsuarioRequestDTO dto) {
		this.nome = dto.getNome();
		this.nomeUsuario = dto.getNomeUsuario();
		this.email = dto.getEmail();
		this.senha = dto.getSenha();
		this.fotoPerfil = dto.getFotoPerfil();
		
	}

	public Usuario(long id, String nome, String nomeUsuario, String email, String senha, String fotoPerfil,
			String dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
		this.fotoPerfil = fotoPerfil;
		this.dataCadastro = dataCadastro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	

}
