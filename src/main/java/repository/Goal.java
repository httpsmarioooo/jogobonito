package repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Goal extends CrudRepository<Goal, Integer> {
}
