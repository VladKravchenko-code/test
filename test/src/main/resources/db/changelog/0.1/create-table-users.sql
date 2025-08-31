CREATE TABLE users
(
    uuid        UUID PRIMARY KEY,
    FIO         VARCHAR(255) NOT NULL,
    phone_number VARCHAR(11),
    avatar      VARCHAR(255),
    role_uuid    UUID,
    CONSTRAINT fk_role
        FOREIGN KEY (role_uuid) REFERENCES roles(UUID)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);