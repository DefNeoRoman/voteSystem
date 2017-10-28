package service;

import model.Meal;
import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.datajpa.MealRepository;
import repository.datajpa.MenuRepository;

import java.util.*;

@Service
public class MenuMealService{

    @Autowired
    MenuRepository menuRepository;
    @Autowired
    MealRepository mealRepository;
   public void fillRep(){


   }
   public void printRep(){

   }
}
