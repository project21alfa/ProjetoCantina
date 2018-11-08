package dao;

import entidades.Cidade;
import entidades.Estado;
import fabrica.Fabrica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class DAOCidade {
    EntityManager em;    
    	public List<Cidade> listarCidade(long id) {
		List<Cidade> lista = new ArrayList<Cidade>();
		EntityManager em = Fabrica.getFabrica().createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			lista = em.createQuery("from Cidade where estado_id = " + id).getResultList();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}

	}
    public List<Cidade> buscarCidade(Estado est){
        List<Cidade> listCidade = new ArrayList<>();
        em = Fabrica.getFabrica().createEntityManager();
        
        try{
            listCidade = em.createQuery("from cidade where id_estado = " + est.getId() + "order by nome").getResultList();
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
	 
    
}
