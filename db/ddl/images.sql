CREATE TABLE IF NOT EXISTS images (
    file_seq            INT           NOT NULL AUTO_INCREMENT
  , ref_id              VARCHAR(10)   NULL
  , original_file_name  VARCHAR(1000) NOT NULL
  , upload_file_name    VARCHAR(1000) NOT NULL
  , upload_path         VARCHAR(2000) NOT NULL
  , resource_path       VARCHAR(2000) NOT NULL
  , size_byte           INT           NULL
  , content_type        VARCHAR(100)  NULL
  , del_yn              CHAR(1)       NOT NULL DEFAULT 'N'
  , updated             DATETIME      NOT NULL DEFAULT NOW()
  , PRIMARY KEY(file_seq)
  , UNIQUE INDEX uindex_image_uid (ref_id)
)
CHARSET=utf8;