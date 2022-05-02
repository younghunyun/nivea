CREATE TABLE IF NOT EXISTS images (
    file_seq                int           NOT NULL AUTO_INCREMENT
  , ref_id                  VARCHAR(10)   NULL
  , original_filename       VARCHAR(1000) NOT NULL
  , upload_filename         VARCHAR(1000) NOT NULL
  , upload_path             VARCHAR(2000) NOT NULL
  , resource_path           VARCHAR(2000) NOT NULL
  , size_byte               INT           NULL
  , content_type            VARCHAR(100)  NULL
  , is_representative       CHAR(1)       NOT NULL DEFAULT 'N'
  , thumbnail_filename      VARCHAR(2000) NULL
  , thumbnail_path          VARCHAR(2000) NULL
  , updated                 DATETIME      NOT NULL DEFAULT NOW()
  , PRIMARY KEY(file_seq)
)
CHARSET=utf8;