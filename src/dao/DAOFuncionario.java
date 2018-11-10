package dao;

import entidades.Funcionario;
import fabrica.Fabrica;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAOFuncionario {

    private EntityManager em;

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
  
}
