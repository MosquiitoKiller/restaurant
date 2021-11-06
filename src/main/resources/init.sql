CREATE TABLE IF NOT EXISTS `restaurant`.`users` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
    );
CREATE TABLE IF NOT EXISTS `restaurant`.`roles` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`));
CREATE TABLE IF NOT EXISTS `restaurant`.`products` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `price` INT NOT NULL,
    `category` VARCHAR(45) NOT NULL,
    `description` VARCHAR(256) NOT NULL,
    `img` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`));
# CREATE TABLE IF NOT EXISTS `restaurant`.`token` (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `name` VARCHAR(45) NOT NULL,
#     PRIMARY KEY (`id`));
# INSERT INTO restaurant.roles
# VALUES ('1','ROLE_USER'), ('2','ROLE_ADMIN');
