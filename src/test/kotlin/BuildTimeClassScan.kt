import me.bristermitten.plumber.aspect.ClassGraphProvider
import me.bristermitten.plumber.aspect.PlumberInfo
import me.bristermitten.plumber.reflection.ClassFinder
import java.io.File
import java.io.PrintWriter

/**
 * Not exactly a test, but this will ensure it is not compiled with main files.
 * Creates a File store of Plumber's ClassGraph ScanResult for faster access at runtime.
 *
 * Users should call this upon compilation as the scan will not include external classes otherwise
 *
 * @author Alexander Wood (BristerMitten)
 */
class BuildTimeClassScan {

    companion object {
        private const val OUTPUT_NAME = ClassFinder.SCAN_FILE_NAME

        @JvmStatic
        fun main(args: Array<String>) {
            if (args.isEmpty())
                throw IllegalArgumentException("Directory must be provided")
            if (args.size < 2) {
                throw IllegalArgumentException("[directory] [package]")
            }

            val outputFile = File(args[0], OUTPUT_NAME)

            outputFile.createNewFile()

            val info = PlumberInfo(args[1])

            ClassGraphProvider(info).get()
                .scan().use {
                    PrintWriter(outputFile).use { writer ->
                        writer.print(it.toJSON())
                    }
                }
        }
    }
}
