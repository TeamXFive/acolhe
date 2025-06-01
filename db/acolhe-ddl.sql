CREATE TABLE address (
    address_id          SERIAL PRIMARY KEY,
    postal_code         VARCHAR(9)   NOT NULL,
    region_code         VARCHAR(2)   NOT NULL,
    administrative_area VARCHAR(100) NOT NULL,
    locality            VARCHAR(100) NOT NULL,
    sublocality         VARCHAR(100),
    address_line        VARCHAR(150) NOT NULL
);

CREATE TABLE event (
    event_id    SERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description TEXT,
    date        DATE         NOT NULL,
    address_id  INT          NOT NULL,
    CONSTRAINT fk_event_address FOREIGN KEY (address_id) REFERENCES address (address_id)
);

CREATE TABLE app_user (
    user_id SERIAL PRIMARY KEY,
    name    VARCHAR(100)       NOT NULL,
    cpf     VARCHAR(14) UNIQUE NOT NULL,
    phone   VARCHAR(20)        NOT NULL
);

CREATE TABLE professional (
    professional_id SERIAL PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    phone           VARCHAR(20)  NOT NULL,
    specialty       VARCHAR(100)
);

CREATE TABLE session (
    session_id      SERIAL PRIMARY KEY,
    datetime        TIMESTAMP   NOT NULL,
    status          VARCHAR(20) NOT NULL,
    method          VARCHAR(20) NOT NULL,
    link_web        VARCHAR(255),
    link_phone      VARCHAR(255),
    user_id         INT         NOT NULL,
    professional_id INT         NOT NULL,
    event_id        INT         NOT NULL,
    CONSTRAINT fk_session_user FOREIGN KEY (user_id) REFERENCES app_user (user_id),
    CONSTRAINT fk_session_professional FOREIGN KEY (professional_id) REFERENCES professional (professional_id),
    CONSTRAINT fk_session_event FOREIGN KEY (event_id) REFERENCES event (event_id),
    CONSTRAINT chk_status CHECK (status IN ('agendada', 'confirmada', 'concluída', 'cancelada')),
    CONSTRAINT chk_method CHECK (method IN ('videochamada', 'telefone'))
);