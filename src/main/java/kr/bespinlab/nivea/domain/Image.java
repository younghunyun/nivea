package kr.bespinlab.nivea.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
public class Image {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int       fileSeq;
    private String    refId;
    private String    originalFilename;
    private String    uploadFilename;
    private String    uploadPath;
    private String    resourcePath;
    private int       sizeByte;
    private String    contentType;
    private String    isRepresentative;
    private String    thumbnailFilename;
    private String    thumbnailPath;
    private Timestamp updated;

}
