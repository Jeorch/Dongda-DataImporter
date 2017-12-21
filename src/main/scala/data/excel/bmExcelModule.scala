package data.excel

import java.io.FileInputStream

import com.mongodb.casbah.Imports.ObjectId
import jxl.{Workbook, WorkbookSettings}

/**
  * Created by jeorch on 17-12-16.
  */
trait bmExcelModule {

    final val xls = "xls"
    final val xlsx = "xlsx"

    def readOnlyXLS(xls_path: String, startRow: Int, startCol: Int) : List[Map[String, String]] = {
        var cache: List[Map[String, String]] = Nil
        val ins = new FileInputStream(xls_path)
        val setEncode = new WorkbookSettings()
        setEncode.setEncoding("UTF-8")
        val rwb = Workbook.getWorkbook(ins, setEncode)
        val sheetsNum = rwb.getNumberOfSheets
        0 to sheetsNum - 1 foreach{x =>
            val sheet = rwb.getSheet(x)
            val curSheetName = sheet.getName
            val rows = sheet.getRows    // 行
            val cols = sheet.getColumns // 列
            var r = startRow - 1
            var last_line: Map[String, String] = Map.empty

            while (r < rows - 1) {
                var c = startCol - 1
                var map_tmp: Map[String, String] = Map.empty
                while (c < cols) {
                    val excelStartRow = sheet.getCell(c, startRow - 1)
                    val excel = sheet.getCell(c, r + 1)
                    val title = excelStartRow.getContents
                    val content = excel.getContents match {
                        case "" => last_line.get(title).getOrElse("")
                        case msg: String => msg
                    }

                    map_tmp += (title -> content)
                    c += 1
                }

                if (
                    last_line.get("品牌名").getOrElse("") == map_tmp.get("品牌名").getOrElse("") &&
                    last_line.get("品牌标识").getOrElse("") == map_tmp.get("品牌标识").getOrElse("")
                    ){
                    map_tmp += ("brand_id" -> last_line.get("brand_id").getOrElse(getObjectID))
                } else {
                    map_tmp += ("brand_id" -> getObjectID)
                }

                if (
                    last_line.get("场地位置").getOrElse("") == map_tmp.get("场地位置").getOrElse("") &&
                    last_line.get("场地友好性").getOrElse("") == map_tmp.get("场地友好性").getOrElse("")
                    ){
                    map_tmp += ("location_id" -> last_line.get("location_id").getOrElse(getObjectID))
                } else {
                    map_tmp += ("location_id" -> getObjectID)
                }

                last_line = map_tmp
                map_tmp += ("service_type" -> curSheetName,
                    "service_id" -> getObjectID
                )
                cache = map_tmp :: cache
                r += 1
            }
        }
        cache
    }

    def getObjectID : String = {
        val objectID = new ObjectId
        objectID.toString
    }

    def readCommonExcel(excel_path: String) = {

    }
}
