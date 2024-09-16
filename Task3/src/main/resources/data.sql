CREATE TABLE user (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      name VARCHAR(256) NOT NULL,
                      surname VARCHAR(256) NOT NULL,
                      phone_Number VARCHAR(256) NOT NULL,
                      email VARCHAR(256) NOT NULL,
                      address VARCHAR(256) NOT NULL,
                      password VARCHAR(256) NOT NULL
);

INSERT INTO user (name, surname, phone_Number, email, address, password) VALUES
                                                                             ('Jonas', 'Jonatis', '+37062021458', 'jonas@gmail.com', 'Vilnius', 'Abcd!!'),
                                                                             ('Tomas', 'Petraitis', '37062021459', 'petraitis@gmail.com', 'Kaunas', 'AbCd!');
