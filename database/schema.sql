create TABLE "users" (
  "id"                      VARCHAR(100) NOT NULL,
  "name"                    VARCHAR(100) NOT NULL,
  "email"                   VARCHAR(50) NOT NULL,
  "password"                VARCHAR NULL,
  "role_id"                 VARCHAR(100) NOT NULL,
  "organization_id"         VARCHAR(100) NULL,
  "status"                  VARCHAR(10) NOT NULL,
  "created_on"              TIMESTAMP NOT NULL,
  "created_by"              VARCHAR(100) NOT NULL,
  UNIQUE("email"),
  PRIMARY KEY ("id"))
;

create TABLE "organizations" (
  "id"                      VARCHAR(100) NOT NULL,
  "identification"          VARCHAR(100) NOT NULL,
  "name"                    VARCHAR(100) NOT NULL,
  "country"                 VARCHAR(50) NOT NULL,
  "city"                    VARCHAR(100) NOT NULL,
  "province"                VARCHAR(100) NOT NULL,
  "address"                 VARCHAR(200) NOT NULL,
  "postal_code"             VARCHAR(50) NULL,
  "phone_number"            VARCHAR(50) NOT NULL,
  "secondary_phone_number"  VARCHAR(50) NULL,
  "status"                  VARCHAR(10) NOT NULL,
  "created_on"              TIMESTAMP NOT NULL,
  "created_by"              VARCHAR(100) NOT NULL,
  UNIQUE("identification"),
  PRIMARY KEY ("id"))
;