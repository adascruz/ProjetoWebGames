package mvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import mvc.modelo.Cliente;
import util.JPAUtil;

public class ClienteDAO {
    
    public void addCliente(Cliente cliente){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(cliente);
        manager.getTransaction().commit();
        manager.close();
    }
    
    
    public void alteraCliente(Cliente cliente){
        EntityManager manager = JPAUtil.getEntityManager();
       
        manager.getTransaction().begin();
        manager.merge(cliente);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List<Cliente> listaClientes(Cliente cliente){
        EntityManager manager = JPAUtil.getEntityManager();
        List<Cliente> clientes = null;
        
        try{
            CriteriaBuilder cb = manager.getCriteriaBuilder ();
            CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
            Root<Cliente> cli = cq.from(Cliente.class);
            cq.select(cli);
            
            Predicate predicate = cb.like(cli.<String>get("nome"), "%"+cliente.getNome()+"%");
            cq.where(predicate);
            
            TypedQuery<Cliente> query = manager.createQuery(cq);
            clientes = query.getResultList();
        
        }
        catch(TypeNotPresentException ex){
            String consulta = "select c from Cliente c ";
            
            TypedQuery<Cliente> query = manager.createQuery(consulta, Cliente.class);
            
            clientes = query.getResultList();
        }
        
        manager.close();
        
        return clientes;
    }
    
    public void excluiCliente(Cliente cliente){
        EntityManager manager = JPAUtil.getEntityManager();
        
        Cliente clienteAlterado;
        manager.getTransaction().begin();
        
        clienteAlterado = manager.find(Cliente.class, cliente.getCodigo());        
        manager.remove(clienteAlterado);
        
        manager.getTransaction().commit();
        manager.close();
    }
    
    public Cliente validarLogin(Cliente cliente){
        Cliente clienteResultado;
        
        EntityManager entitymanager = JPAUtil.getEntityManager();
        
        CriteriaBuilder cb = entitymanager.getCriteriaBuilder ();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> cli = cq.from(Cliente.class);
        cq.select(cli);
            
        Predicate predicate = cb.and(cb.equal(cli.get("login"), cliente.getLogin()), cb.equal(cli.get("senha"), cliente.getSenha()));
        cq.where(predicate);
            
        TypedQuery<Cliente> query = entitymanager.createQuery(cq);
        
        try{
            clienteResultado = query.getSingleResult();
        }
        catch(Exception noresult){
            clienteResultado = null;
        }
        
        return clienteResultado;
    }
    public Cliente findClienteByCodigo(Cliente cliente){
        Cliente clienteRetorno;
        
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        clienteRetorno = manager.find(Cliente.class, cliente.getCodigo());
        manager.close();
        
        return clienteRetorno;
    }
    
    public List<Cliente> findClientes(Cliente cliente){
        List<Cliente> condominos;
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<Cliente> query = manager.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nome ", Cliente.class);
        query.setParameter("nome", cliente.getNome() + "%");
        try {
            condominos = query.getResultList();
        } catch (NoResultException e) {
            condominos = null;
        }
        
        return condominos;
    }
    
    public boolean verificaLoginExistente(String login){
        EntityManager entitymanager = JPAUtil.getEntityManager();
        List<Cliente> clientes = null;
        boolean verifica = false;
        try{
            String consulta = "SELECT a FROM Cliente a WHERE a.login = :login ";
            
            TypedQuery<Cliente> query = entitymanager.createQuery(consulta, Cliente.class);
            query.setParameter("login", login);
            clientes = query.getResultList();
            System.out.println(clientes);
            if(clientes.isEmpty())
                verifica = false;
            else
                verifica = true;
        }
        catch(Exception noresult){
            noresult.getCause();
        }
        return verifica;
    }
}