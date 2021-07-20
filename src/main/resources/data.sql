INSERT INTO users (username, password, enabled)
            values ('tonystark', 'has_a_heart', true);

INSERT INTO authorities (username, authority)
            values ('tonystark', 'ROLE_Avenger');  -- Notice the prefix `ROLE_<actual-role>`

INSERT INTO users (username, password, enabled)
            values ('nickfury', 'theboss', true);

INSERT INTO authorities (username, authority)
            values ('nickfury', 'ROLE_Director');  -- Notice the prefix `ROLE_<actual-role>`