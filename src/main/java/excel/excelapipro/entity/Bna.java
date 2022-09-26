package excel.excelapipro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Bna {

    @Id
    private Integer transportId;
    private String transportName;
    private String firstPlace;
    private LocalTime firstTime;
    private String lastPlace;
    private LocalTime lastTime;

}
