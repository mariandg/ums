package pl.sii.ums.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.sii.ums.model.repository.entity.UserManagementSystemInfo;

@Repository
public interface IUserManagementSystemRepository extends CrudRepository<UserManagementSystemInfo, Long>{
	
	@Query("FROM UserManagementSystemInfo u WHERE u.id = (SELECT MAX(id) FROM UserManagementSystemInfo)")
	public Optional<UserManagementSystemInfo> findValidInformation();
}
