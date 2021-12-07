import java.sql.DriverManager

fun main() {
    val url = "jdbc:csv:/Users/kyaukyuai/src/github.com/kyaukyuai/jdbc102/build/resources/test"

    Class.forName("org.example.CsvDriver")
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    val rs = st.executeQuery("SELECT * FROM test01.csv;")
    while (rs.next()) {
        println("rs[1]=" + rs.getString(1));
    }
}