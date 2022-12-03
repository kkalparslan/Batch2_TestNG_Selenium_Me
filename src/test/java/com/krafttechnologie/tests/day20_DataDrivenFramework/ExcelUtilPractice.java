package com.krafttechnologie.tests.day20_DataDrivenFramework;

import com.krafttechnologie.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilPractice {

    @Test
    public void readExcelFile(){
        /**
        ExcelUtil dan bir object olusturacagiz
        Object iki argument alacak Bunlar: Dosyanin
        pathi ile calisma yapacagimiz sayfanin adi olacak.
         */

        ExcelUtil qateam3=new ExcelUtil("src/test/resources/LoginList.xlsx", "QaTeam3");

        //once satir (row) sayisini bulalim
        System.out.println("qateam3.rowCount() = " + qateam3.rowCount());

        //Sayfada column sayisini bulalim
        System.out.println("qateam3.columnCount() = " + qateam3.columnCount());
        System.out.println("qateam3.getColumnsNames() = " + qateam3.getColumnsNames());
        //System.out.println("qateam3.getDataList() = " + qateam3.getDataList());

        //Simdi de qaTeam3 object atanan datayoi liste olarak cagiralim
        List<Map<String, String>> dataList = qateam3.getDataList();
        System.out.println("dataList = " + dataList);
        for (Map<String, String> row:qateam3.getDataList()){
            System.out.println("row = " + row);
        }

        //3. satiri getirelim index 0 dan başladığı için 2. index numarası 3. satıra tekamül ediyor
        System.out.println("dataList.get(2) = " + dataList.get(2));
        System.out.println("dataList.get(2).get(\"Your Name\") = " + dataList.get(2).get("Your Name"));

        //butun datayi 2 boyutlu array alalim
        String [][] dataArray= qateam3.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));
    }

}
