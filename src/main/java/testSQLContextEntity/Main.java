package testSQLContextEntity;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;//
import org.apache.spark.sql.SparkSession;

import java.util.Collections;


public class Main {
    public static void main(String[] args) {


        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL basic example")
                .config("spark.master", "local")
                .getOrCreate();



        User user = new User();
        user.setFirstName("Yurii");
        user.setLastName("Shmorgun");
        user.setAge(47);

        Encoder<User> userEncoder = Encoders.bean(User.class);
        Dataset<User> dataFrame = spark.createDataset(Collections.singletonList(user), userEncoder);

        dataFrame.show();

// +---+----+
// |age|name|
// +---+----+
// | 32|Andy|
// +---+----+






    }
}
