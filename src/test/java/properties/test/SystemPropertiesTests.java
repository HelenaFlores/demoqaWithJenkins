package properties.test;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {



    public static String getRemoteUrl() { //url удаленного браузера

        String remoteUrl = System.getProperty("remoteUrl");

        return remoteUrl;
    }
    @Test
    void systemPropertiesTest() {
        String browser; // браузер
        String versionBrowser; //версия браузера
        String resolutionBrowser; // разрешение из сборки дженкинс
    }

 /*   public static String getRemoteUrl() {
        return remoteUrl;
    }*/

}
