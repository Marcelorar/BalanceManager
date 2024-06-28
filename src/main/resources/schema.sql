/*create table CLIENT(
              clientId    int          not null AUTO_INCREMENT,
              name         varchar(100) not null,
              gender       varchar(6)   not null,
              birthDate   date         not null,
              identificationCode   char(10)     not null,
              address      varchar(100) not null,
              phoneNumber varchar(15)  not null,
              password     varchar(12)  not null,
              isEnabled   boolean      not null,
              PRIMARY KEY ( clientId )
);

create table ACCOUNT(
               clientId    int          not null,
               number       char(6)      not null,
               type         varchar(8)   not null,
               availableBalance  decimal      not null,
               isEnabled   boolean      not null,
               PRIMARY KEY ( number ),
               FOREIGN KEY ( clientId ) references CLIENT( clientId )
);

create table TRANSACTION(
                id           char(36)     not null,
                account      char(6)      not null,
                date         datetime     not null,
                type         varchar(6)   not null,
                amount       decimal      not null,
                currentBalance  decimal      not null,
                PRIMARY KEY ( id ),
                FOREIGN KEY ( account ) references ACCOUNT( number )
);*/

drop sequence if exists client_seq;

create sequence client_seq start with 4 increment by 50;