package daos;

import org.springframework.data.repository.CrudRepository;

import com.practice.models.Person;

public interface PersonDAO extends CrudRepository<Person, Integer> {

}
