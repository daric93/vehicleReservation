package daric.vr.services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/services")
public class ServiceConf extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return getRestResourceClasses();
    }

    private Set<Class<?>> getRestResourceClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(CarTypeService.class);
        resources.add(CarService.class);
        resources.add(UserService.class);
        resources.add(UploadImages.class);
        resources.add(OrderService.class);
        resources.add(AdminService.class);
        return resources;
    }
}
