/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/11/20 12:36:10                          */
/*==============================================================*/


drop table if exists actor;

drop table if exists category;

drop table if exists director;

drop table if exists file;

drop table if exists film;

drop table if exists film_actor;

drop table if exists film_director;

drop table if exists film_genre;

drop table if exists film_language;

drop table if exists menu;

drop table if exists menu_film;

/*==============================================================*/
/* Table: actor                                                 */
/*==============================================================*/
create table actor
(
   id                   int not null auto_increment comment 'The id of the actor',
   first_name           varchar(45) comment 'The  first name of the actor',
   last_name            varchar(45) comment 'The last name of the actor',
   last_update          timestamp default current_timestamp comment 'The last update time of the actor',
   primary key (id)
);

alter table actor comment 'the actor table';

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
   id                   int not null auto_increment comment 'The id of the category',
   ckey                 varchar(45) comment 'The key of the category',
   cval                 varchar(255) comment 'The value of the category',
   last_update          timestamp default current_timestamp comment 'The last update time of the category',
   primary key (id)
);

alter table category comment 'the categorys table';

/*==============================================================*/
/* Table: director                                              */
/*==============================================================*/
create table director
(
   id                   int not null auto_increment comment 'The id of the director',
   first_name           varchar(45) comment 'The director first name',
   last_name            varchar(45) comment 'The last name of the director',
   last_update          timestamp default current_timestamp comment 'The last update time of the director',
   primary key (id)
);

alter table director comment 'the director table';

/*==============================================================*/
/* Table: file                                                  */
/*==============================================================*/
create table file
(
   id                   int not null auto_increment comment 'The id of the file',
   film_id              varchar(20) not null comment 'The id of the film',
   file_name            varchar(255) comment 'The name of the file',
   file_size            long comment 'The size of the file',
   last_update          timestamp default current_timestamp comment 'The last update time of the file',
   remark               varchar(255) comment 'The remark of the file',
   category_film        int comment 'The file type of the films',
   primary key (id, film_id)
);

alter table file comment 'the film file table';

/*==============================================================*/
/* Table: film                                                  */
/*==============================================================*/
create table film
(
   id                   varchar(20) not null comment 'The id of the film',
   title                varchar(255) comment 'The title of the film',
   ratings              varchar(45) comment 'The ratings of the film',
   release_year         year comment 'The release year of the film',
   country              varchar(45) comment 'The country of the film',
   length               smallint comment 'The length of the film (unit: min)',
   last_update          timestamp default current_timestamp comment 'The last update time of the film',
   description          text comment 'The description of the film',
   remark               varchar(255) comment 'The remark of the film',
   primary key (id)
);

alter table film comment 'the film table';

/*==============================================================*/
/* Table: film_actor                                            */
/*==============================================================*/
create table film_actor
(
   actor_id             int not null comment 'The id of the actor',
   film_id              varchar(20) not null comment 'The id of the film',
   primary key (actor_id, film_id)
);

alter table film_actor comment 'the film actor table';

/*==============================================================*/
/* Table: film_director                                         */
/*==============================================================*/
create table film_director
(
   director_id          int not null comment 'The id of  the directory',
   film_id              varchar(20) not null comment 'The id of the film',
   primary key (director_id, film_id)
);

alter table film_director comment 'the film director table';

/*==============================================================*/
/* Table: film_genre                                            */
/*==============================================================*/
create table film_genre
(
   category_genre       int not null comment 'The genre of the films',
   film_id              varchar(20) not null comment 'The id of the film',
   primary key (category_genre, film_id)
);

alter table film_genre comment 'the film genre table';

/*==============================================================*/
/* Table: film_language                                         */
/*==============================================================*/
create table film_language
(
   category_language    int not null comment 'The language of the film',
   film_id              varchar(20) not null comment 'The id of the film',
   primary key (category_language, film_id)
);

alter table film_language comment 'the film language table';

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   id                   int not null auto_increment comment 'The id of the menu',
   parent               int comment 'The parent of the menu',
   category_style       int comment 'The terminal display style of the menu',
   name                 varchar(45) comment 'The name of the menu',
   display_order        int comment 'The display sub menu order of the parent menu',
   path                 varchar(45) comment 'The path of the menu',
   has_child            bool comment 'Has child of the menu',
   valid                bool comment 'Is valid of menu',
   level                int comment 'The level of the menu',
   icon                 varchar(255) comment 'The icon of the menu',
   focus_icon           varchar(255) comment 'The  focus icon of the menu',
   last_update          timestamp default current_timestamp comment 'The last update time of the menu',
   remark               varchar(255) comment 'The remark of the menu',
   primary key (id)
);

alter table menu comment 'terminal display menu';

/*==============================================================*/
/* Table: menu_film                                             */
/*==============================================================*/
create table menu_film
(
   menu_id              int not null comment 'The id of the menu',
   film_id              varchar(20) not null comment 'The id of the film',
   display_order        int comment 'The display film order of the menu',
   last_update          timestamp default current_timestamp comment 'The last update time of the menu film',
   primary key (menu_id, film_id)
);

alter table menu_film comment 'the menu film table';

alter table file add constraint fk_file_category_film foreign key (category_film)
      references category (id) on delete restrict on update restrict;

alter table file add constraint fk_film_file foreign key (film_id)
      references film (id) on delete restrict on update restrict;

alter table film_actor add constraint fk_actor_film foreign key (actor_id)
      references actor (id) on delete restrict on update restrict;

alter table film_actor add constraint fk_film_actor foreign key (film_id)
      references film (id) on delete restrict on update restrict;

alter table film_director add constraint fk_director_film foreign key (director_id)
      references director (id) on delete restrict on update restrict;

alter table film_director add constraint fk_film_director foreign key (film_id)
      references film (id) on delete restrict on update restrict;

alter table film_genre add constraint fk_category_genre foreign key (category_genre)
      references category (id) on delete restrict on update restrict;

alter table film_genre add constraint fk_film_genre foreign key (film_id)
      references film (id) on delete restrict on update restrict;

alter table film_language add constraint fk_category_language foreign key (category_language)
      references category (id) on delete restrict on update restrict;

alter table film_language add constraint fk_film_language foreign key (film_id)
      references film (id) on delete restrict on update restrict;

alter table menu add constraint fk_menu_parent foreign key (parent)
      references menu (id) on delete restrict on update restrict;

alter table menu add constraint fk_menu_style foreign key (category_style)
      references category (id) on delete restrict on update restrict;

alter table menu_film add constraint fk_fim_menu foreign key (film_id)
      references film (id) on delete restrict on update restrict;

alter table menu_film add constraint fk_menu_film foreign key (menu_id)
      references menu (id) on delete restrict on update restrict;

