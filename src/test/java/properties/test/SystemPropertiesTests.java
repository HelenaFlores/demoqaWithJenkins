package properties.test;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {



    static final String remoteUrl = String.valueOf(System.getProperties()); //url удаленного браузера

    @Test
    void systemPropertiesTest() {
        String remoteUrl = String.valueOf(System.getProperties()); //url удаленного браузера
        String browser; // браузер
        String versionBrowser; //версия браузера
        String resolutionBrowser; // разрешение из сборки дженкинс
    }

    public static String getRemoteUrl() {
        return remoteUrl;
    }

}
