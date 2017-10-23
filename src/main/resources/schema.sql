DROP TABLE IF EXISTS meals;
CREATE TABLE meals (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  price       INTEGER   NOT NULL,
  name        TEXT      NOT NULL,


);