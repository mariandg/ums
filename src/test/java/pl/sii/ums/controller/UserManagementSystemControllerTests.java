package pl.sii.ums.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest
public class UserManagementSystemControllerTests {

    @Autowired
    private UserManagementSystemController controller;
    
    @Test
    public void contexLoads() throws Exception {
        //assertThat(controller).isNotNull();
    }
}
