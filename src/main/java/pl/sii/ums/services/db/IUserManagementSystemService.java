package pl.sii.ums.services.db;

import java.util.Optional;

import pl.sii.ums.model.repository.entity.UserManagementSystemInfo;

public interface IUserManagementSystemService {
	
	public Optional<UserManagementSystemInfo> findValidInformation();

}
