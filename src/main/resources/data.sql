INSERT INTO products_categories (category) VALUES ('Herramientas');
INSERT INTO products_categories (category) VALUES ('De seguridad');

INSERT INTO suppliers (name, health_insurance, authorized, address) VALUES ('Supplier One', 1234567890, true, 987654321);
INSERT INTO suppliers (name, health_insurance, authorized, address) VALUES ('Supplier Two', 9876543210, false, 123456789);
INSERT INTO suppliers (name, health_insurance, authorized, address) VALUES ('Supplier Three', 1122334455, true, 5566778899);
INSERT INTO Products_Categories (category,created_datetime, created_user, last_updated_datetime, last_updated_user)
VALUES ('Herramienta',NOW(),1,NOW(),1),
       ('Consumible',NOW(),1,NOW(),1),
       ('Tegnologia',NOW(),1,NOW(),1),
       ('Otros',NOW(),1,NOW(),1);


INSERT INTO Products (name, reusable, category_id, min_Quantity_Warning, created_datetime, created_user, last_updated_datetime, last_updated_user)
VALUES ('Pala', true, 1, 3, NOW(), 1, NOW(), 1),
       ('Foco', false, 1, 10, NOW(), 1, NOW(), 1),
       ('Tablet', true, 1, 5, NOW(), 1, NOW(), 1),
       ('Camara de seguridad', true, 1, 2, NOW(), 1, NOW(), 1),
       ('Repelente Off', false, 1, 5, NOW(), 1, NOW(), 1);

INSERT INTO Products_Details (product_id, description, supplier_id, state, created_datetime, created_user, last_updated_datetime, last_updated_user)
VALUES (1,'Pala de metal',1,'STOCKED',NOW(), 1, NOW(), 1),
       (1,'Pala de madera',2,'STOCKED',NOW(), 1, NOW(), 1),
       (1,'Pala de metal',1,'STOCKED',NOW(), 1, NOW(), 1),
       (1,'Pala de madera',3,'STOCKED',NOW(), 1, NOW(), 1),
       (2,'Foco Philips',3,'STOCKED',NOW(), 1, NOW(), 1);

