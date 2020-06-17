
CREATE USER vendingmachineuser WITH password 'pass';

CREATE DATABASE vendingmachine
  WITH OWNER = vendingmachineuser
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE public.person
(
  id serial,
  nickname character varying(128),
  password character varying(64),
  balance numeric(10,2),
  CONSTRAINT person_prim_key PRIMARY KEY (id),
  CONSTRAINT person_nickname_unique UNIQUE (nickname)
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.person
  OWNER TO vendingmachineuser;

CREATE TABLE public.product
(
  id serial,
  title character varying(256),
  price numeric(3,2),
  amount numeric(3,0),
  CONSTRAINT product_prim_key PRIMARY KEY (id),
  CONSTRAINT product_title_unique UNIQUE (title)
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.product
  OWNER TO vendingmachineuser;


INSERT INTO public.person(nickname, password, balance)
VALUES ('Max', 'pass1', 40);

INSERT INTO public.person(nickname, password, balance)
VALUES ('Peter', 'pass2', 90);

INSERT INTO public.product(title, price, amount)
VALUES ('Cola', 1.4, 5);

INSERT INTO public.product(title, price, amount)
VALUES ('Fanta', 0.8, 10);

INSERT INTO public.product(title, price, amount)
VALUES ('Sprite', 1.2, 15);

