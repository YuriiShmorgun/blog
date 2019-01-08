package testSQLContext;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import static org.apache.spark.sql.functions.col;

public class FirstDataFrame {

    public void createFirstDataFrame (SparkSession sparkSession){

        //sparkSession.read().json("my.json").show();

        Dataset<Row> dataFrame = sparkSession.read().json("my1.json");

        dataFrame.show();

/*+-----------------+--------------------+-------------+
|    _corrupt_record|                date|        title|
+-------------------+--------------------+-------------+
|                  {|                null|         null|
|  "name" : "Yurii",|                null|         null|
|          "events":|                null|         null|
|                  [|                null|         null|
|               null|2014-11-30T12:00:...|  Конференция|
|               null|2015-04-18T12:00:...|День рождения|
|                  ]|                null|         null|
|                  }|                null|         null|
+-------------------+--------------------+-------------+*/


        dataFrame.printSchema();
/*

        root
                |-- _corrupt_record: string (nullable = true)
                |-- date: string (nullable = true)
                |-- title: string (nullable = true)
*/

        dataFrame.select("age").show();

        /*
        +-------------+
        |        title|
        +-------------+
        |         null|
        |         null|
        |         null|
        |         null|
        |  Конференция|
        |День рождения|
        |         null|
        |         null|
        +-------------+*/



        dataFrame.select(col("name"),col("age").plus(1)).show();


        /*
        +-------+---------+
        |   name|(age + 1)|
        +-------+---------+
        |Michael|     null|
        |   Andy|       31|
        | Justin|       20|
        +-------+---------+
         */
        dataFrame.filter(col("age").gt(21)).show();



        dataFrame.groupBy("age").count().show();
        /*
        +----+-----+
        | age|count|
        +----+-----+
        |  19|    1|
        |null|    1|
        |  30|    2|
        +----+-----+
                */
    }
}
