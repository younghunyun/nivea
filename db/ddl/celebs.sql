CREATE TABLE IF NOT EXISTS celebs(
    celeb_seq     INT           NOT NULL AUTO_INCREMENT
  , celeb_code    CHAR(3)       NOT NULL
  , stage_name    VARCHAR(100)  NOT NULL
  , stage_name_en VARCHAR(100)  NULL
  , real_name     VARCHAR(100)  NOT NULL
  , real_name_en  VARCHAR(100)  NULL
  , gender        CHAR(1)       NULL
  , birth_date    DATE          NULL
  , debut_year    VARCHAR(4)    NULL
  , country       VARCHAR(100)  NULL
  , country_en    VARCHAR(100)  NULL
  , state         VARCHAR(100)  NULL
  , city          VARCHAR(100)  NULL
  , height        FLOAT         NULL
  , weight        FLOAT         NULL
  , company       VARCHAR(500)  NULL
  , del_yn        CHAR(1)       NOT NULL DEFAULT 'N'
  , updated       DATETIME      NOT NULL DEFAULT NOW()
  , PRIMARY KEY(celeb_seq)
  , UNIQUE INDEX uindex_celeb_uid (celeb_code, celeb_seq)
)
CHARSET=utf8;