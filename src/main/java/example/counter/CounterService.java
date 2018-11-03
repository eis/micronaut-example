package example.counter;

import io.reactivex.Single;

import javax.inject.Singleton;

@Singleton
public class CounterService {
    public Single<Integer> add(int int1, int int2) {
        return Single.just(int1 + int2);
    }
}
