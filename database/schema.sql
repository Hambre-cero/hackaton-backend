create TABLE "users" (
  "id"                      VARCHAR(100) NOT NULL,
  "name"                    VARCHAR(100) NOT NULL,
  "email"                   VARCHAR(50) NOT NULL,
  "password"                VARCHAR NULL,
  "role_id"                 VARCHAR(100) NOT NULL,
  "status"                  VARCHAR(10) NOT NULL,
  "created_on"              TIMESTAMP NOT NULL,
  "created_by"              VARCHAR(100) NOT NULL,
  "organization_id"         VARCHAR(100) NULL,
  UNIQUE("email"),
  PRIMARY KEY ("id"))
;

create TABLE "organizations" (
  "id"                      VARCHAR(100) NOT NULL,
  "identification"          VARCHAR(100) NOT NULL,
  "name"                    VARCHAR(100) NOT NULL,
  "country"                 VARCHAR(50) NOT NULL,
  "province"                VARCHAR(100) NOT NULL,
  "city"                    VARCHAR(100) NOT NULL,
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

create TABLE "announces" (
  "id"                      VARCHAR(100) NOT NULL,
  "title"                   VARCHAR(100) NOT NULL,
  "description"             VARCHAR NOT NULL,
  "status"                  VARCHAR(10) NOT NULL,
  "created_on"              TIMESTAMP NOT NULL,
  "created_by"              VARCHAR(100) NOT NULL,
  PRIMARY KEY ("id"))
;

create TABLE "donations" (
  "id"                      VARCHAR(100) NOT NULL,
  "donor_id"                VARCHAR(100) NOT NULL,
  "announce_id"             VARCHAR(100) NOT NULL,
  "note"                    VARCHAR NULL,
  "status"                  VARCHAR(10) NOT NULL,
  "created_on"              TIMESTAMP NOT NULL,
  "created_by"              VARCHAR(100) NOT NULL,
  PRIMARY KEY ("id"))
;

create TABLE "files" (
  "id"                      VARCHAR(100) NOT NULL,
  "title"                   VARCHAR(200) NOT NULL,
  "url"                     VARCHAR NOT NULL,
  "record_id"               VARCHAR(100) NOT NULL,
  "created_on"              TIMESTAMP NOT NULL,
  "created_by"              VARCHAR(100) NOT NULL,
  PRIMARY KEY ("id"))
;