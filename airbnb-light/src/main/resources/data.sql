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
      (type_hebergement,nb_place,img, available, proprietaire_id, prix_jour, prix_pers)
    values
      ('MAISON',3, "https://www.maisons-moyse.fr/typo3temp/_processed_/csm_slide3_6a822d9089.jpg", true, 1, 504.54, null);

insert
  into
    accommodation
      (type_hebergement,nb_place,img, available, proprietaire_id, prix_jour, prix_pers)
    values
      ('APPARTEMENT',4, null, true, 4, null, 640);

insert
  into
    accommodation
      (type_hebergement,nb_place,img, available, proprietaire_id, prix_jour, prix_pers)
    values
      ('MAISON',5, null, false, 3, 465, null);

insert
  into
    accommodation
      (type_hebergement,nb_place,img, available, proprietaire_id, prix_jour, prix_pers)
    values
      ('MAISON',3, null, true, 2, null, 247);

insert
  into
    accommodation
      (type_hebergement,nb_place,img, available, proprietaire_id, prix_jour, prix_pers)
    values
      ('MAISON',3, null, true, 1, null, 745);
