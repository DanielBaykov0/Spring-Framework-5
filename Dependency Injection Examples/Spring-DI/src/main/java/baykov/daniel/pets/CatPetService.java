package baykov.daniel.pets;

public class CatPetService implements PetService {

    @Override
    public String getPetType() {
        return "Cats are the Best!";
    }
}
