package mvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import mvc.modelo.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaDAO {
    
    @PersistenceContext
    private EntityManager manager;

    
    public void addCategoria(Categoria categoria){
        manager.persist(categoria);
    }
    
    
    public void alteraCategoria(Categoria categoria){
        manager.merge(categoria);
    }
    
    public List<Categoria> listaCategorias(Categoria categoria){
        List<Categoria> categorias = null;
        
        try{
            CriteriaBuilder cb = manager.getCriteriaBuilder ();
            CriteriaQuery<Categoria> cq = cb.createQuery(Categoria.class);
            Root<Categoria> cli = cq.from(Categoria.class);
            cq.select(cli);
            
            Predicate predicate = cb.like(cli.<String>get("descricao"), "%"+categoria.getDescricao()+"%");
            cq.where(predicate);
            
            TypedQuery<Categoria> query = manager.createQuery(cq);
            categorias = query.getResultList();
        
        }
        catch(TypeNotPresentException ex){
            String consulta = "select c from Categoria c ";
            TypedQuery<Categoria> query = manager.createQuery(consulta, Categoria.class);
            
            categorias = query.getResultList();
        }
                
        return categorias;
    }
    
    public void excluiCategoria(Categoria categoria){
        Categoria categoriaExcluir = manager.find(Categoria.class, categoria.getCodigo());        
        manager.remove(categoriaExcluir);
    }
     
    public Categoria findCategoriaByCodigo(Categoria categoria){
        Categoria categoriaRetorno = manager.find(Categoria.class, categoria.getCodigo());
        return categoriaRetorno;
    }
    
    public List<Categoria> findCategoria(Categoria categoria){
        List<Categoria> categorias;
        TypedQuery<Categoria> query = manager.createQuery("SELECT c FROM Categoria c WHERE c.descricao LIKE :descricao ", Categoria.class);
        query.setParameter("descricao", categoria.getDescricao()+ "%");
        try {
            categorias = query.getResultList();
        } catch (NoResultException e) {
            categorias = null;
        }
        return categorias;
    }
    
}