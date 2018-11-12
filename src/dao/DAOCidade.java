package dao;

import entidades.Cidade;
import entidades.Estado;
import entidades.Funcionario;
import fabrica.Fabrica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DAOCidade {
    EntityManager em;    
    private EntityTransaction t;
    	
    public List<Cidade> listarCidade(long id) {
		List<Cidade> lista = new ArrayList<Cidade>();
		EntityManager em = Fabrica.getFabrica().createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
                        Query query = em.createQuery("from Cidade as Cidade where Cidade.estado = :param order by nome");
                        query.setParameter("param", id);
			lista = query.getResultList();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}

    }
     public boolean excluir(long id){
        em = Fabrica.getFabrica().createEntityManager();
        t = em.getTransaction();
        
        try{
           t.begin();
           Cidade f = em.find(new Cidade().getClass(), id);
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
    
    public List<Cidade> buscarCidade(Estado est,long id){
        List<Cidade> listCidade = new ArrayList<>();
        em = Fabrica.getFabrica().createEntityManager();
        
        try{
            listCidade = em.createQuery("from Cidade where estado = " + id + " order by nome").getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            em.close();
        }
        
        
        return listCidade;  
    }
     public Cidade findByNome(String nome) {
		  em = Fabrica.getFabrica().createEntityManager();
	        Query query = em.createQuery("from Cidade as cidade where cidade.nome = :param");
	        query.setParameter("param", nome);
	        System.out.println(query.getResultList().size());
	       return (Cidade) query.getResultList().get(0);
	    }

  
    public List<Cidade> listarCidade(int id){
		  	List<Cidade> lista = new ArrayList<Cidade>();
			em = Fabrica.getFabrica().createEntityManager();
			try{
				lista = em.createQuery("from Cidade where estado = "+id).getResultList();
				return lista;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				em.close();
			}
			
		}
    
}
