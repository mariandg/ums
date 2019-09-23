package pl.sii.ums.model.repository;

//import java.util.Dictionary;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.sii.ums.model.repository.entity.Project;

@Repository
public interface IProjectRepository extends CrudRepository<Project, Long> {

//	@Query("SELECT projectId, name FROM Project")
//	public List<Dictionary<Long, String>> findAllDict();
}
