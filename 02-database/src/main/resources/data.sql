DROP TABLE IF EXISTS order_ingredients;
DROP TABLE IF EXISTS ingredients;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customer;


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

CREATE TABLE customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  senior_discount VARCHAR(1) NOT NULL
);

CREATE TABLE orders (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  order_date DATE NOT NULL,
  customer_id VARCHAR(100) NOT NULL,
);

ALTER TABLE orders
    ADD FOREIGN KEY (customer_id)
    REFERENCES customer(id);

CREATE TABLE order_ingredients (
  order_id INT,
  ingredient_id INT,
  PRIMARY KEY(order_id, ingredient_id)
);

ALTER TABLE order_ingredients
    ADD FOREIGN KEY (order_id)
    REFERENCES orders(id);

ALTER TABLE order_ingredients
    ADD FOREIGN KEY (ingredient_id)
    REFERENCES ingredients(id);

INSERT INTO customer (name, last_name, senior_discount) values
  ('Paul', 'Pesto', '0'),
  ('Larry', 'Lasagna', '1'),
  ('Polly', 'Pizza', '1'),
  ('Ralph', 'Ravioli', '0');

INSERT INTO orders (order_date, customer_id) values
  (parsedatetime('17-09-2012', 'dd-MM-yyyy'), '1'),
  (parsedatetime('17-09-2013', 'dd-MM-yyyy'), '1'),
  (parsedatetime('17-09-2014', 'dd-MM-yyyy'), '1'),
  (parsedatetime('17-09-2015', 'dd-MM-yyyy'), '2'),
  (parsedatetime('17-09-2016', 'dd-MM-yyyy'), '2'),
  (parsedatetime('17-09-2017', 'dd-MM-yyyy'), '3'),
  (parsedatetime('17-09-2018', 'dd-MM-yyyy'), '3'),
  (parsedatetime('17-09-2019', 'dd-MM-yyyy'), '2');

INSERT INTO order_ingredients (order_id, ingredient_id) values
  (1,1),
  (1,4),
  (1,8),
  (5,6),
  (5,7),
  (6,1),
  (6,2),
  (6,8);