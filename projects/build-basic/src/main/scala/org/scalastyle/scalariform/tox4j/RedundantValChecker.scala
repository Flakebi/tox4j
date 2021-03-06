package org.scalastyle.scalariform.tox4j

import org.scalastyle._
import org.scalastyle.scalariform.{ AstChecker, VisitorHelper }

import _root_.scalariform.lexer.{ TokenType, Token }
import _root_.scalariform.parser._

final class RedundantValChecker extends AstChecker("redundant.val") {

  override def verify(ast: CompilationUnit, lines: Lines): List[ScalastyleError] = {
    for {
      fullDefOrDcl <- VisitorHelper.getAll[FullDefOrDcl](ast.immediateChildren.head)
      errors <- fullDefOrDcl.defOrDcl match {
        case tmplDef: TmplDef if isCaseClass(tmplDef) =>
          for {
            param <- VisitorHelper.getAll[Param](tmplDef.paramClausesOpt)
            if (param.valOrVarOpt match {
              case Some(Token(TokenType("VAL", _), _, _, _)) => true
              case _                                         => false
            })
          } yield {
            PositionError(param.firstToken.offset)
          }
        case _ =>
          Nil
      }
    } yield errors
  }

  private def isCaseClass(tmplDef: TmplDef): Boolean = {
    hasMarkerToken(tmplDef, "CASE") && hasMarkerToken(tmplDef, "CLASS")
  }

  private def hasMarkerToken(definition: TmplDef, tokenType: String): Boolean = {
    definition.markerTokens.exists { token => token.tokenType.name == tokenType }
  }

}
