package example.counter;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

import javax.inject.Inject;

@Controller("/counter")
public class CounterController {

    @Inject
    CounterService counterService;

    @Post("/add")
    public Single<CounterResult> add(CounterRequest counterRequest) {
        return counterService.add(counterRequest.int1, counterRequest.int2).map(CounterResult::new);
    }
}
