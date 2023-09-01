package api.endpoints;

public enum Schemas {
    CREATE_USER_SCHEMA("user/CreateUserSchema.json"),
    GET_USER_SCHEMA("user/GetUserSchema.json"),
    CHANGE_USER_SCHEMA("user/ChangeUserSchema.json"),
    GET_DELETED_USER_SCHEMA("user/GetDeletedUserSchema.json");
    private final String schema;
    Schemas(String schema){
        this.schema = schema;
    }
    public String getValue(){
        return schema;
    }
}
