-- Table: users

-- DROP TABLE users;

CREATE TABLE users
(
  id bigint NOT NULL,
  address character varying(255),
  email character varying(255),
  name character varying(255),
  username character varying(255),
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;
