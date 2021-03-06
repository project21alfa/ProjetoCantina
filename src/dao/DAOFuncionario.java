package dao;

import entidades.Cliente;
import entidades.Funcionario;
import entidades.Produto;
import fabrica.Fabrica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DAOFuncionario {

    private EntityManager em;
    private EntityTransaction t;

    public Funcionario findByLogin(String login) {
        em = Fabrica.getFabrica().createEntityManager();
        Query query = em.createQuery("from Funcionario as Funcionario where Funcionario.login = :param");
        query.setParameter("param", login);
        System.out.println(query.getResultList().size());
        return (Funcionario) query.getResultList().get(0);
    }

    public Funcionario findByName(String nome) {
        em = Fabrica.getFabrica().createEntityManager();
        Query query = em.createQuery("from Funcionario as Funcionario where Funcionario.nome = :param");
        query.setParameter("param", nome);
        System.out.println(query.getResultList().size());
        return (Funcionario) query.getResultList().get(0);
    }
    
    public List<Funcionario> listByNameSearch(String nome){
        em = Fabrica.getFabrica().createEntityManager();        
        List<Funcionario> listFuncionario = new ArrayList<>();
        
        Query query = em.createQuery("from Funcionario as Funcionario where Funcionario.nome like 'nome'");
        query.setParameter("nome", nome);
        
        listFuncionario = query.getResultList();
        
        em.close();
        
        return listFuncionario;      
    }
    
    public boolean excluir(long id){
        em = Fabrica.getFabrica().createEntityManager();
        t = em.getTransaction();
        
        try{
           t.begin();
           Funcionario f = em.find(new Funcionario().getClass(), id);
           em.remove(f);
           t.commit();
           return true;
        }
        catch(PersistenceException pe){
            pe.printStackTrace();
            t.rollback();
            return false;
        }
        finally{
            em.close();
        }
    }
    
     public boolean alterar(Funcionario pp, Class c, long id){
	      em = Fabrica.getFabrica().createEntityManager();
	      EntityTransaction t = em.getTransaction();
              Funcionario p = new Funcionario();
	      try{
	         t.begin();
	         p = em.find(new Funcionario().getClass(), id);//buscando a entidade no banco
	         em.merge(pp);//alterar a entidade
	         t.commit();
	         return true; 
	      }catch(Exception e){
	        e.printStackTrace();
	        t.rollback();
	        return false;
	      }finally{
	         em.close();
	       }
	}
     
    public List<Funcionario> listarFuncionario() {
        List<Funcionario> lista = new ArrayList<Funcionario>();
        em = Fabrica.getFabrica().createEntityManager();
        try {
            lista = em.createQuery("from Funcionario").getResultList();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }

    }
    
}
