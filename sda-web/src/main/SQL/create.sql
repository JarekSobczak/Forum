CREATE table if not exists `TB_USER`(
    `US_ID` INT AUTO_INCREMENT,
    `US_USER_NAME` varchar(25) not null,
    `US_PASSWORD` varchar(25) not null,
    PRIMARY KEY (`US_ID`)
);

CREATE table if not exists `TB_ARTICLE`(
    `AR_ID` int auto_increment,
    `AR_USER_ID` INT NOT NULL,
    `AR_Content` varchar(1000) not null ,
    `AR_Title` varchar(100) ,
    foreign key fk_user_id(AR_USER_ID) references TB_USER(US_ID)
                                       on UPDATE cascade 
                                       on delete restrict,
                                       primary key (`AR_ID`)
);
