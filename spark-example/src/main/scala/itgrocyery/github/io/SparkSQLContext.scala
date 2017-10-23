package itgrocyery.github.io

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

/**
  *
  * @ author chenxl
  * @ date 2017/10/23 15:34
  * @ describe
  *
  */
object SparkSQLContext {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SparkSQLContext").setMaster("local[4]")
    val sc = new SparkContext(conf)
//    val sqlContext = new SQLContext(sc)
//    val jdbcDF = sqlContext.read.format("jdbc")
//      .options(Map("url"-> "jdbc:mysql://188.188.2.177:3306/merge_tables_tool?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull"
//        ,"dbtable"->"t_api"
//        ,"user"->"holystar"
//        ,"password"->"holystar"))
//      .load()
//    jdbcDF.printSchema()

    val hiveContext = new HiveContext(sc)
    hiveContext.sql("select * from chenxl_bonus").printSchema()

  }

}
