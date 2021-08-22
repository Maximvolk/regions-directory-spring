create table if not exists `REGIONS` (
    `id` identity not null primary key,
    `name` varchar(100) not null,
    `shortName` varchar(100) not null
);