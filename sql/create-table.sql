-- Table: tb_users

-- DROP TABLE tb_users;

CREATE TABLE tb_users
(
  id bigint NOT NULL,
  email character varying(255),
  name character varying(255),
  username character varying(255),
  CONSTRAINT tb_users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tb_users
  OWNER TO postgres;
