INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(1,	'1@test.fr',	'Nicolas',	'Jourdain',	'$2a$10$dEDwmfzBAKkmpkaTLRBy1ef5QwLNg3ujkkH5LKLhEXbuA4myzW0Zu');

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(2,	'2@test.fr',	'Aurélien',	'Pietrzak',	'$2a$10$dEDwmfzBAKkmpkaTLRBy1ef5QwLNg3ujkkH5LKLhEXbuA4myzW0Zu');

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(3,	'3@test.fr',	'Mikael',	'Desertot',	'$2a$10$dEDwmfzBAKkmpkaTLRBy1ef5QwLNg3ujkkH5LKLhEXbuA4myzW0Zu');

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(4,	'4@test.fr',	'Emmanuel',	'Adam',	'$2a$10$dEDwmfzBAKkmpkaTLRBy1ef5QwLNg3ujkkH5LKLhEXbuA4myzW0Zu');


INSERT INTO `accommodation` (`id`, `adresse`, `available`, `cp`, `description`, `image`, `nb_place`, `nom`, `pays`, `prix_jour`, `prix_pers`, `type_hebergement`, `ville`, `proprietaire_id`) VALUES
(1,	'1 Rue de Lille',	CONV('1', 2, 10) + 0,	'59301',	'Maison située en périphérie de Valenciennes',	'https://www.maisons-moyse.fr/typo3temp/_processed_/csm_slide3_6a822d9089.jpg',	'1',	'Le domaine du Bec',	'France',	104.54,	NULL,	'MAISON',	'Valenciennes',	1),
(2,	'2 Rue de Lille',	CONV('1', 2, 10) + 0,	'59302',	'Maison située en périphérie de Valenciennes',	'https://www.maisons-moyse.fr/typo3temp/_processed_/csm_slide3_6a822d9089.jpg',	'2',	'Le domaine des 2 Becs',	'France',	204.54,	NULL,	'MAISON',	'Valenciennes',	2),
(3,	'3 Rue de Lille',	CONV('0', 2, 10) + 0,	'59303',	'Maison située en périphérie de Valenciennes',	'https://www.maisons-moyse.fr/typo3temp/_processed_/csm_slide3_6a822d9089.jpg',	'3',	'Le domaine des 3 Becs',	'France',	304.54,	NULL,	'MAISON',	'Valenciennes',	3),
(4,	'4 Rue de Lille',	CONV('1', 2, 10) + 0,	'59304',	'Maison située en périphérie de Valenciennes',	'https://www.maisons-moyse.fr/typo3temp/_processed_/csm_slide3_6a822d9089.jpg',	'4',	'Le domaine des 4 Becs',	'France',	404.54,	NULL,	'MAISON',	'Valenciennes',	4),
(5,	'5 Rue de Lille',	CONV('1', 2, 10) + 0,	'59305',	'Maison située en périphérie de Valenciennes',	'https://www.maisons-moyse.fr/typo3temp/_processed_/csm_slide3_6a822d9089.jpg',	'5',	'Le domaine des 5 Becs',	'France',	504.54,	NULL,	'MAISON',	'Valenciennes',	1),
(6,	'6 Rue de Lille',	CONV('1', 2, 10) + 0,	'59306',	'Maison située en périphérie de Valenciennes',	'https://www.maisons-moyse.fr/typo3temp/_processed_/csm_slide3_6a822d9089.jpg',	'6',	'Le domaine des 6 Becs',	'France',	604.54,	NULL,	'MAISON',	'Valenciennes',	2)
