--для каскадного удаления таблицу users ставить в самом конце, иначе удаление не пройдет
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS vote_stories;
DROP TABLE IF EXISTS menus;
DROP TABLE IF EXISTS places;
DROP TABLE IF EXISTS place_menu;
DROP TABLE IF EXISTS menu_meal;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;
--начинать создание с users
--1
CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                  NOT NULL,
  email            VARCHAR                  NOT NULL,
  password         VARCHAR                  NOT NULL,
  register_date    TIMESTAMP DEFAULT now()  NOT NULL,
  enabled          BOOL DEFAULT TRUE        NOT NULL,
  is_vote          BOOL DEFAULT FALSE       NOT NULL,
  can_vote         BOOL DEFAULT FALSE       NOT NULL,

);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);
--2
CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
--3
CREATE TABLE meals (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),

  price       INTEGER   NOT NULL,
  description TEXT      NOT NULL,


);
--4
CREATE TABLE vote_stories(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER                 NOT NULL,
  menu_id     INTEGER                 NOT NULL,
  place_id    INTEGER                 NOT NULL,
  vote_date   TIMESTAMP DEFAULT now() NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
--5
CREATE TABLE menus (
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name          INTEGER   NOT NULL,


);
--6
CREATE TABLE menu_meal (
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  menu_id       INTEGER   NOT NULL,

  meal_id       INTEGER   NOT NULL

);
--7
CREATE TABLE place_menu (
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  place_id      INTEGER   NOT NULL,
  menu_id       INTEGER   NOT NULL


);
--8
CREATE TABLE places(
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name           VARCHAR                 NOT NULL,
  register_date  TIMESTAMP DEFAULT now() NOT NULL,
  votes          INTEGER                 NOT NULL


);


