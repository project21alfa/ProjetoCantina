package dao;

import entidades.Funcionario;
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
    
    public boolean alterar(Funcionario f){
        em = Fabrica.getFabrica().createEntityManager();
        t = em.getTransaction();
        
        try{
            t.begin();
            f = em.find(f.getClass(), f.getId());
            em.merge(f);
            t.commit();
            return true;
        }
        catch(PersistenceException pe){
            pe.printStackTrace();
            return false;
        }
        finally{
            em.close();
        }
    }
    
}
