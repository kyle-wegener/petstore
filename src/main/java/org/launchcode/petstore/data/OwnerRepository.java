package org.launchcode.petstore.data;

import org.launchcode.petstore.models.Dog;
import org.launchcode.petstore.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
}
