package itgrocyery.github.io

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  *
  * @ author chenxl
  * @ date 2017/10/23 14:30
  * @ describe
  *
  */
object SparkStreamingExample {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[2]").setAppName("SparkStreamExample")
    val ssc = new StreamingContext(conf,Seconds(5))
    val lines = ssc.socketTextStream("188.188.2.180",9999)
    val words = lines.flatMap(_.split(" "))
    val pairs = words.map((_,1))
    val wordConuts = pairs.reduceByKey(_ + _)
    wordConuts.print()
    ssc.start()
    ssc.awaitTermination()
  }

}
