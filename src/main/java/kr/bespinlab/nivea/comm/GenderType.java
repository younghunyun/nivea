package kr.bespinlab.nivea.comm;

public enum GenderType implements BaseCodeLabelEnum {

    F("여자"),
    M("남자"),
    O("기타")
    ;

    private String code;
    private String label;

    GenderType(String label) {
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
