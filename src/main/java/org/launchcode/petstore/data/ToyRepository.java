package org.launchcode.petstore.data;

import org.launchcode.petstore.models.Dog;
import org.launchcode.petstore.models.Toy;
import org.springframework.data.repository.CrudRepository;

public interface ToyRepository extends CrudRepository<Toy, Integer> {
}
