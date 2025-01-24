import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import scala.io.Source
import scala.util.Try
import scala.util.Using
import scala.util.Success

class EtlSpec extends AnyFreeSpec with Matchers {
  "etl" - {
    "read file and transform all uppercase letters into lowercase and write" in {
      val input = "/workspaces/hands-on-introduction-scala/src/test/scala/resources/input.txt"
      val output = "/workspaces/hands-on-introduction-scala/src/test/scala/resources/output.txt"
      val expectedFileContents = List("hello world!")
      
      etl(input, output)

      readFile(output) shouldEqual Success(expectedFileContents)
    }
  }
  private def readFile(filePath: String): Try[List[String]] =
    Using(Source.fromFile(filePath))(_.getLines.toList)
}