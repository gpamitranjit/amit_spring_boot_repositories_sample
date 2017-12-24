package com.amdocs.myRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
 
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Optional;
 
public class BaseRepositoryImpl <T, ID extends Serializable> extends SimpleJpaRepository<T, ID>  implements BaseRepository<T, ID> {
    
    private final EntityManager entityManager;
    
    @Transactional
    @Override
    public Optional<T> deleteById(ID id) {
        T deleted = entityManager.find(this.getDomainClass(), id);
        Optional<T> returned = Optional.empty();
 
        if (deleted != null) {
            entityManager.remove(deleted);
            returned = Optional.of(deleted);
        }
        return returned;
    }

    @Autowired
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);		
		this.entityManager = entityManager;
	}
}