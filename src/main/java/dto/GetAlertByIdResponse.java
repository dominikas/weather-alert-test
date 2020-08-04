package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAlertByIdResponse {

    private String id;
    private String type;
    private GeometryDto geometry;

    private String title;
    private int status;
}
