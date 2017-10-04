
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
  ('ROLE_USER',  1),
  ('ROLE_ADMIN', 2);

INSERT INTO meals (user_id, price, description) VALUES
  (2,76,'макароны'),
  (2,86,'картофель'),
  (2,77,'хлеб'),
  (2,96,'фрукты'),
  (2,100,'борщ'),
  (2,200,'щи');
  INSERT INTO menus (name, user_id) VALUES
  ('завтрак',     2),
  ('обед',        2),
  ('ужин',        2),
  ('ланч',        2),
  ('бизнес-ланч', 2),
  ('в дорогу',    2),
  ('второй ужин', 2);
  INSERT INTO places (name, user_id) VALUES
  ('ресторан пять звезд', 2),
  ('кафе',                2),
  ('столовая',            2),
  ('фастфуд',             2),
  ('пиццерия',            2),
  ('гостиница',           2),
  ('бар',                 2);
  INSERT INTO place_menu (place_id,menu_id, user_id) VALUES
  (1,1,2),
  (1,2,2),
  (1,3,2),
  (2,4,2),
  (2,5,2),
  (3,2,2),
  (4,6,2),
  (5,4,2),
  (6,3,2),
  (7,7,2);
  INSERT INTO menu_meal (menu_id,user_id,meal_id) VALUES
  (1,2,1),
  (2,2,2),
  (3,2,3),
  (4,2,4),
  (5,2,5),
  (6,2,6),
  (7,2,6);