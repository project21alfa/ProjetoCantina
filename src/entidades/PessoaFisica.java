package entidades;

public class PessoaFisica extends Pessoa{
    private long id;
    private String cpf;
    private String rg;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
}
