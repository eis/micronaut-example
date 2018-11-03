package example.counter;

import example.helloworld.HelloControllerTest;
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

public class CounterControllerTest {
    private EmbeddedServer server;
    private HttpClient client;

    @Test
    public void shouldCount() {
        CounterResult response = client.toBlocking()
                .retrieve(HttpRequest.POST("/counter/add", "{\"int1\": 2, \"int2\": 3}"),
                        CounterResult.class);
        logger.info("We got a response '{}'", response);
        assertEquals(Integer.valueOf(5), response.result);
    }


    private static final Logger logger
            = LoggerFactory.getLogger(CounterControllerTest.class);

    @Before
    public void setup() {
        this.server = ApplicationContext.run(EmbeddedServer.class);
        this.client = HttpClient.create(this.server.getURL());
    }

    @After
    public void cleanup() {
        this.server.stop();
        this.client.close();
    }
}
