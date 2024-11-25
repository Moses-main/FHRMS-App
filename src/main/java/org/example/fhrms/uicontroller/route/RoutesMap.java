package org.example.fhrms.uicontroller.route;

import java.util.HashMap;
import java.util.Optional;

public class RoutesMap {
    private static RoutesMap routeMap = new RoutesMap();
    private HashMap<String, String> routes = new HashMap();

    private RoutesMap() {
        routes.put("signup", "auth/signup-view.fxml");
        routes.put("login", "auth/login-view.fxml");
        routes.put("dashboard", "dashboard/dashboard-view.fxml");
        routes.put("chef", "chef/chef-view.fxml");
        routes.put("admin", "admin/admin-view.fxml");
        routes.put("waiter", "waiter/waiter-view.fxml");

        // ACCESSIBLE BY ADMIN ALONE
        routes.put("admin/manage-users", "admin/manageUsers-view.fxml");
        routes.put("admin/manage-roles", "admin/manageRoles-view.fxml");
        routes.put("admin/manage-inventory", "admin/manageInventory-view.fxml");
        routes.put("admin/manage-settings", "admin/manageSettings-view.fxml");
        routes.put("admin/manage-reports", "admin/manageReports-view.fxml");
        routes.put("admin/analytics", "admin/Analytics-view.fxml");

    }

    public Optional<String> getRoute(String route) {

        String foundRoute = routes.get(route);
        return Optional.of(foundRoute);
    }

    public static RoutesMap getInstance() {
        if (routeMap == null) {
            routeMap = new RoutesMap();
        }

        return routeMap;
    }

}
