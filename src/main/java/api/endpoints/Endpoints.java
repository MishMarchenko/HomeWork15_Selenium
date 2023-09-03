package api.endpoints;

public enum Endpoints {
    CREATE_USER("/user"),
    USER_WITH_PARAM("/user/"),
    GET_TOKEN("/GenerateToken"),
    USER("/User/"),
    BOOK("/Books");
    private final String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }
    public String getValue() {
        return endpoint;
    }
}
