package org.launchcode.petstore.data;

import org.launchcode.petstore.models.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Integer> {
}
