package io.mirko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties="classpath:io.mirko.application-test.properties")
@AutoConfigureTestDatabase
public class TutorialApplicationTests {

	@Test
	public void contextLoads() {
	}

}
