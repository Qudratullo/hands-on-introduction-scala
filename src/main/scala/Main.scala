import scala.util.Using
import scala.io.Source
import java.io.File
import java.io.FileWriter
@main def sayHello: Unit =
  val input: String = ""
  val output: String = ""
  etl(input, output)

def etl(inputFilePath: String, outputFilePath: String): Unit =
  val extracted = extract(inputFilePath)
  val transformed = transform(extracted)
  load(transformed, outputFilePath)

def extract(inputFilePath: String): List[String] = Using.resource(Source.fromFile(inputFilePath))(res => res.getLines.toList)

def transform(data: List[String]): List[String] = data.map(line => line.toLowerCase)

def load(
  data: List[String],
  outputFilePath: String = "src/main/resources/output.txt"
): Unit =
  val file = new File(outputFilePath)
  val fileWriter = new FileWriter(file)
  fileWriter.write(data.mkString("\n"))
  fileWriter.close()
end load

def sayHi(name: String): Unit =
  val otherName = "Asadulla"
  val listN = List(1, 2, 3)
  val listS = List("A", "B", "C")
  val things: List[String | Int | Double] = List(1, "A", 2.0)

  println(s"Hi $name!")
  println(listN)
  println(listS)
  println(things)
