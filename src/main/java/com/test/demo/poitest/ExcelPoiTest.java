package com.test.demo.poitest;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileOutputStream;
import java.io.IOException;


public class ExcelPoiTest {
    public static void main(String[] args) throws IOException {
        String filePath="d:\\sample.xls";//文件路径
        HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
        HSSFSheet sheet = workbook.createSheet("Test");//创建工作表(Sheet)


        HSSFCellStyle textStyle = workbook.createCellStyle();
        HSSFDataFormat format = workbook.createDataFormat();
        textStyle.setDataFormat(format.getFormat("@"));
//        sheet.setDefaultColumnStyle(0,textStyle);


        /**
         * 设置单元格格式为文本
         * 直接设列是失效的
         * 单个单元格设是可行的
         */
        HSSFCell cell = sheet.createRow(0).createCell(0, CellType.STRING);
        cell.setCellStyle(textStyle); //设置单元格格式为"文本"
        cell.setCellValue("15210913667");



        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);//保存Excel文件
        out.close();//关闭文件流
        System.out.println("OK!");





    }


}
