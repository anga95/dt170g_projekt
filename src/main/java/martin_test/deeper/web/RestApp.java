package martin_test.deeper.web;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestApp extends Application {
    public RestApp() {
    }
}
