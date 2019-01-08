package testSQLContext;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Main {

    public static void main(String[] args) {

        SparkSession sparkSession = SparkSession.builder()
                .appName("Java Spark SQL basic example")
                .config("spark.master", "local")
                .getOrCreate();

        FirstDataFrame firstDataFrame = new FirstDataFrame();
        firstDataFrame.createFirstDataFrame(sparkSession);







    }
}
