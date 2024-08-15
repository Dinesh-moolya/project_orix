package utilities;

import java.util.Properties;

public class CredsLoader {
    private final Properties properties;

    public CredsLoader() {
        properties = PropertyUtils.propertyLoader(System.getProperty("credsFilePath",
                "E:\\OrixIndia-ui-tests-automation4\\src\\test\\resources\\devconfig.properties"));
    }

    public String getProperty(String property) {
        String prop = properties.getProperty(property);
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("Property " + property + " is not specified in the creds file");
    }

}
