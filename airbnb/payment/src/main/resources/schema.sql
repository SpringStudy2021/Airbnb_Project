DROP TABLE IF EXISTS payment;
CREATE TABLE payment(
    id INT PRIMARY KEY,
    payId INT NOT NULL,
    roomId INT NOT NULL,
    rsvId INT NOT NULL,
    price INT NOT NULL,
    status VARCHAR(20),
    lengthOfStay INT NOT NULL
);