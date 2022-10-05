package dao.exemplo1;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class Usuario {
    // atributos do domínio da entidade Usuario
	private long id; 
    private String nome;
    private String email;
    private String senha;
    private Date dataInclusao;
     
    // construtores / setters & getters
    public Usuario() {
	    this.dataInclusao = new Date();
	}
    
    public Usuario(String nome, String email, String senha) {		
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataInclusao = new Date();
		// o atributo "id" é criado automaticamente no banco de dados
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
	public  Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao( Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
    

    
    
}