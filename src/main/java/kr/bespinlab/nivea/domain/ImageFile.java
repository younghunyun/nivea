package kr.bespinlab.nivea.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ImageFile {

    private int       file_seq;
    private int       ref_id;
    private String    original_file_name;
    private String    upload_file_name;
    private String    upload_path;
    private String    resource_path;
    private int       size_byte;
    private String    content_type;
    private Timestamp updated;

}
