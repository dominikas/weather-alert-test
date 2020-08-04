package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public enum Directory {

    HOME_DIR(System.getProperty("user.home")),
    PROJECT_DIR(System.getProperty("user.dir")),
    REPORT_DIR(System.getProperty("user.dir")+"/report/");

    private String directory;

}
