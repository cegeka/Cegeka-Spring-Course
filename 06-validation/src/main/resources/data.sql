DROP TABLE IF EXISTS DIVES;

-- All fields intentionally left nullable because validation needs to happen in Java code, not on SQL level
CREATE TABLE DIVES (
  id VARCHAR(40)  PRIMARY KEY,
  name VARCHAR(100),
  difficulty INT
);