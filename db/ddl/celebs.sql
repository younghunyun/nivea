CREATE TABLE IF NOT EXISTS celebs(
    celeb_id      INT           NOT NULL AUTO_INCREMENT
  , celeb_code    CHAR(3)       NULL
  , stage_name    VARCHAR(100)  NOT NULL
  , stage_name_en VARCHAR(100)  NULL
  , real_name     VARCHAR(100)  NOT NULL
  , real_name_en  VARCHAR(100)  NULL
  , gender        CHAR(1)       NULL
  , birth_date    DATE          NULL
  , debut_date    DATE          NULL
  , country       VARCHAR(100)  NULL
  , region        VARCHAR(100)  NULL
  , height        DECIMAL(5,2)  NULL
  , weight        DECIMAL(5,2)  NULL
  , company       VARCHAR(200)  NULL
  , groups        VARCHAR(500)  NULL
  , updated       DATETIME      NOT NULL  DEFAULT NOW()
  , PRIMARY KEY(celeb_id)
  , UNIQUE INDEX uindex_celeb_uid (celeb_code, celeb_id)
)
CHARSET=utf8;