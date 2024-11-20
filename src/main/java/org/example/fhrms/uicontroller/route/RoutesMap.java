package org.example.fhrms.uicontroller.route;

import java.util.HashMap;

public class RoutesMap {
    private static RoutesMap routeMap=new RoutesMap();
    private HashMap<String,String> routes=new HashMap();

    private RoutesMap(){
        routes.put("signup","auth/signup-view.fxml");
        routes.put("login","auth/login-view.fxml");
    }

    public String getRoute(String route){
        return routes.get(route);
    }

    public static RoutesMap getInstance(){
        if(routeMap==null){
            routeMap=new RoutesMap();
        }

        return routeMap;
    }

}
