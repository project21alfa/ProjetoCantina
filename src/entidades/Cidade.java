package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	@ManyToOne
	private Estado estado;
	@OneToMany
	private List<Pessoa> pessoa= new ArrayList<Pessoa>();
	
	public List<Pessoa> getListaCidade(){
		return pessoa;
	}
	
	public void addPessoa(Pessoa c){
		pessoa.add(c);
		//{Pessoa1, Pessoa2, Pessoa3}
	}
	
	public void removePessoa(int index){
		pessoa.remove(index);
	}
	
	public Pessoa getPessoa(int index){
		return pessoa.get(index);
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNome();
	}

}
