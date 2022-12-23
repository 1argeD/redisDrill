package org.example.Repository;

import lombok.Getter;
import org.example.Entity.Entity;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<Entity, String> {
}
