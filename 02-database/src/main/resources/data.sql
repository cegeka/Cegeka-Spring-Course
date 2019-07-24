DROP TABLE IF EXISTS ingredients;

CREATE TABLE ingredients (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  glutenfree VARCHAR(1) NOT NULL,
);

INSERT INTO ingredients (name, glutenfree) values
  ('Carrot', '1'),
  ('Carrot', '1'),
  ('Carrot', '1'),
  ('Sandwich', '0'),
  ('Sandwich', '0'),
  ('Sandwich', '0'),
  ('Carrot', '1'),
  ('Hamburger', '1'),
  ('Carrot', '1'),
  ('Hamburger', '1'),
  ('Hamburger', '1'),
  ('Carrot', '1'),
  ('Carrot', '1');