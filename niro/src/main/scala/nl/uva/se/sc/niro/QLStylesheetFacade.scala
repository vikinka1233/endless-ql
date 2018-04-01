package nl.uva.se.sc.niro

import java.io.File

import nl.uva.se.sc.niro.errors.Errors
import nl.uva.se.sc.niro.errors.Errors.Error
import nl.uva.se.sc.niro.model.ql.QLForm
import nl.uva.se.sc.niro.model.qls.QLStylesheet
import nl.uva.se.sc.niro.parser.QLStylesheetParser
import nl.uva.se.sc.niro.typechecking.qls.TypeCheckFacade
import org.antlr.v4.runtime.CharStreams

object QLStylesheetFacade {

  def importQLStylesheetSpecification(form: QLForm, qlsFile: File): Either[Seq[Errors.Error], Option[QLStylesheet]] = {
    if (qlsFile.exists()) {
      val stylesheet: QLStylesheet = QLStylesheetParser.parse(CharStreams.fromFileName(qlsFile.getAbsolutePath))
      val parseErrors: Seq[Error] = QLStylesheetParser.getParseErrors.toList
      if (parseErrors.isEmpty) {
        TypeCheckFacade.check(form, stylesheet).right.map(stylesheet => Some(stylesheet))
      } else {
        Left(parseErrors)
      }
    } else {
      Right(None)
    }
  }

}
