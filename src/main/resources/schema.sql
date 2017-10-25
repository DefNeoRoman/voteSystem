DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS menus;
DROP TABLE IF EXISTS menumeals;

DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START 1000;
CREATE TABLE meals
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  price       INTEGER  NOT NULL,
  name        VARCHAR  NOT NULL
  );
CREATE TABLE menus
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),

  name        VARCHAR  NOT NULL,
  cookname    VARCHAR  NOT NULL
  );
CREATE TABLE menumeals
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR  NOT NULL,
  menu_id     INTEGER  NOT NULL,
  meal_id     INTEGER  NOT NULL
  );
