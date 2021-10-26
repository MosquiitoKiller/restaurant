CREATE TABLE IF NOT EXISTS `restaurant`.`users` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
    );
CREATE TABLE IF NOT EXISTS `restaurant`.`roles` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`));
# INSERT INTO restaurant.roles
# VALUES ('1','ROLE_USER'), ('2','ROLE_ADMIN');
