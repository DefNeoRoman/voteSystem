package sandbox;

import model.Meal;
import model.Role;
import model.User;
import repository.MealRepositoryImpl;
import repository.UserRepositoryImpl;
import repository.interfaces.MealRepository;
import repository.interfaces.UserRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SandBox {
    private final AtomicInteger userCounter = new AtomicInteger(0);
    private final AtomicInteger mealCounter = new AtomicInteger(0);
    private UserRepository userRepository = new UserRepositoryImpl();
    private MealRepository mealRepository = new MealRepositoryImpl();
    private final User regularUser = new User(userCounter.incrementAndGet(),"regular",Role.USER);
    private final User admin = new User(userCounter.incrementAndGet(),"admin",     Role.ADMIN);
    private final Meal potatoes = new Meal(mealCounter.incrementAndGet(),"картошка",100);
    private final Meal soup = new Meal(mealCounter.incrementAndGet(),"борщ",100);
    private final Meal meat = new Meal(mealCounter.incrementAndGet(),"мясо",1500);
    private final Meal fish = new Meal(mealCounter.incrementAndGet(),"рыба",200);
    private final Meal mushrooms = new Meal(mealCounter.incrementAndGet(),"грибы",400);
    private final Meal bread = new Meal(mealCounter.incrementAndGet(),"хлеб",300);

    public void fillRepositories(){
        userRepository.save(regularUser);
        userRepository.save(admin);
        mealRepository.save(potatoes);
        mealRepository.save(soup);
        mealRepository.save(meat);
        mealRepository.save(fish);
        mealRepository.save(mushrooms);
        mealRepository.save(bread);

    }
    public List<User> getUsers(){
        return userRepository.getAll();
    }
    public List<Meal> getMeals(){
        return mealRepository.getAll();
    }
}
