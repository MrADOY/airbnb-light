INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(1,	'1@test.fr',	'Nicolas',	'Jourdain',	'$2a$10$dEDwmfzBAKkmpkaTLRBy1ef5QwLNg3ujkkH5LKLhEXbuA4myzW0Zu');

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(2,	'2@test.fr',	'Aurélien',	'Pietrzak',	'$2a$10$dEDwmfzBAKkmpkaTLRBy1ef5QwLNg3ujkkH5LKLhEXbuA4myzW0Zu');

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(3,	'3@test.fr',	'Mikael',	'Desertot',	'$2a$10$dEDwmfzBAKkmpkaTLRBy1ef5QwLNg3ujkkH5LKLhEXbuA4myzW0Zu');

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(4,	'4@test.fr',	'Emmanuel',	'Adam',	'$2a$10$dEDwmfzBAKkmpkaTLRBy1ef5QwLNg3ujkkH5LKLhEXbuA4myzW0Zu');

insert
  into
    accommodation
      (type_hebergement,nb_place,img, available)
    values
      ('MAISON',3, null, true);

insert
  into
    accommodation
      (type_hebergement,nb_place,img, available)
    values
      ('APPARTEMENT',4, null, true);

insert
  into
    accommodation
      (type_hebergement,nb_place,img, available)
    values
      ('MAISON',5, null, false);

insert
  into
    accommodation
      (type_hebergement,nb_place,img, available)
    values
      ('MAISON',3, null, true);

insert
  into
    accommodation
      (type_hebergement,nb_place,img, available)
    values
      ('MAISON',3, null, true);
