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

INSERT INTO menumeals (menu_id, meal_id) VALUES
(9,1),
(9,2),
(8,3),
(8,4),
(7,5),
(7,6);
