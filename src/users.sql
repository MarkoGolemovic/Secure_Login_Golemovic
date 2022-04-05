create DATABASE user;
use user;
DROP TABLE if EXISTS users;
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ;

Insert into users VALUES ("admin","admin");
SELECT * From users;


