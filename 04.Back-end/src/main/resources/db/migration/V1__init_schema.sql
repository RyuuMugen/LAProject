CREATE TABLE IF NOT EXISTS `employees` (
    employee_id BIGINT(20) NOT NULL AUTO_INCREMENT,
    department_id BIGINT(20) NOT NULL,
    employee_name VARCHAR(100) NOT NULL,
    employee_name_kana VARCHAR(100) DEFAULT NULL,
    employee_email VARCHAR(50) NOT NULL,
    employee_login_id VARCHAR(50) NOT NULL,
    employee_login_password VARCHAR(100) DEFAULT NULL,
    employee_birth_date DATE DEFAULT NULL,
    employee_telephone VARCHAR(20) DEFAULT NULL,
    salt VARCHAR(100) DEFAULT NULL,
    role INT DEFAULT 0,
    PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO employees (
    department_id,
    employee_name,
    employee_email,
    employee_login_id,
    employee_login_password,
    employee_birth_date,
    employee_telephone
) VALUES (
    1,
    'Administrator',
    'la@luvina.net',
    'admin',
    '$2a$12$ARFY.4QlVJBnTAIpbXH0DeBT7IkzlWlj0y70GkId5UWczCpL0tTLi',
    '1990-01-01',
    '0901000000'
);
--password default: $2a$10$r.XIN4K9vTioiuYQwaTop.UVQ5r5FvrKk2V5Orm9Hc6n4i9Tvjthy admin
--password new: $2a$12$ARFY.4QlVJBnTAIpbXH0DeBT7IkzlWlj0y70GkId5UWczCpL0tTLi admin1234