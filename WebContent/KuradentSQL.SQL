/*
Created: 17/06/2015
Modified: 17/06/2015
Project: KuradentModel1.0
Model: Physical model
Database: MySQL 5.0
*/

-- Create tables section -------------------------------------------------

-- Table KURADENT.USUARIO
CREATE DATABASE KURADENT;

CREATE TABLE KURADENT.USUARIO
(
  ID_USUARIO Bigint NOT NULL,
  USUARIO Longtext,
  CONTRASENIA Longtext,
  SESION Bigint,
  ESTADO Bigint,
  INTENTOS Bigint,
  ULTIMO_INTENTO Date
)
;

ALTER TABLE KURADENT.USUARIO ADD PRIMARY KEY (ID_USUARIO)
;


