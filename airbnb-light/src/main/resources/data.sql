INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(1,	'1@test.fr',	'Nicolas',	'Jourdain',	'$2a$10$dEDwmfzBAKkmpkaTLRBy1ef5QwLNg3ujkkH5LKLhEXbuA4myzW0Zu');

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(2,	'2@test.fr',	'Aurélien',	'Pietrzak',	'$2a$10$dEDwmfzBAKkmpkaTLRBy1ef5QwLNg3ujkkH5LKLhEXbuA4myzW0Zu');

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(3,	'3@test.fr',	'Mikael',	'Desertot',	'$2a$10$dEDwmfzBAKkmpkaTLRBy1ef5QwLNg3ujkkH5LKLhEXbuA4myzW0Zu');

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(4,	'4@test.fr',	'Emmanuel',	'Adam',	'$2a$10$dEDwmfzBAKkmpkaTLRBy1ef5QwLNg3ujkkH5LKLhEXbuA4myzW0Zu');


INSERT INTO `accommodation` (`id`, `adresse`, `available`, `cp`, `description`, `img`, `nb_place`, `nom`, `pays`, `prix_jour`, `prix_pers`, `type_hebergement`, `ville`, `proprietaire_id`) VALUES
(1,	'5 Rue de Lille',	CONV('1', 2, 10) + 0,	'59300',	'Maison de type maisonée située en périphérie de Valenciennes',	'https://www.maisons-moyse.fr/typo3temp/_processed_/csm_slide3_6a822d9089.jpg',	'3',	'Le domaine des 3 Becs',	'France',	504.54,	NULL,	'MAISON',	'Valenciennes',	1),
(2,	NULL,	CONV('1', 2, 10) + 0,	NULL,	NULL,	NULL,	'4',	NULL,	NULL,	NULL,	640,	'APPARTEMENT',	NULL,	4),
(3,	NULL,	CONV('0', 2, 10) + 0,	NULL,	NULL,	NULL,	'5',	NULL,	NULL,	465,	NULL,	'MAISON',	NULL,	3),
(4,	NULL,	CONV('1', 2, 10) + 0,	NULL,	NULL,	NULL,	'3',	NULL,	NULL,	NULL,	247,	'MAISON',	NULL,	2),
(5,	NULL,	CONV('1', 2, 10) + 0,	NULL,	NULL,	NULL,	'3',	NULL,	NULL,	NULL,	745,	'MAISON',	NULL,	1);
