package com.crown.university.university.repo;

import com.mongodb.WriteResult;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.io.Serializable;

public interface CrudRepository<T, ID extends Serializable> {
    public Key<T> create(T entity);

    public T read(ID id);

    public UpdateResults update(T entity, UpdateOperations<T> operations);

    public WriteResult delete(T entity);

    public UpdateOperations<T> createOperations();
}
