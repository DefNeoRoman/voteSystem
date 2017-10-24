DROP TABLE IF EXISTS meals;
DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START 1000;
CREATE TABLE meals (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  price       INTEGER  NOT NULL,
  name        VARCHAR  NOT NULL);