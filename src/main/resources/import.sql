-- INSERT USUÁRIOS - pass: 123
INSERT INTO tb_user(display_name, username, password) VALUES ('Usuário 1', 'user1','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO tb_user(display_name, username, password) VALUES ('Usuário 2', 'user2','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');

--INSERT CATEGORIAS
insert into category (name, description, user_id) values ('Deposito - User 1', 'Deposito - User 1', 1);
insert into category (name, description, user_id) values ('Saque - User 1', 'Saque - User 1', 1);
insert into category (name, description, user_id) values ('Transferência - User 1', 'Transferência - User 1', 1);
insert into category (name, description, user_id) values ('Deposito - User 2', 'Deposito - User 2', 2);
insert into category (name, description, user_id) values ('Saque - User 2', 'Saque - User 2', 2);
insert into category (name, description, user_id) values ('Transferência - User 2', 'Transferência - User 2', 2);

--INSERT CONTAS
insert into account (agency, bank, number, name, amount, user_id) values (111, 111, 111, 'Conta Nubank User 1', 550.90, 1)
insert into account (agency, bank, number, name, amount, user_id) values (111, 111, 111, 'Conta Inter User 1', 550.90, 1)
insert into account (agency, bank, number, name, amount, user_id) values (222, 222, 222, 'Conta Nubank User 2', 250.90, 2)
insert into account (agency, bank, number, name, amount, user_id) values (222, 222, 222, 'Conta Inter User 2', 250.90, 2)

--INSERT MOVIMENTAÇÕES
--insert into financial_movement (date, description, situation, type, value, account_id, account_to_transfer_id, category_id) values (current_timestamp, 'Deposito', 1, 0, 50.00, 1, null, 1);
--insert into financial_movement (date, description, situation, type, value, account_id, account_to_transfer_id, category_id) values (current_timestamp, 'Saque', 1, 1, 10.00, 2, null, 1);
--insert into financial_movement (date, description, situation, type, value, account_id, account_to_transfer_id, category_id) values (current_timestamp, 'Transferência', 1, 2, 50.00, 2, 1, 1);
--insert into financial_movement (date, description, situation, type, value, account_id, account_to_transfer_id, category_id) values (current_timestamp, 'Deposito', 1, 0, 50.00, 1, null, 1);
--insert into financial_movement (date, description, situation, type, value, account_id, account_to_transfer_id, category_id) values (current_timestamp, 'Saque', 1, 1, 10.00, 2, null, 1);
--insert into financial_movement (date, description, situation, type, value, account_id, account_to_transfer_id, category_id) values (current_timestamp, 'Transferência', 1, 2, 50.00, 2, 1, 1);
