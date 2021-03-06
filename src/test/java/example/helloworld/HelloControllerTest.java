package example.helloworld;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class HelloControllerTest {
    private EmbeddedServer server;
    private HttpClient client;

    private static final Logger logger
            = LoggerFactory.getLogger(HelloControllerTest.class);

    @Before
    public void setup() {
        this.server = ApplicationContext.run(EmbeddedServer.class);
        this.client = HttpClient.create(this.server.getURL());
    }

    @Test
    public void shouldReturnHello() {
        logger.info("Testing server at {}", this.server.getURI());

        String response = client.toBlocking()
                .retrieve(HttpRequest.GET("/hello"));
        logger.info("We got a response '{}'", response);
        assertEquals(response, "Hello World");
    }

    @After
    public void cleanup() {
        this.server.stop();
        this.client.close();
    }
}