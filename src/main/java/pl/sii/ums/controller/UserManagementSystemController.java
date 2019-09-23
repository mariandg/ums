package pl.sii.ums.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.sii.ums.model.repository.entity.UserManagementSystemInfo;
import pl.sii.ums.services.db.impl.UserManagementSystemServiceImpl;

@RestController
public class UserManagementSystemController {
	
	@Autowired
	private UserManagementSystemServiceImpl userManagementSystemServiceImpl;
	
    ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping("/ums/info")
	public String getAllPersons(Model model) throws JsonProcessingException {
		String jsonString = "";
		Optional<UserManagementSystemInfo> umsInfo = userManagementSystemServiceImpl.findValidInformation();
		if(umsInfo.isPresent())
			jsonString = mapper.writeValueAsString(umsInfo.get());
		System.out.println(jsonString);
		return jsonString;
	}
	
}
