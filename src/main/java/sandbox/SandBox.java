package sandbox;

import model.Meal;
import model.User;

import repository.UserRepositoryImpl;
import repository.datajpa.MealRepository;
import repository.interfaces.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class SandBox {
    private final AtomicInteger userCounter = new AtomicInteger(0);
    private final AtomicInteger mealCounter = new AtomicInteger(0);
    private UserRepository userRepository = new UserRepositoryImpl();




   public void clearRepositories(){
      userRepository.clear();

   }

    public List<User> getUsers(){
        return userRepository.getAll();
    }


}
