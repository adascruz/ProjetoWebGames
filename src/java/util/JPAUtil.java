package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    public static EntityManagerFactory emf;
    
    static{
        emf = Persistence.createEntityManagerFactory("ProjetoWebGamesPU");
    }
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}