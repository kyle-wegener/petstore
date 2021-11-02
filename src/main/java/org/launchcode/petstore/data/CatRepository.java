package org.launchcode.petstore.data;

import org.launchcode.petstore.models.Cat;
import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Integer> {
}
