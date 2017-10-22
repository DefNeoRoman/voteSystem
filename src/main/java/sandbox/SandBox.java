package sandbox;

import model.Meal;
import model.Role;
import model.User;
import repository.MealRepositoryImpl;
import repository.UserRepositoryImpl;
import repository.interfaces.MealRepository;
import repository.interfaces.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class SandBox {
    private final AtomicInteger userCounter = new AtomicInteger(0);
    private final AtomicInteger mealCounter = new AtomicInteger(0);
    private UserRepository userRepository = new UserRepositoryImpl();
    private MealRepository mealRepository = new MealRepositoryImpl();



   public void clearRepositories(){
      userRepository.clear();
      mealRepository.clear();
   }

    public List<User> getUsers(){
        return userRepository.getAll();
    }
    public List<Meal> getMeals(){
        return mealRepository.getAll();
    }
    public Meal addMeal(Meal meal){

        meal.setUuid(UUID.randomUUID().toString());
        mealRepository.save(meal,meal.getUuid());
        return meal;
    }
    public void deleteMeal(String uuid){

        mealRepository.delete(uuid);
        mealCounter.decrementAndGet();
    }
    public Meal getMeal(String uuid){
       return mealRepository.get(uuid);
    }
}
