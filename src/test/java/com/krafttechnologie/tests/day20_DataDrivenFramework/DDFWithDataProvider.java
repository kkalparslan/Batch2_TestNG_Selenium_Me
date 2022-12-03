package com.krafttechnologie.tests.day20_DataDrivenFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    //once @dataProviderdan metodumuzu olusturuyoruz
    //Bu metod testimize data saglayacak

    @DataProvider(name = "AracSatisOranlari")
    public Object [][] testData(){
        String [][] data={
                {"Audi", "100", "80", "65", "55"},
                {"Honda", "112", "127", "135", "60"},
                {"Tesla", "20", "30", "25", "15"},
                {"Mazda", "70", "50", "65", "75"},
                {"Porche", "40", "43", "22", "17"},
                {"Toyota", "110", "80", "95", "155"},
                {"Volvo", "10", "20", "35", "45"},
                {"Mercedes", "20", "25", "35", "44"},
        };
        return data;
    }
    @Test(dataProvider = "AracSatisOranlari")
    public void test(String aracMarkasi, String Ocak, String Subat, String Mart, String Nisan){
        System.out.println("Araç Markası: "+aracMarkasi+" :"+Ocak+", "+Subat+", "+Mart+", "+Nisan+"");

    }

}
