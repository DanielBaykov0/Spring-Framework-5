package baykov.daniel.springdi.datasource;

public class FakeDataSource {

    private String username;
    private String password;
    private String jdbcurcl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcurcl() {
        return jdbcurcl;
    }

    public void setJdbcurcl(String jdbcurcl) {
        this.jdbcurcl = jdbcurcl;
    }
}
