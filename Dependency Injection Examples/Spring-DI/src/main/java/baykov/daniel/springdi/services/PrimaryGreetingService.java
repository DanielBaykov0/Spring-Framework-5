package baykov.daniel.springdi.services;

public class PrimaryGreetingService implements GreetingService {


    @Override
    public String sayGreeting() {
        return "Hello World - From the primary bean";
    }
}
