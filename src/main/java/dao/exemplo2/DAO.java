package dao.exemplo2;

import java.util.List;

import dao.exemplo1.DataSource;
/**
 * Classe interface genérica para DAO (Data Access Object)
 * 
 * @param <T>  representa a classe POJO de domínio (Ex: Usuario)
 */
public interface DAO<T> {
	DataSource ds = DataSource.getInstance();
	
	T findById(long id);
    
    List<T> findAll();
    
    void insert(T t);
    
    void update(T t);
    
    void delete(T t);
    
    default public void close() {   // fecha a conexão com o banco
		ds.closeConnection();
	}
}
