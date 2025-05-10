-- departments
CREATE TABLE IF NOT EXISTS departments (
    department_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Thêm một bộ phận mẫu vào bảng departments
INSERT INTO departments (department_name)
VALUES
    ('DEV1 IT'),
    ('DEV2 IT'),
    ('DEV3 IT'),
    ('DEV5 IT'),
    ('DEV6 IT'),
    ('DEV7 IT'),
    ('DEV8 IT'),
    ('DEV10 IT'),
    ('DEV9 IT');
-- certifications
CREATE TABLE IF NOT EXISTS `certifications` (
    certification_id BIGINT(20) NOT NULL AUTO_INCREMENT,
    certification_name VARCHAR(50) NOT NULL,
    certification_level INT(11) NOT NULL,
    PRIMARY KEY (`certification_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- Thêm các chứng chỉ mẫu vào bảng certifications
INSERT INTO certifications (certification_name, certification_level)
VALUES
    ('Trình độ tiếng Nhật cấp 1', 1),
    ('Trình độ tiếng Nhật cấp 2', 2),
    ('Trình độ tiếng Nhật cấp 3', 3),
    ('Trình độ tiếng Nhật cấp 4', 4),
    ('Trình độ tiếng Nhật cấp 5', 5);

-- employee_certifications
CREATE TABLE IF NOT EXISTS `employee_certifications` (
    employee_certification_id BIGINT(20) NOT NULL AUTO_INCREMENT,
    employee_id BIGINT(20) NOT NULL,
    certification_id BIGINT(20) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    score DECIMAL(5,2) NOT NULL,
    PRIMARY KEY (`employee_certification_id`) USING BTREE,
    CONSTRAINT FK_employee FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    CONSTRAINT FK_certification FOREIGN KEY (certification_id) REFERENCES certifications(certification_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



ALTER TABLE `employees`
ADD CONSTRAINT `fk_department`
FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`)
ON DELETE CASCADE;

INSERT INTO employees (
    department_id,
    employee_name,
    employee_email,
    employee_login_id,
    employee_login_password,
    employee_birth_date,
    employee_telephone
) VALUES
(2, 'Nguyen Van A', 'a1@example.com', 'user1', '$2a$10$r.XIN4K9vTioiuYQwaTop.UVQ5r5FvrKk2V5Orm9Hc6n4i9Tvjthy', '1990-01-01', '0901000001'),
(2, 'Tran Thi B', 'b2@example.com', 'user2', 'password2', '1991-02-02', '0901000002'),
(3, 'Le Van C', 'c3@example.com', 'user3', 'password3', '1992-03-03', '0901000003'),
(1, 'Pham Thi D', 'd4@example.com', 'user4', 'password4', '1993-04-04', '0901000004'),
(3, 'Hoang Van E', 'e5@example.com', 'user5', 'password5', '1994-05-05', '0901000005'),
(1, 'Vo Thi F', 'f6@example.com', 'user6', 'password6', '1995-06-06', '0901000006'),
(2, 'Dang Van G', 'g7@example.com', 'user7', 'password7', '1996-07-07', '0901000007'),
(1, 'Ngo Thi H', 'h8@example.com', 'user8', 'password8', '1997-08-08', '0901000008'),
(3, 'Bui Van I', 'i9@example.com', 'user9', 'password9', '1998-09-09', '0901000009'),
(2, 'Do Thi J', 'j10@example.com', 'user10', 'password10', '1999-10-10', '0901000010'),
(1, 'Ly Van K', 'k11@example.com', 'user11', 'password11', '1990-11-11', '0901000011'),
(3, 'Trinh Thi L', 'l12@example.com', 'user12', 'password12', '1991-12-12', '0901000012'),
(2, 'Dang Van M', 'm13@example.com', 'user13', 'password13', '1992-01-13', '0901000013'),
(1, 'Nguyen Thi N', 'n14@example.com', 'user14', 'password14', '1993-02-14', '0901000014'),
(3, 'Pham Van O', 'o15@example.com', 'user15', 'password15', '1994-03-15', '0901000015'),
(2, 'Tran Thi P', 'p16@example.com', 'user16', 'password16', '1995-04-16', '0901000016'),
(1, 'Le Van Q', 'q17@example.com', 'user17', 'password17', '1996-05-17', '0901000017'),
(3, 'Vo Thi R', 'r18@example.com', 'user18', 'password18', '1997-06-18', '0901000018'),
(2, 'Hoang Van S', 's19@example.com', 'user19', 'password19', '1998-07-19', '0901000019'),
(4, 'Nguyen Thi Mai', 'nguyen.mai4@example.com', 'nguyen_mai4', 'password4', '1995-05-01', '0904000004'),
(5, 'Tran Hoang Anh', 'tran.anh5@example.com', 'tran_anh5', 'password5', '1994-06-02', '0905000005'),
(6, 'Le Minh Tu', 'le.tu6@example.com', 'le_tu6', 'password6', '1993-07-03', '0906000006'),
(7, 'Pham Bao Chi', 'pham.chi7@example.com', 'pham_chi7', 'password7', '1992-08-04', '0907000007'),
(4, 'Nguyen Quang Hieu', 'nguyen.hieu8@example.com', 'nguyen_hieu8', 'password8', '1991-09-05', '0908000008'),
(5, 'Bui Lan Anh', 'bui.anh9@example.com', 'bui_anh9', 'password9', '1990-10-06', '0909000009'),
(6, 'Truong Thanh Son', 'truong.son10@example.com', 'truong_son10', 'password10', '1989-11-07', '0910000010'),
(7, 'Hoang Minh Tuan', 'hoang.tuan11@example.com', 'hoang_tuan11', 'password11', '1988-12-08', '0911000011'),
(4, 'Nguyen Bao Linh', 'nguyen.linh12@example.com', 'nguyen_linh12', 'password12', '1997-01-09', '0912000012'),
(5, 'Pham Quoc Khai', 'pham.khai13@example.com', 'pham_khai13', 'password13', '1996-02-10', '0913000013'),
(6, 'Le Thi Thanh', 'le.thanh14@example.com', 'le_thanh14', 'password14', '1995-03-11', '0914000014'),
(7, 'Tran Thuy Dung', 'tran.dung15@example.com', 'tran_dung15', 'password15', '1994-04-12', '0915000015'),
(4, 'Nguyen Hoang Minh', 'nguyen.minh16@example.com', 'nguyen_minh16', 'password16', '1993-05-13', '0916000016'),
(5, 'Bui Thanh Lieu', 'bui.lieu17@example.com', 'bui_lieu17', 'password17', '1992-06-14', '0917000017'),
(6, 'Truong Phuong Hoa', 'truong.hoa18@example.com', 'truong_hoa18', 'password18', '1991-07-15', '0918000018'),
(7, 'Hoang Thi Kim', 'hoang.kim19@example.com', 'hoang_kim19', 'password19', '1990-08-16', '0919000019'),
(4, 'Nguyen Thi Lan', 'nguyen.lan20@example.com', 'nguyen_lan20', 'password20', '1989-09-17', '0920000020'),
(5, 'Pham Mai Quyen', 'pham.quyen21@example.com', 'pham_quyen21', 'password21', '1988-10-18', '0921000021'),
(6, 'Le Quoc Khai', 'le.khai22@example.com', 'le_khai22', 'password22', '1997-11-19', '0922000022'),
(9, 'B_i%n/h;h,h', 'tran.kim23@example.com', 'tran_kim23', 'password23', '1996-12-20', '0923000023');

-- Thêm một mối quan hệ chứng chỉ cho nhân viên vào bảng employee_certifications
INSERT INTO employee_certifications (employee_id, certification_id, start_date, end_date, score) VALUES
(1, 1, '2023-01-01', '2025-12-01', 100.0),
(2, 2, '2023-01-02', '2025-12-02', 101.0),
(3, 3, '2023-01-03', '2025-12-03', 102.0),
(4, 4, '2023-01-04', '2025-12-04', 103.0),
(5, 5, '2023-01-05', '2025-12-05', 104.0),
(6, 1, '2023-01-06', '2025-12-06', 105.0),
(7, 2, '2023-01-07', '2025-12-07', 106.0),
(8, 3, '2023-01-08', '2025-12-08', 107.0),
(9, 4, '2023-01-09', '2025-12-09', 108.0),
(10, 5, '2023-01-10', '2025-12-10', 109.0),
(11, 1, '2023-01-11', '2025-12-11', 110.0),
(12, 2, '2023-01-12', '2025-12-12', 111.0),
(13, 3, '2023-01-13', '2025-12-13', 112.0),
(14, 4, '2023-01-14', '2025-01-14', 113.0),
(15, 5, '2023-01-15', '2025-01-15', 114.0),
(16, 1, '2023-01-16', '2025-01-16', 115.0),
(17, 2, '2023-01-17', '2025-01-17', 116.0),
(18, 3, '2023-01-18', '2025-01-18', 117.0),
(19, 4, '2023-01-19', '2025-01-19', 118.0),
(20, 5, '2023-01-20', '2025-01-20', 119.0),
(21, 1, '2023-01-01', '2025-01-01', 95.0),
(22, 2, '2023-02-01', '2025-02-01', 90.5),
(23, 3, '2023-03-01', '2025-03-01', 88.0),
(24, 4, '2023-04-01', '2025-04-01', 91.2),
(25, 5, '2023-05-01', '2025-05-01', 85.6),
(26, 1, '2023-06-01', '2025-06-01', 92.0),
(27, 2, '2023-07-01', '2025-07-01', 89.7),
(28, 3, '2023-08-01', '2025-08-01', 87.3),
(29, 4, '2023-09-01', '2025-09-01', 93.5),
(30, 5, '2023-10-01', '2025-10-01', 86.9),
(31, 1, '2023-11-01', '2025-11-01', 90.0),
(32, 2, '2023-12-01', '2025-12-01', 88.8),
(33, 3, '2024-01-01', '2026-01-01', 91.4),
(34, 4, '2024-02-01', '2026-02-01', 87.5),
(35, 5, '2024-03-01', '2026-03-01', 92.2),
(36, 1, '2024-04-01', '2026-04-01', 89.3),
(37, 2, '2024-05-01', '2026-05-01', 94.6),
(38, 3, '2024-06-01', '2026-06-01', 90.1),
(39, 4, '2024-07-01', '2026-07-01', 88.9),
(40, 5, '2024-08-01', '2026-08-01', 93.0);

INSERT INTO employees (department_id, employee_name, employee_email, employee_login_id
) VALUES (1, 'Nguyen Van null', 'vana@example.com', 'vana_login');

INSERT INTO employees (
    department_id,
    employee_name,
    employee_name_kana,
    employee_email,
    employee_login_id,
    employee_login_password,
    employee_birth_date,
    employee_telephone,
    salt,
    role
) VALUES (
    1, -- department_id
    'wwwwwwww10wwwwwwww20wwwww', -- employee_name
    'wwwwwwww10wwwwwwww20wwwww', -- employee_name_kana
    'wwwwwwww10wwwwwwww20wwwww', -- employee_email
    'wwwwwwww10wwwwwwww20wwwww', -- employee_login_id
    'wwwwwwww10wwwwwwww20wwwww', -- employee_login_password
    '1990-01-01', -- employee_birth_date
    '1234567895', -- employee_telephone
    'wwwwwwww10wwwwwwww20wwwww', -- salt
    1 -- role
);

INSERT INTO employees (
    department_id,
    employee_name,
    employee_name_kana,
    employee_email,
    employee_login_id,
    employee_login_password,
    employee_birth_date,
    employee_telephone,
    salt,
    role
) VALUES (
    1, -- department_id
    'qqqqqqqq10qqqqqqqq20qqqqq', -- employee_name
    'qqqqqqqq10qqqqqqqq20qqqqq', -- employee_name_kana
    'qqqqqqqq10qqqqqqqq20qqqqq', -- employee_email
    'qqqqqqqq10qqqqqqqq20qqqqq', -- employee_login_id
    'qqqqqqqq10qqqqqqqq20qqqqq', -- employee_login_password
    '1990-01-01', -- employee_birth_date
    '1234567895', -- employee_telephone
    'qqqqqqqq10qqqqqqqq20qqqqq', -- salt
    1 -- role
);

INSERT INTO employees (
    department_id,
    employee_name,
    employee_name_kana,
    employee_email,
    employee_login_id,
    employee_login_password,
    employee_birth_date,
    employee_telephone,
    salt,
    role
) VALUES (
    1, -- department_id
    'iiiiiiii10iiiiiiii20iiiiiiii30', -- employee_name
    'iiiiiiii10iiiiiiii20iiiiiiii30', -- employee_name_kana
    'iiiiiiii10iiiiiiii20iiiiiiii30', -- employee_email
    'iiiiiiii10iiiiiiii20iiiiiiii30', -- employee_login_id
    'iiiiiiii10iiiiiiii20iiiiiiii30', -- employee_login_password
    '1990-01-01', -- employee_birth_date
    '1234567895', -- employee_telephone
    'iiiiiiii10iiiiiiii20iiiiiiii30', -- salt
    1 -- role
);