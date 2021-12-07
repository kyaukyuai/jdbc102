package org.example

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.sql.*
import java.util.*
import java.util.logging.Logger

class CsvDriver(
) : Driver {

    companion object {
        private val INSTANCE: Driver = CsvDriver()
        private var registered: Boolean = false

        private fun load(): Driver {
            if (!registered) {
                registered = true
                try {
                    DriverManager.registerDriver(INSTANCE)
                } catch (throwable: SQLException) {
                    throwable.printStackTrace()
                }
            }

            return INSTANCE
        }

        init {
            load()
        }
    }

    override fun connect(url: String?, info: Properties?): Connection {
        val parts: List<String> = url?.let {
            it.split(":")
        } ?: run {
            throw SQLException("url is not String type")
        }

        if (parts.size < 2 || parts[0] != "jdbc" || parts[1] != "csv")
            throw SQLException("url is not String type")

        val directory: String = parts.drop(2).joinToString()

        val path: Path = Paths.get(directory).toAbsolutePath()

        if (!Files.isDirectory(path)) throw SQLException("'$path' is not a directory")

        return CsvConnection(path)
    }

    override fun acceptsURL(url: String?): Boolean {
        return true
    }

    override fun getPropertyInfo(url: String?, info: Properties?): Array<DriverPropertyInfo> {
        TODO("Not yet implemented")
    }

    override fun getMajorVersion(): Int {
        TODO("Not yet implemented")
    }

    override fun getMinorVersion(): Int {
        TODO("Not yet implemented")
    }

    override fun jdbcCompliant(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getParentLogger(): Logger {
        TODO("Not yet implemented")
    }
}
