-- User: "adm-escalade"
-- DROP USER "adm-escalade";

CREATE USER "adm-escalade" WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  NOCREATEROLE
  NOREPLICATION;