package testData;

import model.Meal;
import model.Menu;
import model.Place;

public class TestData {

    public static final String MEALS = " [{\"mealId\":1,\"mealName\":\"pasta\",\"price\":763,\"menuId\":1,\"menuName\":\"breakfast\",\"menuNames\":[],\"menuIds\":[]},{\"mealId\":2,\"mealName\":\"potatoes\",\"price\":863,\"menuId\":2,\"menuName\":\"dinner\",\"menuNames\":[],\"menuIds\":[]},{\"mealId\":3,\"mealName\":\"bread\",\"price\":773,\"menuId\":3,\"menuName\":\"supper\",\"menuNames\":[],\"menuIds\":[]}]";
    public static final String MENUS = "[{\"menuId\":1,\"menuName\":\"breakfast\",\"cookName\":\"Vova\",\"placeId\":2,\"placeName\":\"hotel\",\"mealTOS\":null,\"placeNames\":[],\"placeIds\":[]},{\"menuId\":1,\"menuName\":\"breakfast\",\"cookName\":\"Vova\",\"placeId\":1,\"placeName\":\"bar\",\"mealTOS\":null,\"placeNames\":[],\"placeIds\":[]},{\"menuId\":2,\"menuName\":\"dinner\",\"cookName\":\"Peter\",\"placeId\":3,\"placeName\":\"room\",\"mealTOS\":null,\"placeNames\":[],\"placeIds\":[]},{\"menuId\":2,\"menuName\":\"dinner\",\"cookName\":\"Peter\",\"placeId\":1,\"placeName\":\"bar\",\"mealTOS\":null,\"placeNames\":[],\"placeIds\":[]},{\"menuId\":3,\"menuName\":\"supper\",\"cookName\":\"Wasa\",\"placeId\":3,\"placeName\":\"room\",\"mealTOS\":null,\"placeNames\":[],\"placeIds\":[]},{\"menuId\":3,\"menuName\":\"supper\",\"cookName\":\"Wasa\",\"placeId\":2,\"placeName\":\"hotel\",\"mealTOS\":null,\"placeNames\":[],\"placeIds\":[]}]";
    public static final String PLACES = "[{\"id\":1,\"name\":\"bar\",\"vote\":5},{\"id\":2,\"name\":\"hotel\",\"vote\":6},{\"id\":3,\"name\":\"room\",\"vote\":8}]";
    public static final String USERS = "[{\"id\":1,\"username\":\"regular\",\"email\":\"regular@yandex.ru\",\"password\":\"$2a$08$bn3BrtjfeohY7xfXF00nFOtHbzKuPBZ0np8/AkSJrDN2HKsNlcKHK\",\"registerDate\":\"2017-12-30 08:50:04\",\"authorities\":[\"ROLE_USER\"],\"canVote\":true,\"enabled\":true,\"accountNonExpired\":true,\"accountNonLocked\":true,\"credentialsNonExpired\":true,\"vote\":false},{\"id\":2,\"username\":\"admin\",\"email\":\"admin@gmail.com\",\"password\":\"$2a$08$bn3BrtjfeohY7xfXF00nFOtHbzKuPBZ0np8/AkSJrDN2HKsNlcKHK\",\"registerDate\":\"2017-12-30 08:50:04\",\"authorities\":[\"ROLE_ADMIN\"],\"canVote\":true,\"enabled\":true,\"accountNonExpired\":true,\"accountNonLocked\":true,\"credentialsNonExpired\":true,\"vote\":false},{\"id\":3,\"username\":\"regUser\",\"email\":\"regUser@mail.com\",\"password\":\"$2a$08$bn3BrtjfeohY7xfXF00nFOtHbzKuPBZ0np8/AkSJrDN2HKsNlcKHK\",\"registerDate\":\"2017-12-30 08:50:04\",\"authorities\":[\"ROLE_ADMIN\",\"ROLE_USER\"],\"canVote\":true,\"enabled\":true,\"accountNonExpired\":true,\"accountNonLocked\":true,\"credentialsNonExpired\":true,\"vote\":false}]";
    public static final String MAIN_DATA = "{\"bar\\nvotes:5\":[{\"menuId\":1,\"menuName\":\"breakfast\",\"cookName\":\"Vova\",\"placeId\":1,\"placeName\":null,\"mealTOS\":[{\"mealId\":1,\"mealName\":\"pasta\",\"price\":763,\"menuId\":1,\"menuName\":\"breakfast\",\"menuNames\":[],\"menuIds\":[]}],\"placeNames\":null,\"placeIds\":null},{\"menuId\":2,\"menuName\":\"dinner\",\"cookName\":\"Peter\",\"placeId\":1,\"placeName\":null,\"mealTOS\":[{\"mealId\":2,\"mealName\":\"potatoes\",\"price\":863,\"menuId\":2,\"menuName\":\"dinner\",\"menuNames\":[],\"menuIds\":[]}],\"placeNames\":null,\"placeIds\":null}],\"hotel\\nvotes:6\":[{\"menuId\":1,\"menuName\":\"breakfast\",\"cookName\":\"Vova\",\"placeId\":2,\"placeName\":null,\"mealTOS\":[{\"mealId\":1,\"mealName\":\"pasta\",\"price\":763,\"menuId\":1,\"menuName\":\"breakfast\",\"menuNames\":[],\"menuIds\":[]}],\"placeNames\":null,\"placeIds\":null},{\"menuId\":3,\"menuName\":\"supper\",\"cookName\":\"Wasa\",\"placeId\":2,\"placeName\":null,\"mealTOS\":[{\"mealId\":3,\"mealName\":\"bread\",\"price\":773,\"menuId\":3,\"menuName\":\"supper\",\"menuNames\":[],\"menuIds\":[]}],\"placeNames\":null,\"placeIds\":null}],\"room\\nvotes:8\":[{\"menuId\":2,\"menuName\":\"dinner\",\"cookName\":\"Peter\",\"placeId\":3,\"placeName\":null,\"mealTOS\":[{\"mealId\":2,\"mealName\":\"potatoes\",\"price\":863,\"menuId\":2,\"menuName\":\"dinner\",\"menuNames\":[],\"menuIds\":[]}],\"placeNames\":null,\"placeIds\":null},{\"menuId\":3,\"menuName\":\"supper\",\"cookName\":\"Wasa\",\"placeId\":3,\"placeName\":null,\"mealTOS\":[{\"mealId\":3,\"mealName\":\"bread\",\"price\":773,\"menuId\":3,\"menuName\":\"supper\",\"menuNames\":[],\"menuIds\":[]}],\"placeNames\":null,\"placeIds\":null}]}";
    public static final String ADMIN_CREDENTIALS = "regUser:$2a$08$bn3BrtjfeohY7xfXF00nFOtHbzKuPBZ0np8/AkSJrDN2HKsNlcKHK";
    public static final String MEAL_ONE_MENU_ONE = "{\"mealId\":1,\"mealName\":\"pasta\",\"price\":763,\"menuId\":1,\"menuName\":\"breakfast\",\"menuNames\":[\"breakfast\",\"dinner\",\"supper\"],\"menuIds\":[1,2,3]}";
    public static final String MENU_ONE_PLACE_ONE = "{\"menuId\":1,\"menuName\":\"breakfast\",\"cookName\":\"Vova\",\"placeId\":1,\"placeName\":\"bar\",\"mealTOS\":null,\"placeNames\":[\"bar\",\"hotel\",\"room\"],\"placeIds\":[1,2,3]}";
    public static final String PLACE_ONE = "{\"id\":1,\"name\":\"bar\",\"vote\":5}";

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
