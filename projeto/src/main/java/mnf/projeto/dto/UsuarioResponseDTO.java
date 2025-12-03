package mnf.projeto.dto;

import mnf.projeto.entity.Usuario;

public class UsuarioResponseDTO {
	
	private String nome;
	private String nomeUsuario;
	private String dataCadastro;
	
	public UsuarioResponseDTO(String nome, String nomeUsuario, String dataCadastro) {
		this.nome = nome;
		this.nomeUsuario = nomeUsuario;
		this.dataCadastro = dataCadastro;
	}
	
	public UsuarioResponseDTO(Usuario user) {
		this.nome = user.getNome();
		this.nomeUsuario = user.getNomeUsuario();
		this.dataCadastro = user.getDataCadastro();
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

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	

}
