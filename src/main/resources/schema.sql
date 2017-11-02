DROP TABLE IF EXISTS meals cascade ;
DROP TABLE IF EXISTS menus cascade;
DROP TABLE IF EXISTS places cascade;
DROP TABLE IF EXISTS users cascade;
DROP TABLE IF EXISTS user_roles cascade;
DROP TABLE IF EXISTS menumeals cascade;
DROP TABLE IF EXISTS placemenus cascade;



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
CREATE TABLE places
(
  id          bigserial PRIMARY KEY,

  name        VARCHAR  NOT NULL,
  vote        INTEGER  NOT NULL
  );
CREATE TABLE users
(
  id               bigserial PRIMARY KEY,
  name             VARCHAR                  NOT NULL,
  email            VARCHAR                  NOT NULL,
  password         VARCHAR                  NOT NULL,
  register_date    TIMESTAMP DEFAULT now()  NOT NULL,
  enabled          BOOL DEFAULT TRUE        NOT NULL,
  isVote           BOOL DEFAULT FALSE       NOT NULL,
  canVote          BOOL DEFAULT TRUE        NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);
CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE menumeals
(
  meal_id    bigint  NOT NULL REFERENCES meals (id) ON UPDATE CASCADE ON DELETE CASCADE,
  menu_id    bigint  NOT NULL REFERENCES menus (id) ON UPDATE CASCADE,

  amount     numeric NOT NULL DEFAULT 1,
  CONSTRAINT menu_meal_pkey PRIMARY KEY (menu_id, meal_id)
  );
 CREATE TABLE placemenus
(
  menu_id     bigint  NOT NULL REFERENCES menus (id) ON UPDATE CASCADE ON DELETE CASCADE,
  place_id    bigint  NOT NULL REFERENCES places (id) ON UPDATE CASCADE,

  amount     numeric NOT NULL DEFAULT 1,
  CONSTRAINT place_menu_pkey PRIMARY KEY (place_id, menu_id)
  );
