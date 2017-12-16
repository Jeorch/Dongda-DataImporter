package entry

import data.bmDataModule

/**
  * Created by jeorch on 17-12-16.
  */
object bmETMEntry extends App {
    println("Crazy demand！")
    val excel_path = "/home/jeorch/jeorch/test/16122017/test.xls"
    bmDataModule.readExcel(excel_path)
}
