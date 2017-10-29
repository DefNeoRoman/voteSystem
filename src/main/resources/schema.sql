DROP TABLE IF EXISTS meals cascade ;
DROP TABLE IF EXISTS menus cascade;
DROP TABLE IF EXISTS restaurants cascade;

DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START 1;
CREATE TABLE restaurants
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR  NOT NULL,
  votes       INTEGER  NOT NULL
  );
  CREATE TABLE menus
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  restaurant_id     INTEGER  NOT NULL,
  name              VARCHAR  NOT NULL,
  cookname          VARCHAR  NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE ON UPDATE CASCADE
  );
CREATE TABLE meals
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  menu_id     INTEGER  NOT NULL,
  price       INTEGER  NOT NULL,
  name        VARCHAR  NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menus (id) ON DELETE CASCADE ON UPDATE CASCADE
  );



