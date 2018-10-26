-- Table: public.creditscore

-- DROP TABLE public.creditscore;

CREATE TABLE public.creditscore
(
    firstname text COLLATE pg_catalog."default",
    lastname text COLLATE pg_catalog."default",
    ssn text COLLATE pg_catalog."default",
    "dateofBirth" text COLLATE pg_catalog."default",
    ficoscore integer,
    rating text COLLATE pg_catalog."default",
    numofpulls integer
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

