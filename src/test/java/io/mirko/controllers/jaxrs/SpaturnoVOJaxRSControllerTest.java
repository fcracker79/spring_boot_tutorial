package io.mirko.controllers.jaxrs;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpaturnoVOJaxRSControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGet() {
        final ResponseEntity<List> responseSpaturno = restTemplate.getForEntity("/api/test/spaturni", List.class);
        assertThat(responseSpaturno.getBody().size(), IsEqual.equalTo(1));
        final Map spaturnoMap = (Map) responseSpaturno.getBody().iterator().next();
        final Map<String, Object> expected = new HashMap<>();
        expected.put("name", "John");
        expected.put("surname", "Smith");
        expected.put("id", 1);
        expected.put("age", 25);
        assertThat(spaturnoMap, IsEqual.equalTo(expected));
    }

    @Test
    public void testPost() {
        final Map<String, Object> expected = new HashMap<>();
        expected.put("name", "John");
        expected.put("surname", "Smith");
        expected.put("id", 1);
        expected.put("age", -1);
        final ResponseEntity<List> result = restTemplate.postForEntity("/api/test/spaturni", expected, List.class);
        assertThat(result.getStatusCode(), IsEqual.equalTo(HttpStatus.BAD_REQUEST));
        assertThat(result.getBody().size(), IsEqual.equalTo(1));
        final Map<String, Object> error = (Map<String, Object>) result.getBody().get(0);
        assertThat(error.get("message"), IsEqual.equalTo("must be greater than or equal to 1"));
        assertThat(error.get("messageTemplate"), IsEqual.equalTo("{javax.validation.constraints.Min.message}"));
    }
}
