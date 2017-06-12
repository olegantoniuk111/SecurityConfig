package vin.gans.domain;

/**
 * Created by root on 01.05.17.
 */
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
