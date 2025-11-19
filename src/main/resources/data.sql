INSERT INTO roles (name) VALUES ('ROLE_GENERAL');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

-- 管理者ユーザー（パスワードは後で手動でBCryptに変えてもOK）
INSERT INTO users (name, email, password, role_id, enabled)
VALUES ('管理者', 'admin@example.com', '$2a$10$Vqg.ynnvDXCW2RIZcB16B.rz4qZudetp6m0tVDIHQkwUIumb2/RyW', 2, true);

-- サンプル民宿
INSERT INTO houses (name, description, price, capacity, postal_code, address, phone_number)
VALUES ('海辺の民宿', '海の近くの静かな民宿です。', 8000, 4, '123-4567', '東京都千代田区1-1-1', '03-1234-5678');

INSERT INTO houses (name, description, price, capacity, postal_code, address, phone_number)
VALUES ('山の民宿', '自然いっぱいの山の宿。', 6000, 3, '987-6543', '長野県長野市2-2-2', '026-111-2222');
