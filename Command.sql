create database SMS;
use SMS;
create table `User`
(
    `uid`        INTEGER     NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `permission` INTEGER     NOT NULL DEFAULT 2,
    `username`   VARCHAR(32) NOT NULL,
    `password`   VARCHAR(64) NOT NULL,
    `sex`        BOOLEAN     NOT NULL DEFAULT TRUE,
    `age`        INTEGER     NOT NULL default 0,
    `email`      VARCHAR(64) NOT NULL,
    `deleted`    BOOLEAN     NOT NULL DEFAULT FALSE
);
INSERT into User (permission, username, password, sex, age, email, deleted) values (0,"root","p@ssw0rd",true,0,"root@root.com",false);

create table `TeacherInformation`
(
    `uid` INTEGER NOT NULL PRIMARY KEY,
    `collage` VARCHAR(32) NOT NULL ,
    `home` VARCHAR(64) NOT NULL
);

create table `StudentInformation`
(
    `uid` INTEGER NOT NULL PRIMARY KEY,
    `collage` VARCHAR(32) NOT NULL ,
    `grade` INTEGER NOT NULL ,
    `major` VARCHAR(32) NOT NULL ,
    `group` INTEGER NOT NULL ,
    `studyYear` INTEGER NOT NULL ,
    `home` VARCHAR(64) NOT NULL
);
create table `StudentScore`
(
    `uid` INTEGER NOT NULL PRIMARY KEY,
    `math` INTEGER NOT NULL DEFAULT -1,
    `english` INTEGER NOT NULL DEFAULT -1,
    `clang` INTEGER NOT NULL DEFAULT -1,
    `python` INTEGER NOT NULL DEFAULT -1,
    `history` INTEGER NOT NULL DEFAULT -1,
    `physics` INTEGER NOT NULL DEFAULT -1,
    `cpp` INTEGER NOT NULL DEFAULT -1
);