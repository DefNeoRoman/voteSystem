DROP TABLE IF EXISTS meals cascade ;
DROP TABLE IF EXISTS menus cascade;
DROP TABLE IF EXISTS menumeals cascade;

DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START 1;
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

  menu_id    INTEGER  NOT NULL ,
  meal_id    INTEGER  NOT NULL ,

    PRIMARY KEY (menu_id,meal_id),
  CONSTRAINT fk_menumeals_menu FOREIGN KEY (menu_id) REFERENCES menus (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_menumeals_meal FOREIGN KEY (meal_id) REFERENCES meals (id) ON DELETE CASCADE ON UPDATE CASCADE

  );
