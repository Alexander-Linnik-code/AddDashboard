package linnik.apipages;

import java.util.Objects;

public class Body {
    private String name;

    public Body(String dashboardName) {
        name = dashboardName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return Objects.equals(name, body.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Body{" +
                "DashboardName='" + name + '\'' +
                '}';
    }
}
