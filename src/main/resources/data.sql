DELETE FROM meals;
DELETE FROM menus;
DELETE FROM places;
DELETE FROM users;
DELETE FROM votestory;
DELETE FROM user_roles;
DELETE FROM menumeals;
DELETE FROM placemenus;

INSERT INTO meals (price, name) VALUES
  (763,'pasta'),
  (863,'potatoes'),
  (773,'bread');

INSERT INTO menus (name, cookname) VALUES
  ('breakfast','Vova'),
  ('dinner','Peter'),
  ('supper','Wasa');
INSERT INTO places (name, vote) VALUES
  ('bar',5),
  ('hotel',6),
  ('room',8);
  INSERT INTO users (name,
                    email,
                    password)
  VALUES
  ('regular','regular@yandex.ru','$2a$08$bn3BrtjfeohY7xfXF00nFOtHbzKuPBZ0np8/AkSJrDN2HKsNlcKHK'),
  --12345678
  ('admin','admin@gmail.com','$2a$08$bn3BrtjfeohY7xfXF00nFOtHbzKuPBZ0np8/AkSJrDN2HKsNlcKHK'),
  --12345678
  ('regUser','regUser@mail.com','$2a$08$bn3BrtjfeohY7xfXF00nFOtHbzKuPBZ0np8/AkSJrDN2HKsNlcKHK');
INSERT INTO user_roles (role, user_id)
VALUES
  ('ROLE_USER', 1),
  ('ROLE_ADMIN', 2),
  ('ROLE_USER', 3),
  ('ROLE_ADMIN', 3);
INSERT INTO votestory (user_id,place_id)
 VALUES (1,1);

INSERT INTO menumeals (meal_id, menu_id) VALUES
(1,1),
(2,2),
(3,3);

INSERT INTO placemenus (menu_id, place_id) VALUES
(1,1),
(1,2),
(2,3),
(2,1),
(3,2),
(3,3);

