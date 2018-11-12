package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	private String nome;
	private String sigla;
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidade= new ArrayList<>();
	
	public int getId() {
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public List<Cidade> getListaCidade(){
		return cidade;
	}
	
	public void addCidade(Cidade c){
		cidade.add(c);
	}
	
	public void removeCidade(int index){
		cidade.remove(index);
	}
	
	public Cidade getCidade(int index){
		return cidade.get(index);
	}

}
