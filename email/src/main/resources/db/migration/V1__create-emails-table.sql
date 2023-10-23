create table emails(
    id varchar(80) not null primary key,
    user_id varchar(80) not null,
    email_from varchar(255) not null,
    email_to varchar(255) not null,
    subject varchar(200) not null,
    text TEXT not null,
    send_date_email datetime(6) not null,
    status_email int(10)
);