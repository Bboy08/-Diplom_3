package api.helper;

import api.model.CreateUserRequest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class UserGenerator {
    public static CreateUserRequest getRandomUser() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        String name = fakeValuesService.bothify("???????????");
        String email = fakeValuesService.bothify("????##@gmail.com");
        String password = fakeValuesService.bothify("????##??###");
        return new CreateUserRequest(name, email, password);
    }

    public static CreateUserRequest getRandomUserWithInvalidPass() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        String name = fakeValuesService.bothify("???????????");
        String email = fakeValuesService.bothify("????##@gmail.com");
        String password = fakeValuesService.bothify("?##?#");
        return new CreateUserRequest(name, email, password);
    }
}
