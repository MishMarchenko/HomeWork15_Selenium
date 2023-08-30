package api.endpoints;

public enum Schemas {
    CREATE_USER_SCHEMA("user/CreateUserSchema.json"),
    GET_USER_SCHEMA("user/GetUserSchema.json");
    private final String schema;
    Schemas(String schema){
        this.schema = schema;
    }
    public String getValue(){
        return schema;
    }
}
