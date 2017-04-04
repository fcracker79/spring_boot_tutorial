package io.mirko.controllers.mvc;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class MainControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testJspWithEl() throws Exception {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/spring_boot_tutorial/", String.class);
        assertThat(entity.getStatusCode(), IsEqual.equalTo(HttpStatus.OK));
        assertThat(entity.getBody(), containsString("/resources/text.txt"));
    }
}
