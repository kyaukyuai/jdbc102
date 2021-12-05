package org.example

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.nio.file.Paths
import java.sql.Driver

class CsvDriverTest {
    @Test
    fun driver_works_in_normal_case() {
        val resourceName = "test01.csv"
        val classLoader = javaClass.classLoader
        val path = classLoader.getResource(resourceName).path
        println(path.toString())
        val parent = Paths.get(path).parent.toAbsolutePath().toString()
        println(parent)
        val driver: Driver = CsvDriver()

        driver.connect("jdbc:csv:$parent", null).let { it ->
            it.createStatement().let { it ->
                it.executeQuery("SELECT * FROM test01.csv;").let {
                    assertTrue(it.next())
                    assertEquals("A", it.getString(1))
                    assertEquals("B", it.getString(2))
                    assertTrue(it.next())
                    assertEquals("C", it.getString(1))
                    assertEquals("D", it.getString(2))
                    assertFalse(it.next())
                }
            }
        }
    }
}
