INSERT INTO Products_States (state,created_datetime, created_user, last_updated_datetime, last_updated_user)
VALUES ('En uso',NOW(),1,NOW(),1),
       ('En mantenimiento',NOW(),1,NOW(),1),
       ('Almacenado',NOW(),1,NOW(),1);

INSERT INTO Products_Categories (category,created_datetime, created_user, last_updated_datetime, last_updated_user)
VALUES ('Herramienta',NOW(),1,NOW(),1),
       ('Consumible',NOW(),1,NOW(),1),
       ('Tegnologia',NOW(),1,NOW(),1),
       ('Otros',NOW(),1,NOW(),1);
