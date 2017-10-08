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
    private final User regularUser = new User(userCounter.getAndIncrement(),UUID.randomUUID().toString(),"regular",Role.USER);
    private final User admin = new User(userCounter.getAndIncrement(),UUID.randomUUID().toString(),"admin",     Role.ADMIN);
    private final Meal potatoes = new Meal(mealCounter.getAndIncrement(),UUID.randomUUID().toString(),"картошка",100);
    private final Meal soup = new Meal(mealCounter.getAndIncrement(),UUID.randomUUID().toString(),"борщ",100);
    private final Meal meat = new Meal(mealCounter.getAndIncrement(),UUID.randomUUID().toString(),"мясо",1500);
    private final Meal fish = new Meal(mealCounter.getAndIncrement(),UUID.randomUUID().toString(),"рыба",200);
    private final Meal mushrooms = new Meal(mealCounter.getAndIncrement(),UUID.randomUUID().toString(),"грибы",400);
    private final Meal bread = new Meal(mealCounter.getAndIncrement(),UUID.randomUUID().toString(),"хлеб",300);

   public void clearRepositories(){
      userRepository.clear();
      mealRepository.clear();
   }
    public void fillRepositories(){
        userRepository.save(regularUser);
        userRepository.save(admin);
        mealRepository.save(potatoes,potatoes.getUuid());
        mealRepository.save(soup,soup.getUuid());
        mealRepository.save(meat,meat.getUuid());
        mealRepository.save(fish,fish.getUuid());
        mealRepository.save(mushrooms,mushrooms.getUuid());
        mealRepository.save(bread,bread.getUuid());

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
