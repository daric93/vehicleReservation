package daric.vr.services;

import com.google.common.io.ByteStreams;
import daric.vr.entities.CarType;
import daric.vr.exceptions.DuplicateEntryException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Stateless
@Path("uploadImg")
public class UploadImages {
    @EJB
    CarTypeService carTypeService;

    @GET
    public String loadImg() {
        List<CarType> carTypes = carTypeService.getAll();
        carTypes.forEach(carType -> {
            try {
                InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("Images/" + carType.getTypeId() + ".png");
                carType.setImg(ByteStreams.toByteArray(resourceAsStream));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                carTypeService.addCarType(carType);
            } catch (DuplicateEntryException e) {
                e.printStackTrace();
            }
        });
        return "Success";
    }
}
