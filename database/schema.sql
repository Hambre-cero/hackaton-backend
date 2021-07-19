create TABLE "users" (
  "id"                      VARCHAR(100) NOT NULL,
  "name"                    VARCHAR(100) NOT NULL,
  "email"                   VARCHAR(50) NOT NULL,
  "password"                VARCHAR NULL,
  "status"                  VARCHAR(10) NOT NULL,
  "created_on"              TIMESTAMP NOT NULL,
  "created_by"              VARCHAR(100) NOT NULL,
  UNIQUE("email"),
  PRIMARY KEY ("id"))
;