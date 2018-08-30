-- Table: public.property

-- DROP TABLE public.property;

CREATE TABLE public.property
(
  propertyid text,
  street text,
  zipcode integer,
  state text,
  "yearBuilt" integer,
  "lotSizeSqft" integer,
  "finishedSqFt" integer,
  bathrooms numeric,
  bedrooms integer,
  "lastSoldDate" date,
  "lastSoldPrice" numeric,
  currency text,
  rentamount numeric,
  "last-updated" text,
  ownername text,
  phone text,
  email text,
  city text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.property
  OWNER TO tibco;
