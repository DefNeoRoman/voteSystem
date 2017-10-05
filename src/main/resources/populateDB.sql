
DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM vote_stories;
--будет пустая
DELETE FROM menus;
DELETE FROM places;
DELETE FROM place_menu;
DELETE FROM menu_meal;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 1;


INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

-- password
INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (user_id, role) VALUES
  (1,'ROLE_USER'),
  (2,'ROLE_ADMIN');

INSERT INTO meals (price, description) VALUES
  (76,'макароны'),
  (86,'картофель'),
  (77,'хлеб'),
  (96,'фрукты'),
  (100,'борщ'),
  (200,'щи');
  INSERT INTO menus (name) VALUES
  ('завтрак'),
  ('обед'     ),
  ('ужин'     ),
  ('ланч'     ),
  ('бизнес-ланч'),
  ('в дорогу'  ),
  ('второй ужин');
  INSERT INTO places (name) VALUES
  ('ресторан пять звезд'),
  ('кафе'            ),
  ('столовая'          ),
  ('фастфуд'           ),
  ('пиццерия'          ),
  ('гостиница'         ),
  ('бар'              );
  INSERT INTO place_menu (place_id,menu_id) VALUES
  (1,1),
  (1,2),
  (1,3),
  (2,4),
  (2,5),
  (3,2),
  (4,6),
  (5,4),
  (6,3),
  (7,7);
  INSERT INTO menu_meal (menu_id,meal_id) VALUES
  (1,1),
  (2,2),
  (3,3),
  (4,4),
  (5,5),
  (6,6),
  (7,6);