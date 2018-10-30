

INSERT INTO `user` (`email`, `enabled`, `first_name`, `last_name`, `password`) VALUES
  ('user@mail.com', 0, 'xxx', 'xxx', 'haslo');
INSERT INTO `user_role` (`description`, `role`) VALUES ('default role for user', 'ROLE_USER');

INSERT INTO `user_roles` (`user_id`, `roles_id`) VALUES (1, 1);


INSERT INTO `car_details` (`brand`, `mileage`, `model`) VALUES ('Ford', '12555', 'Focus');
INSERT INTO `car` (`plate`, `car_details_id_car_details`) VALUES ('XXX1111', '1');


INSERT INTO `car_details` (`brand`, `mileage`, `model`) VALUES ('BMW', '10000', 'F10');
INSERT INTO `car` (`plate`, `car_details_id_car_details`) VALUES ('XX11111', '2');

INSERT INTO `driver` (`first_name`, `last_name`, `pesel`) VALUES ('Dawid', 'Nowak', '12121212121');
INSERT INTO `driver` (`first_name`, `last_name`, `pesel`) VALUES ('Robert', 'Nowak', '21381272121');
INSERT INTO `driver` (`first_name`, `last_name`, `pesel`) VALUES ('Janusz', 'Kowalski', '21311612721');


INSERT INTO `journey_order` (`date`, `destination`, `car_id_car`, `driver_id_driver`) VALUES ('2018-10-20', 'Germany', '1', '1');
INSERT INTO `journey_order` (`date`, `destination`, `car_id_car`, `driver_id_driver`) VALUES ('2018-10-20', 'France', '2', '3');
