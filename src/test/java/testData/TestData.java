package testData;

import model.Meal;
import model.Menu;
import model.Place;

public class TestData {

    public static final String MEALS = "[{\"mealId\":1,\"mealName\":\"макароны\",\"price\":763,\"menuId\":1,\"menuName\":\"завтрак\",\"menuNames\":[],\"menuIds\":[]},{\"mealId\":2,\"mealName\":\"картофель\",\"price\":863,\"menuId\":2,\"menuName\":\"обед\",\"menuNames\":[],\"menuIds\":[]},{\"mealId\":3,\"mealName\":\"хлеб\",\"price\":773,\"menuId\":3,\"menuName\":\"ужин\",\"menuNames\":[],\"menuIds\":[]}]";
    public static final String MAIN_DATA = "{\"гостиница\\nvotes:6\":[{\"menuId\":1,\"menuName\":\"завтрак\",\"cookName\":\"Вова\",\"placeId\":2,\"placeName\":null,\"mealTOS\":[{\"mealId\":1,\"mealName\":\"макароны\",\"price\":763,\"menuId\":1,\"menuName\":\"завтрак\",\"menuNames\":[],\"menuIds\":[]}],\"placeNames\":null,\"placeIds\":null},{\"menuId\":3,\"menuName\":\"ужин\",\"cookName\":\"Вася\",\"placeId\":2,\"placeName\":null,\"mealTOS\":[{\"mealId\":3,\"mealName\":\"хлеб\",\"price\":773,\"menuId\":3,\"menuName\":\"ужин\",\"menuNames\":[],\"menuIds\":[]}],\"placeNames\":null,\"placeIds\":null}],\"бар\\nvotes:5\":[{\"menuId\":1,\"menuName\":\"завтрак\",\"cookName\":\"Вова\",\"placeId\":1,\"placeName\":null,\"mealTOS\":[{\"mealId\":1,\"mealName\":\"макароны\",\"price\":763,\"menuId\":1,\"menuName\":\"завтрак\",\"menuNames\":[],\"menuIds\":[]}],\"placeNames\":null,\"placeIds\":null},{\"menuId\":2,\"menuName\":\"обед\",\"cookName\":\"Петя\",\"placeId\":1,\"placeName\":null,\"mealTOS\":[{\"mealId\":2,\"mealName\":\"картофель\",\"price\":863,\"menuId\":2,\"menuName\":\"обед\",\"menuNames\":[],\"menuIds\":[]}],\"placeNames\":null,\"placeIds\":null}],\"столовая\\nvotes:8\":[{\"menuId\":2,\"menuName\":\"обед\",\"cookName\":\"Петя\",\"placeId\":3,\"placeName\":null,\"mealTOS\":[{\"mealId\":2,\"mealName\":\"картофель\",\"price\":863,\"menuId\":2,\"menuName\":\"обед\",\"menuNames\":[],\"menuIds\":[]}],\"placeNames\":null,\"placeIds\":null},{\"menuId\":3,\"menuName\":\"ужин\",\"cookName\":\"Вася\",\"placeId\":3,\"placeName\":null,\"mealTOS\":[{\"mealId\":3,\"mealName\":\"хлеб\",\"price\":773,\"menuId\":3,\"menuName\":\"ужин\",\"menuNames\":[],\"menuIds\":[]}],\"placeNames\":null,\"placeIds\":null}]}";
    public static final Meal  MEAL_1 = new Meal("testMeal",500);
    public static final Meal  MEAL_2 = new Meal("testFish",500);
    public static final Meal  MEAL_3 = new Meal("testButer",500);
    public static final Menu  MENU_1 = new Menu("dinner","Dori");
    public static final Menu  MENU_2 = new Menu("lunch","Nori");
    public static final Menu  MENU_3 = new Menu("supper","Frodo Baggins");
    public static final Place PLACE_1 = new Place("resto");
    public static final Place PLACE_2 = new Place("korchma");
    public static final Place PLACE_3 = new Place("taverna");
}
