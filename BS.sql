CREATE TABLE public.stadiums (
    id serial primary key,
    name text not null,
    city text not null,
    capacity integer not null,
    country text not null
);
CREATE TABLE public.teams (
    id serial primary key,
    name text not null,
    city text not null
);
CREATE TABLE public.players (
    id serial primary key,
    name text not null,
    position text not null,
    team_id integer references teams(id),
    jersey_number char(3) not null,
    birth_date date not null,
    height_cm integer not null,
    country_of_birth text not null
);
CREATE TABLE public.matches (
    id serial primary key,
    date date not null,
    home_team_id integer references teams(id),
    away_team_id integer references teams(id),
    home_team_score integer not null,
    away_team_score integer not null,
    stadium_id integer references stadiums(id)
);
CREATE TABLE public.goals (
    id serial primary key,
    match_id integer references matches(id),
    player_id integer references players(id),
    minute integer not null
);
CREATE TABLE public.assists (
    id serial primary key,
    match_id integer references matches(id),
    player_id integer references players(id),
    minute integer not null
);
CREATE TABLE public.standings (
    team_id integer primary key references teams(id),
    points integer not null default 0,
    goals_for integer not null default 0,
    goals_against integer not null default 0
);
CREATE TABLE public.awards (
    id serial primary key,
    name text not null,
    player_id integer references players(id),
    description text
);
CREATE TABLE public.coaches (
    id serial primary key,
    name text not null,
    team_id integer references teams(id)
);
CREATE TABLE public.event_type (
    id serial primary key,
    name text not null
);
CREATE TABLE public.match_events (
    id serial primary key,
    match_id integer references matches(id),
    minute integer not null,
    player_id integer references players(id),
    description text,
    event_type_id integer references event_type(id),
    player2_id integer references players(id)
);
CREATE TABLE public.judges (
    id serial primary key,
    name text not null,
    country_of_birth text not null
);
CREATE TABLE public.judge_roles (
    id serial primary key,
    role_name text not null
);
CREATE TABLE public.judges_per_match (
    id serial primary key,
    match_id integer references matches(id),
    judge_id integer references judges(id),
    role_id integer references judge_roles(id)
);
