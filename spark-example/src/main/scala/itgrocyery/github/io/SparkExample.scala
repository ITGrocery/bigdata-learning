package itgrocyery.github.io

import org.apache.spark.{SparkConf, SparkContext}

/**
  *
  * @ author chenxl
  * @ date 2017/10/23 13:59
  * @ describe
  *
  */
object SparkExample {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SparkExample").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val filePath = "C:\\Users\\chenxl\\Desktop\\bigdata-learning\\spark-example\\src\\main\\resource\\words.txt"
    sc.textFile(filePath)
      .flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      .collect()
      .foreach(println)
  }

}
