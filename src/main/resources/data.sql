DELETE FROM meals;
DELETE FROM menus;
DELETE FROM menumeals;

INSERT INTO meals (price, name) VALUES
  (763,'макароныffff'),
  (863,'картофельffff'),
  (773,'хлебffff'),
  (963,'фруктыffff'),
  (1003,'борщffff'),
  (2003,'щиfff');
INSERT INTO menus (name, cookname) VALUES
  ('завтрак','Вова'),
  ('обед','Петя'),

  ('ужин','Вася'),
  ('ланч','Дима'),
  ('фастфуд','Егор');
INSERT INTO menumeals (name, menu_id, meal_id) VALUES
  ('Заметка1',1000,1000),
  ('Заметка2',1000,1001),
  ('Заметка5',1000,1002),
  ('Заметка3',1001,1004),
  ('Заметка4',1001,1005);
