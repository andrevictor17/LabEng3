package Modelo;

/**
 * 
 */
public class User {

	private String nome;
	private String senha;
	private UserClass Tipo;

	
	/**
	 * Default contrutor
	 */
	public User(String nome, String senha) {
		setNome(nome);
		setSenha(senha);
		setTipo(UserClass.CHAMADO);
	}
	
	public User(String nome, String senha, UserClass Tipo) {
		setNome(nome);
		setSenha(senha);
		setTipo(Tipo);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UserClass getTipo() {
		return Tipo;
	}
	public void setTipo(UserClass Tipo) {
		this.Tipo = Tipo;
	}



}