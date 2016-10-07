SELECT 
    pg_terminate_backend(pid) 
FROM 
    pg_stat_activity 
WHERE 
    pid <> pg_backend_pid()
    AND datname = 'dd84hs2u9j8gij'
    ;
create table note (
    id serial not null primary key,
    author text not null,
    content text not null,
    creation_date timestamp not null default current_timestamp
);