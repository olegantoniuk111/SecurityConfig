package vin.gans.domain;

public enum UserField {
    USER("user"),
    ADMIN("admin");
    private String field;

    UserField(String field) {
        this.field = field;
    }
    public  String field(){
        return field;
    }

}
