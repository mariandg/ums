package pl.sii.ums.services.db.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.sii.ums.model.repository.IUserManagementSystemRepository;
import pl.sii.ums.model.repository.entity.UserManagementSystemInfo;
import pl.sii.ums.services.db.IUserManagementSystemService;

@Component
public class UserManagementSystemServiceImpl implements IUserManagementSystemService{

	@Autowired
	private IUserManagementSystemRepository userManagementSystemRepository;

	@Override
	public Optional<UserManagementSystemInfo> findValidInformation() {
		return userManagementSystemRepository.findValidInformation();
	}


}
