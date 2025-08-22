import java.util.HashMap;
import java.util.Map;

public class MinimalistWebAppDashboard {
    // API Endpoints
    public enum Endpoint {
        DASHBOARD("/dashboard"),
        USERS("/users"),
        SETTINGS("/settings");

        private final String path;

        Endpoint(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }

    // API Request Model
    public static class Request {
        private String endpoint;
        private Map<String, String> parameters;

        public Request(String endpoint, Map<String, String> parameters) {
            this.endpoint = endpoint;
            this.parameters = parameters;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public Map<String, String> getParameters() {
            return parameters;
        }
    }

    // API Response Model
    public static class Response {
        private int statusCode;
        private String responseBody;

        public Response(int statusCode, String responseBody) {
            this.statusCode = statusCode;
            this.responseBody = responseBody;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getResponseBody() {
            return responseBody;
        }
    }

    // Dashboard API
    public interface DashboardAPI {
        Response getDashboard(Request request);
        Response getUsers(Request request);
        Response getSettings(Request request);
    }

    // Sample Implementation
    public static class SampleDashboardAPI implements DashboardAPI {
        @Override
        public Response getDashboard(Request request) {
            return new Response(200, "<h1>Minimalist Web App Dashboard</h1>");
        }

        @Override
        public Response getUsers(Request request) {
            return new Response(200, "[{\"id\": 1, \"name\": \"John Doe\"}, {\"id\": 2, \"name\": \"Jane Doe\"}]");
        }

        @Override
        public Response getSettings(Request request) {
            return new Response(200, "{\"theme\": \"light\"}");
        }
    }

    public static void main(String[] args) {
        DashboardAPI api = new SampleDashboardAPI();

        // Example usage
        Request request = new Request(Endpoint.DASHBOARD.getPath(), new HashMap<>());
        Response response = api.getDashboard(request);
        System.out.println(response.getResponseBody());
    }
}