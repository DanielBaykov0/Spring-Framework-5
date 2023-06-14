package baykov.daniel.springdi.config;

import baykov.daniel.pets.PetService;
import baykov.daniel.pets.PetServiceFactory;
import baykov.daniel.springdi.datasource.FakeDataSource;
import baykov.daniel.springdi.repositories.EnglishGreetingRepository;
import baykov.daniel.springdi.repositories.EnglishGreetingRepositoryImpl;
import baykov.daniel.springdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:springdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${daniel.username}") String username,
                                  @Value("${daniel.password}") String password,
                                  @Value("${daniel.jdbcurl}") String jdbcurl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurcl(jdbcurl);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishService() {
        return new I18nSpanishGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
