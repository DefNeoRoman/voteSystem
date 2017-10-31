DELETE FROM meals;
DELETE FROM menus;
DELETE FROM menumeals;

INSERT INTO meals (price, name) VALUES
  (763,'макароны'),
  (863,'картофель'),
  (773,'хлеб'),
  (963,'фрукты'),
  (1003,'борщ'),
  (2003,'щи');
INSERT INTO menus (name, cookname) VALUES
  ('завтрак','Вова'),
  ('обед','Петя'),
  ('ужин','Вася');
INSERT INTO places (name, vote) VALUES
  ('бар',5),
  ('гостиница',6),
  ('столовая',8);
INSERT INTO menumeals (meal_id, menu_id) VALUES
(1,1),
(2,2),
(3,3),
(4,1),
(5,2),
(6,3);
INSERT INTO placemenus (menu_id, place_id) VALUES
(1,1),
(1,2),
(2,3),
(2,1),
(3,2),
(3,3);

