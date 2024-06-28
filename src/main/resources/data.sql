INSERT INTO CLIENT(client_id,name,gender,birth_date,identification_code,address,phone_number,password,is_enabled) VALUES (1,'Carlos Albuja', 0, '1997-02-12', '1700234854', 'Casa 2 junto a la 5', '+5939999456','clave123', true);
INSERT INTO CLIENT(client_id,name,gender,birth_date,identification_code,address,phone_number,password,is_enabled) VALUES (2,'Carlos Albuja 2', 1, '1980-02-12', '1700200000', 'Alado del parque', '0999786544','clave', true);
INSERT INTO CLIENT(client_id,name,gender,birth_date,identification_code,address,phone_number,password,is_enabled) VALUES (3,'Carlos Albuja 3', 2, '1900-02-12', '1700000000', 'Parque numero 2', '(02)22222222','cla', true);

INSERT INTO ACCOUNT(client,number,type,available_balance,is_enabled) VALUES (1, '000001', 0, 100.00, true);
INSERT INTO ACCOUNT(client,number,type,available_balance,is_enabled) VALUES (1, '000002', 1, 10.00, false);
INSERT INTO ACCOUNT(client,number,type,available_balance,is_enabled) VALUES (2, '000003', 0, 1.00, true);
INSERT INTO ACCOUNT(client,number,type,available_balance,is_enabled) VALUES (3, '000004', 1, 0.00, true);

INSERT INTO TRANSACTION(id,account,date,type,amount,current_balance) VALUES ('cc39df2c-87c0-493c-b0d3-544eaf938b10', '000001', '2024-01-012T07:58:30.996', 0, 10.00, 90.00);
INSERT INTO TRANSACTION(id,account,date,type,amount,current_balance) VALUES ('3facba54-4e1b-473b-8a26-0614dc7ddd52', '000001', '2024-01-012T07:59:00.003', 0, 10.00, 100.00);
INSERT INTO TRANSACTION(id,account,date,type,amount,current_balance) VALUES ('607044c9-a016-4cc9-a110-989d0c4b1335', '000003', '2024-01-012T07:57:00.045', 0, 10.00, 10.00);
INSERT INTO TRANSACTION(id,account,date,type,amount,current_balance) VALUES ('da25d5ba-55a6-4ebd-8429-cda12b76a6f9', '000003', '2024-01-012T08:00:15.002', 1, 9.00, 1.00);
INSERT INTO TRANSACTION(id,account,date,type,amount,current_balance) VALUES ('4195191b-cd97-4f59-99bc-58de9ca52a08', '000004', '2024-01-012T07:59:00.004', 1, 10000.00, 0.00);
