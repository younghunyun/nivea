package kr.bespinlab.nivea.parameter;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class ThumbnailUpdateParam {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int       fileSeq;
    private String    thumbnailFilename;
    private String    thumbnailPath;

}
