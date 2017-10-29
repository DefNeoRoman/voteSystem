DELETE FROM meals;
DELETE FROM menus;
DELETE FROM restaurants;


INSERT INTO meals (price, name,menu_id) VALUES
  (763,'макароны',9),
  (863,'картофель',8),
  (773,'хлеб',7),
  (963,'фрукты',9),
  (1003,'борщ',8),
  (2003,'щи',7);
INSERT INTO menus (name, cookname,restaurant_id) VALUES
  ('завтрак','Вова',10),
  ('обед','Петя',11),
  ('ужин','Вася',12);

INSERT INTO restaurants (name, votes) VALUES
  ('бар',5),
  ('гостиница',6),
  ('пляж',7);
