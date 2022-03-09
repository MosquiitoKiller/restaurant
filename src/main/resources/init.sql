CREATE TABLE IF NOT EXISTS users (
    id serial primary key,
    username varchar(100),
    password varchar(100)
    );
create table if not exists roles (
    id serial primary key,
    name varchar(100)
);
CREATE TABLE IF NOT EXISTS products (
    id serial primary key,
    name VARCHAR(45) NOT NULL,
    price INT NOT NULL,
    category VARCHAR(45) NOT NULL,
    description VARCHAR(256) NOT NULL,
    img VARCHAR(100) NOT NULL
    );
CREATE TABLE IF NOT EXISTS orders (
    id serial primary key,
    date varchar(20) NOT NULL,
    address varchar(100) NOT NULL,
    user_id INT REFERENCES users(id)
);
CREATE TABLE IF NOT EXISTS orders_products (
    id serial primary key,
    order_id INT REFERENCES orders(id),
    products_id INT REFERENCES products(id),
    count INT NOT NULL
);

-- INSERT INTO roles
-- VALUES ('1','ROLE_USER'), ('2','ROLE_ADMIN');
