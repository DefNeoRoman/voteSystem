DROP TABLE IF EXISTS meals cascade ;
DROP TABLE IF EXISTS menus cascade;
DROP TABLE IF EXISTS menumeals cascade;



CREATE TABLE meals
(
  id          bigserial PRIMARY KEY,
  price       INTEGER  NOT NULL,
  name        VARCHAR  NOT NULL
  );
CREATE TABLE menus
(
  id          bigserial PRIMARY KEY,

  name        VARCHAR  NOT NULL,
  cookname    VARCHAR  NOT NULL
  );

CREATE TABLE menumeals
(
  meal_id    bigint  NOT NULL REFERENCES meals (id) ON UPDATE CASCADE ON DELETE CASCADE,
  menu_id    bigint  NOT NULL REFERENCES menus (id) ON UPDATE CASCADE,

  amount     numeric NOT NULL DEFAULT 1,
  CONSTRAINT menu_meal_pkey PRIMARY KEY (menu_id, meal_id)
  );
