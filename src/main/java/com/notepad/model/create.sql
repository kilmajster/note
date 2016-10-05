create table note (
    id serial not null primary key,
    author text not null,
    content text not null,
    creation_date timestamp not null default current_timestamp
);