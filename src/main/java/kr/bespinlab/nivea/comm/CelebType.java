package kr.bespinlab.nivea.comm;

public enum CelebType implements BaseCodeLabelEnum {

    ACT("배우"),
    SIN("가수"),
    UND("미확인")
    ;

    private String code;
    private String label;

    CelebType(String label) {
        this.code = name();
        this.label = label;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String label() {
        return label;
    }
}
