package nl.uva.se.sc.niro.parser;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.BitSet;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ErrorListener implements ANTLRErrorListener {
	private static final Logger logger = LogManager.getLogger();
	private List<ParseErrorInfo> parseErrors = new LinkedList<>();

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {

		List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
		Collections.reverse(stack);
		parseErrors.add(new ParseErrorInfo(line, charPositionInLine, offendingSymbol.toString(), msg, stack, e));
	}

	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
		logger.error("reportAmbiguity");
	}

	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
		logger.error("reportAttemptingFullContext");
	}

	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
		logger.error("reportContextSensitivity");
	}

	public List<ParseErrorInfo> getParseErrors() {
		return parseErrors;
	}
}
