/* @author Theresa Reus
 @author André Berberich*/

INSERT INTO `user` (`user_id`, `creation_date`, `deletion_date`, `email`, `pw_hash`) VALUES (NULL, '2017-10-01 00:00:00', NULL, 'test@test.de', 'sfhjdsagfkaeshjdkfaksdfkjadshfkjdhaks'), (NULL, '2017-10-15 00:00:00', NULL, 'test2@test.de', 'dfndakjsfhadsjfncalkhesofed');

INSERT INTO `tag` (`tag_id`, `name`) VALUES (NULL, 'bio'), (NULL, 'vegan');
INSERT INTO `tag` (`tag_id`, `name`) VALUES (NULL, 'einfach'), (NULL, 'aufwändig');

INSERT INTO `ingredient` (`id`, `cost_per_unit`, `k_cal_per_unit`, `name`, `unit`, `pic_id`) VALUES (NULL, '0.0007996', '0.77', 'Kartoffel', '2', NULL);
INSERT INTO `ingredient` (`id`, `cost_per_unit`, `k_cal_per_unit`, `name`, `unit`, `pic_id`) VALUES (NULL, '0.01125', '3.57', 'Edamer', '2', NULL);

INSERT INTO `recipe` (`rezept_id`, `create_date`, `description`, `difficulty`, `name`, `user_id`) VALUES (NULL, '2017-10-08 00:00:00', 'Leckere Kartoffeln mit Käse - das beste was man mit Kartoffeln machen kann', '1', 'Kartoffeln mit Käse', '1');

INSERT INTO `recipe_ingredient` (`amount`, `amount_per_person`, `cost_per_unit`, `ingredient_id`, `recipe_id`) VALUES ('1000', '500', '0.0007996',  '1', '1'), ( '200', '100', '0.01125', '2', '1');

INSERT INTO `recipe_tags` (`rezept_id`, `tag_id`) VALUES ('1', '3'), ('1', '1');

INSERT INTO `preperation_step` (`pre_step_id`, `description`, `effort`, `step_count`, `pic_id`, `rezept_id`) VALUES (NULL, 'Kartoffeln schälen und kochen.', '30', '1', NULL, '1'), (NULL, 'Käse über die Kartoffeln streuen.', '1', '2', NULL, '1');

INSERT INTO `comment` (`comment_id`, `creation_date`, `text`, `userid`, `rezept_id`) VALUES (NULL, '2017-10-22 00:00:00', 'Super leckeres Gericht.', '1', '1');
