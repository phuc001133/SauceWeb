package testdata;

import core.helper.JSONHelper;
import org.testng.annotations.DataProvider;

public class SauceData {

    /**
     * read data product from file Json
     * @return object[][] contain data
     */
    @DataProvider
    public static Object[][] productDataFromJson()
    {
        return JSONHelper.readJsonFromFile("src/test/java/data/product.json");
    }

}
