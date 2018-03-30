package nl.uva.se.sc.niro

import java.io.File

import nl.uva.se.sc.niro.model.ql.expressions.answers.{ Answer, DateAnswer, IntegerAnswer }
import org.scalatest.WordSpec

import scala.io.Source

class QLFormServiceTest extends WordSpec {

  "QLFormServiceTest" should {

    "save memory table to CSV" in {
      val memoryTable: Map[String, Answer] = Map(
        "dateConstant" -> DateAnswer("1970-01-01"),
        "integerVariable" -> IntegerAnswer(123),
        "integerConstant" -> IntegerAnswer(42))

      val file = File.createTempFile("niro-export", ".csv")
      file.deleteOnExit()

      QLFormService.saveMemoryTableToCSV(memoryTable, file)

      val actualFile = Source.fromFile(file).getLines().mkString
      val expectedFile = Source.fromResource("save-file/expected.csv").getLines().mkString

      assert(expectedFile == actualFile)
    }

  }
}