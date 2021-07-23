INSERT INTO users (id, "name", email, "password", status, created_on, created_by, role_id, organization_id)
VALUES ('5dc6cba9-7303-458d-ab1e-4447125d864b', 'Marcela', 'marcela@gmail.com', '$2a$10$qs7qQ6taV8fBAqO11jTj0ug0kYWl14fZo/F1oGsjU.1Ju7ImMrhN6', 'ACTIVE', '2021-07-23 14:20:10.260', '5dc6cba9-7303-458d-ab1e-4447125d864b', 'ROLE_ORGANIZATION', '58dc8a98-8c0e-4785-aff8-3d10f457a78a'),
('58dc8a98-8c0e-4785-aff8-3d10f457a58f', 'Christian Barco', 'barcochrist@gmail.com', '$2a$10$IYdZK0dpLlG8N/QLpX3N5.olXV.k/x6LkOrSJzyipy0x7gT4gd/.S', 'ACTIVE', '2021-07-22 12:24:54.000', '58dc8a98-8c0e-4785-aff8-3d10f457a58f', 'ROLE_ORGANIZATION', '58dc8a98-8c0e-4785-aff8-3d10f457a78a'),
('f8170581-2c1d-4160-b6bd-cd72526be54e', 'Diana', 'diana@gmail.com', '$2a$10$ySMizMJ7t/7dsfi0ISLGDeDpnO0L8aPe9JkW9eNkw5Eam6NS61eSO', 'ACTIVE', '2021-07-23 19:22:45.622', 'f8170581-2c1d-4160-b6bd-cd72526be54e', 'ROLE_ORGANIZATION', '58dc8a98-8c0e-4785-aff8-3d10f457a78a')
;

INSERT INTO organizations
(id, identification, "name", country, city, province, address, postal_code, status, created_on, created_by, phone_number, phone_number_2)
VALUES('58dc8a98-8c0e-4785-aff8-3d10f457a78a', '800 176112-4', 'Fundación Paz y Bien', 'CO', 'Cali', 'Valle del Cauca', 'Diagonal 26 I2 No. 80A-25', '5295', 'ACTIVE', '2021-07-22 12:24:54.000', '58dc8a98-8c0e-4785-aff8-3d10f457a58f', '(57) 2-4039640', NULL);
