package data.excel

import java.io.FileInputStream

import jxl.{Workbook, WorkbookSettings}

/**
  * Created by jeorch on 17-12-16.
  */
trait bmExcelTrait {
    def readExcel(excel_path: String) = {

        // 读取xls文件
//        val ins = new FileInputStream("D:/lesiea/文档/course.xls")
        val ins = new FileInputStream(excel_path)
        // 设置读文件编码
        val setEncode = new WorkbookSettings()
        setEncode.setEncoding("UTF-8")
        val rwb = Workbook.getWorkbook(ins, setEncode)
        val sheet = rwb.getSheet(0)
        val cols = sheet.getColumns
        // 列
        val rows = sheet.getRows
        // 行
        var i = 0
        while ( {
            i < rows
        }) {
            var c = 0
            while ( {
                c < cols
            }) {
                val excelRows = sheet.getCell(c, 0)
                val excel = sheet.getCell(c, i + 1)
                val strRow = excelRows.getContents
                val str = excel.getContents
                println(s"strRow=${strRow}")
                println(s"str=${str}")

                {
                    c += 1; c - 1
                }
            }
//            baseDao.geCollection("course").insertOne(document)

            {
                i += 1; i - 1
            }
        }
    }
}
