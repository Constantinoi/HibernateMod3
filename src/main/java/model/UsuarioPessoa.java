package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "UsuarioPessoa.findAll", query = "SELECT u FROM UsuarioPessoa u"),
		@NamedQuery(name = "UsuarioPessoa.buscaPorNome", query = "SELECT u FROM UsuarioPessoa u WHERE u.nome =:nome") })
public class UsuarioPessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	private String sobrenome;
	private String email;
	private String login;
	private String senha;
	private Long idade;

	@OneToMany(mappedBy = "usuarioPessoa", fetch = FetchType.EAGER)
	private List<TelefoneUser> listaTelefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public List<TelefoneUser> getListaTelefone() {
		return listaTelefone;
	}

	public void setListaTelefone(List<TelefoneUser> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", login=" + login
				+ ", senha=" + senha + ", idade=" + idade + "]";
	}

}
