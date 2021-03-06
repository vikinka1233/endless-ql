// Generated from C:/dev/uva/endless-ql/Abel_Elias/src/QLS/parsing\QLS.g4 by ANTLR 4.7
package QLS.parsing.gen;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLSParser extends Parser {
    public static final int
            WS = 1, BOOLEANTYPE = 2, STRINGTYPE = 3, INTEGERTYPE = 4, MONEYTYPE = 5, DATETYPE = 6,
            DECIMALTYPE = 7, SLIDER = 8, SPINBOX = 9, CHECKBOX = 10, TEXT = 11, RADIO = 12, DROPDOWN = 13,
            WIDTH = 14, FONT = 15, FONTSIZE = 16, COLOR = 17, STYLESHEET = 18, PAGE = 19, SECTION = 20,
            DEFAULT = 21, WIDGET = 22, QUESTION = 23, CURLY_BRACE_L = 24, CURLY_BRACE_R = 25,
            BRACE_L = 26, BRACE_R = 27, BRACKET_L = 28, BRACKET_R = 29, COLON = 30, COMMA = 31,
            BOOL = 32, IDENTIFIER = 33, STR = 34, INT = 35, MON = 36, DEC = 37, NEWLINE = 38, CLR = 39,
            WHITESPACE = 40, MULTICOMMENT = 41, SINGLECOMMENT = 42;
    public static final int
            RULE_stylesheet = 0, RULE_page = 1, RULE_section = 2, RULE_element = 3,
            RULE_question = 4, RULE_defaultWidget = 5, RULE_widget = 6, RULE_widgetType = 7,
            RULE_checkboxWidget = 8, RULE_textWidget = 9, RULE_radioWidget = 10, RULE_spinboxWidget = 11,
            RULE_sliderWidget = 12, RULE_dropdownWidget = 13, RULE_style = 14, RULE_argList = 15,
            RULE_type = 16, RULE_defaultdef = 17, RULE_blockdefault = 18, RULE_linedefault = 19,
            RULE_widgetProperty = 20, RULE_widthproperty = 21, RULE_fontproperty = 22,
            RULE_fontsizeproperty = 23, RULE_colorproperty = 24, RULE_value = 25;
    public static final String[] ruleNames = {
            "stylesheet", "page", "section", "element", "question", "defaultWidget",
            "widget", "widgetType", "checkboxWidget", "textWidget", "radioWidget",
            "spinboxWidget", "sliderWidget", "dropdownWidget", "style", "argList",
            "type", "defaultdef", "blockdefault", "linedefault", "widgetProperty",
            "widthproperty", "fontproperty", "fontsizeproperty", "colorproperty",
            "value"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u010b\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\3\2\3\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\7\2A" +
                    "\n\2\f\2\16\2D\13\2\3\2\7\2G\n\2\f\2\16\2J\13\2\3\2\3\2\3\2\3\3\3\3\3" +
                    "\3\3\3\7\3S\n\3\f\3\16\3V\13\3\3\3\7\3Y\n\3\f\3\16\3\\\13\3\3\3\3\3\7" +
                    "\3`\n\3\f\3\16\3c\13\3\3\4\3\4\3\4\5\4h\n\4\3\4\7\4k\n\4\f\4\16\4n\13" +
                    "\4\3\4\5\4q\n\4\3\4\7\4t\n\4\f\4\16\4w\13\4\3\5\3\5\7\5{\n\5\f\5\16\5" +
                    "~\13\5\3\5\3\5\7\5\u0082\n\5\f\5\16\5\u0085\13\5\3\5\3\5\7\5\u0089\n\5" +
                    "\f\5\16\5\u008c\13\5\5\5\u008e\n\5\3\6\3\6\3\6\5\6\u0093\n\6\3\6\3\6\3" +
                    "\6\5\6\u0098\n\6\5\6\u009a\n\6\3\7\3\7\3\7\3\7\5\7\u00a0\n\7\3\7\7\7\u00a3" +
                    "\n\7\f\7\16\7\u00a6\13\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00b1" +
                    "\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3" +
                    "\17\3\17\3\20\3\20\6\20\u00c5\n\20\r\20\16\20\u00c6\3\20\3\20\3\21\3\21" +
                    "\3\21\7\21\u00ce\n\21\f\21\16\21\u00d1\13\21\3\21\5\21\u00d4\n\21\3\21" +
                    "\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00de\n\22\3\23\3\23\5\23\u00e2" +
                    "\n\23\3\24\3\24\3\24\3\24\6\24\u00e8\n\24\r\24\16\24\u00e9\3\24\3\24\3" +
                    "\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\5\26\u00f7\n\26\3\27\3\27" +
                    "\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32" +
                    "\3\33\3\33\3\33\2\2\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*," +
                    ".\60\62\64\2\3\3\2$%\2\u0117\2\66\3\2\2\2\4N\3\2\2\2\6d\3\2\2\2\b\u008d" +
                    "\3\2\2\2\n\u0099\3\2\2\2\f\u009b\3\2\2\2\16\u00a7\3\2\2\2\20\u00b0\3\2" +
                    "\2\2\22\u00b2\3\2\2\2\24\u00b4\3\2\2\2\26\u00b6\3\2\2\2\30\u00b9\3\2\2" +
                    "\2\32\u00bb\3\2\2\2\34\u00bf\3\2\2\2\36\u00c2\3\2\2\2 \u00ca\3\2\2\2\"" +
                    "\u00dd\3\2\2\2$\u00e1\3\2\2\2&\u00e3\3\2\2\2(\u00ed\3\2\2\2*\u00f6\3\2" +
                    "\2\2,\u00f8\3\2\2\2.\u00fc\3\2\2\2\60\u0100\3\2\2\2\62\u0104\3\2\2\2\64" +
                    "\u0108\3\2\2\2\66\67\7\24\2\2\67;\7#\2\28:\7(\2\298\3\2\2\2:=\3\2\2\2" +
                    ";9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>B\7\32\2\2?A\5\4\3\2@?\3\2\2" +
                    "\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CH\3\2\2\2DB\3\2\2\2EG\7(\2\2FE\3\2\2" +
                    "\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\7\33\2\2LM\7\2" +
                    "\2\3M\3\3\2\2\2NO\7\25\2\2OP\7#\2\2PT\7\32\2\2QS\5\6\4\2RQ\3\2\2\2SV\3" +
                    "\2\2\2TR\3\2\2\2TU\3\2\2\2UZ\3\2\2\2VT\3\2\2\2WY\5\f\7\2XW\3\2\2\2Y\\" +
                    "\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]a\7\33\2\2^`\7(\2\2" +
                    "_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\5\3\2\2\2ca\3\2\2\2de\7\26\2" +
                    "\2eg\7$\2\2fh\7\32\2\2gf\3\2\2\2gh\3\2\2\2hl\3\2\2\2ik\5\b\5\2ji\3\2\2" +
                    "\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mp\3\2\2\2nl\3\2\2\2oq\7\33\2\2po\3\2" +
                    "\2\2pq\3\2\2\2qu\3\2\2\2rt\7(\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2" +
                    "\2\2v\7\3\2\2\2wu\3\2\2\2x|\5\6\4\2y{\7(\2\2zy\3\2\2\2{~\3\2\2\2|z\3\2" +
                    "\2\2|}\3\2\2\2}\u008e\3\2\2\2~|\3\2\2\2\177\u0083\5\f\7\2\u0080\u0082" +
                    "\7(\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083" +
                    "\u0084\3\2\2\2\u0084\u008e\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u008a\5\n" +
                    "\6\2\u0087\u0089\7(\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a" +
                    "\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2" +
                    "\2\2\u008dx\3\2\2\2\u008d\177\3\2\2\2\u008d\u0086\3\2\2\2\u008e\t\3\2" +
                    "\2\2\u008f\u0090\7\31\2\2\u0090\u0092\7#\2\2\u0091\u0093\5\16\b\2\u0092" +
                    "\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u009a\3\2\2\2\u0094\u0095\7\31" +
                    "\2\2\u0095\u0097\7#\2\2\u0096\u0098\5\36\20\2\u0097\u0096\3\2\2\2\u0097" +
                    "\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u008f\3\2\2\2\u0099\u0094\3\2" +
                    "\2\2\u009a\13\3\2\2\2\u009b\u009c\7\27\2\2\u009c\u009f\5\"\22\2\u009d" +
                    "\u00a0\5\16\b\2\u009e\u00a0\5\36\20\2\u009f\u009d\3\2\2\2\u009f\u009e" +
                    "\3\2\2\2\u00a0\u00a4\3\2\2\2\u00a1\u00a3\7(\2\2\u00a2\u00a1\3\2\2\2\u00a3" +
                    "\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\r\3\2\2\2" +
                    "\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7\30\2\2\u00a8\u00a9\5\20\t\2\u00a9\17" +
                    "\3\2\2\2\u00aa\u00b1\5\22\n\2\u00ab\u00b1\5\24\13\2\u00ac\u00b1\5\26\f" +
                    "\2\u00ad\u00b1\5\30\r\2\u00ae\u00b1\5\32\16\2\u00af\u00b1\5\34\17\2\u00b0" +
                    "\u00aa\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b0\u00ad\3\2" +
                    "\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\21\3\2\2\2\u00b2\u00b3" +
                    "\7\f\2\2\u00b3\23\3\2\2\2\u00b4\u00b5\7\r\2\2\u00b5\25\3\2\2\2\u00b6\u00b7" +
                    "\7\16\2\2\u00b7\u00b8\5 \21\2\u00b8\27\3\2\2\2\u00b9\u00ba\7\13\2\2\u00ba" +
                    "\31\3\2\2\2\u00bb\u00bc\7\n\2\2\u00bc\u00bd\7%\2\2\u00bd\u00be\7%\2\2" +
                    "\u00be\33\3\2\2\2\u00bf\u00c0\7\17\2\2\u00c0\u00c1\5 \21\2\u00c1\35\3" +
                    "\2\2\2\u00c2\u00c4\7\32\2\2\u00c3\u00c5\5*\26\2\u00c4\u00c3\3\2\2\2\u00c5" +
                    "\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2" +
                    "\2\2\u00c8\u00c9\7\33\2\2\u00c9\37\3\2\2\2\u00ca\u00cf\7\36\2\2\u00cb" +
                    "\u00cc\7$\2\2\u00cc\u00ce\7!\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2" +
                    "\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf" +
                    "\3\2\2\2\u00d2\u00d4\7$\2\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4" +
                    "\u00d5\3\2\2\2\u00d5\u00d6\7\37\2\2\u00d6!\3\2\2\2\u00d7\u00de\7\4\2\2" +
                    "\u00d8\u00de\7\5\2\2\u00d9\u00de\7\6\2\2\u00da\u00de\7\7\2\2\u00db\u00de" +
                    "\7\b\2\2\u00dc\u00de\7\t\2\2\u00dd\u00d7\3\2\2\2\u00dd\u00d8\3\2\2\2\u00dd" +
                    "\u00d9\3\2\2\2\u00dd\u00da\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2" +
                    "\2\2\u00de#\3\2\2\2\u00df\u00e2\5&\24\2\u00e0\u00e2\5(\25\2\u00e1\u00df" +
                    "\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2%\3\2\2\2\u00e3\u00e4\7\27\2\2\u00e4" +
                    "\u00e5\5\"\22\2\u00e5\u00e7\7\32\2\2\u00e6\u00e8\5*\26\2\u00e7\u00e6\3" +
                    "\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea" +
                    "\u00eb\3\2\2\2\u00eb\u00ec\7\33\2\2\u00ec\'\3\2\2\2\u00ed\u00ee\7\27\2" +
                    "\2\u00ee\u00ef\5\"\22\2\u00ef\u00f0\5*\26\2\u00f0)\3\2\2\2\u00f1\u00f7" +
                    "\5,\27\2\u00f2\u00f7\5.\30\2\u00f3\u00f7\5\60\31\2\u00f4\u00f7\5\62\32" +
                    "\2\u00f5\u00f7\5\16\b\2\u00f6\u00f1\3\2\2\2\u00f6\u00f2\3\2\2\2\u00f6" +
                    "\u00f3\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7+\3\2\2\2" +
                    "\u00f8\u00f9\7\20\2\2\u00f9\u00fa\7 \2\2\u00fa\u00fb\7%\2\2\u00fb-\3\2" +
                    "\2\2\u00fc\u00fd\7\21\2\2\u00fd\u00fe\7 \2\2\u00fe\u00ff\7$\2\2\u00ff" +
                    "/\3\2\2\2\u0100\u0101\7\22\2\2\u0101\u0102\7 \2\2\u0102\u0103\7%\2\2\u0103" +
                    "\61\3\2\2\2\u0104\u0105\7\23\2\2\u0105\u0106\7 \2\2\u0106\u0107\7)\2\2" +
                    "\u0107\63\3\2\2\2\u0108\u0109\t\2\2\2\u0109\65\3\2\2\2\35;BHTZaglpu|\u0083" +
                    "\u008a\u008d\u0092\u0097\u0099\u009f\u00a4\u00b0\u00c6\u00cf\u00d3\u00dd" +
                    "\u00e1\u00e9\u00f6";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, null, "'boolean'", "'string'", "'integer'", null, "'date'", "'decimal'",
            "'slider'", "'spinbox'", "'checkbox'", "'text'", "'radio'", "'dropdown'",
            "'width'", "'font'", "'fontsize'", "'color'", "'stylesheet'", "'page'",
            "'section'", "'default'", "'widget'", "'question'", "'{'", "'}'", "'('",
            "')'", "'['", "']'", "':'", "','"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "WS", "BOOLEANTYPE", "STRINGTYPE", "INTEGERTYPE", "MONEYTYPE", "DATETYPE",
            "DECIMALTYPE", "SLIDER", "SPINBOX", "CHECKBOX", "TEXT", "RADIO", "DROPDOWN",
            "WIDTH", "FONT", "FONTSIZE", "COLOR", "STYLESHEET", "PAGE", "SECTION",
            "DEFAULT", "WIDGET", "QUESTION", "CURLY_BRACE_L", "CURLY_BRACE_R", "BRACE_L",
            "BRACE_R", "BRACKET_L", "BRACKET_R", "COLON", "COMMA", "BOOL", "IDENTIFIER",
            "STR", "INT", "MON", "DEC", "NEWLINE", "CLR", "WHITESPACE", "MULTICOMMENT",
            "SINGLECOMMENT"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public QLSParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "QLS.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final StylesheetContext stylesheet() throws RecognitionException {
        StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_stylesheet);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(52);
                match(STYLESHEET);
                setState(53);
                match(IDENTIFIER);
                setState(57);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == NEWLINE) {
                    {
                        {
                            setState(54);
                            match(NEWLINE);
                        }
                    }
                    setState(59);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(60);
                match(CURLY_BRACE_L);
                setState(64);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == PAGE) {
                    {
                        {
                            setState(61);
                            page();
                        }
                    }
                    setState(66);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(70);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == NEWLINE) {
                    {
                        {
                            setState(67);
                            match(NEWLINE);
                        }
                    }
                    setState(72);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(73);
                match(CURLY_BRACE_R);
                setState(74);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PageContext page() throws RecognitionException {
        PageContext _localctx = new PageContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_page);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(76);
                match(PAGE);
                setState(77);
                match(IDENTIFIER);
                setState(78);
                match(CURLY_BRACE_L);
                setState(82);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == SECTION) {
                    {
                        {
                            setState(79);
                            section();
                        }
                    }
                    setState(84);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(88);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == DEFAULT) {
                    {
                        {
                            setState(85);
                            defaultWidget();
                        }
                    }
                    setState(90);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(91);
                match(CURLY_BRACE_R);
                setState(95);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(92);
                                match(NEWLINE);
                            }
                        }
                    }
                    setState(97);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SectionContext section() throws RecognitionException {
        SectionContext _localctx = new SectionContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_section);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(98);
                match(SECTION);
                setState(99);
                match(STR);
                setState(101);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == CURLY_BRACE_L) {
                    {
                        setState(100);
                        match(CURLY_BRACE_L);
                    }
                }

                setState(106);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(103);
                                element();
                            }
                        }
                    }
                    setState(108);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
                }
                setState(110);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 8, _ctx)) {
                    case 1: {
                        setState(109);
                        match(CURLY_BRACE_R);
                    }
                    break;
                }
                setState(115);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(112);
                                match(NEWLINE);
                            }
                        }
                    }
                    setState(117);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ElementContext element() throws RecognitionException {
        ElementContext _localctx = new ElementContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_element);
        try {
            int _alt;
            setState(139);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case SECTION:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(118);
                    section();
                    setState(122);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
                    while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(119);
                                    match(NEWLINE);
                                }
                            }
                        }
                        setState(124);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
                    }
                }
                break;
                case DEFAULT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(125);
                    defaultWidget();
                    setState(129);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 11, _ctx);
                    while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(126);
                                    match(NEWLINE);
                                }
                            }
                        }
                        setState(131);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 11, _ctx);
                    }
                }
                break;
                case QUESTION:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(132);
                    question();
                    setState(136);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
                    while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(133);
                                    match(NEWLINE);
                                }
                            }
                        }
                        setState(138);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
                    }
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final QuestionContext question() throws RecognitionException {
        QuestionContext _localctx = new QuestionContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_question);
        int _la;
        try {
            setState(151);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(141);
                    match(QUESTION);
                    setState(142);
                    match(IDENTIFIER);
                    setState(144);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == WIDGET) {
                        {
                            setState(143);
                            widget();
                        }
                    }

                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(146);
                    match(QUESTION);
                    setState(147);
                    match(IDENTIFIER);
                    setState(149);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == CURLY_BRACE_L) {
                        {
                            setState(148);
                            style();
                        }
                    }

                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DefaultWidgetContext defaultWidget() throws RecognitionException {
        DefaultWidgetContext _localctx = new DefaultWidgetContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_defaultWidget);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(153);
                match(DEFAULT);
                setState(154);
                type();
                setState(157);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case WIDGET: {
                        setState(155);
                        widget();
                    }
                    break;
                    case CURLY_BRACE_L: {
                        setState(156);
                        style();
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(162);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 18, _ctx);
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(159);
                                match(NEWLINE);
                            }
                        }
                    }
                    setState(164);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 18, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final WidgetContext widget() throws RecognitionException {
        WidgetContext _localctx = new WidgetContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_widget);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(165);
                match(WIDGET);
                setState(166);
                widgetType();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final WidgetTypeContext widgetType() throws RecognitionException {
        WidgetTypeContext _localctx = new WidgetTypeContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_widgetType);
        try {
            setState(174);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case CHECKBOX:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(168);
                    checkboxWidget();
                }
                break;
                case TEXT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(169);
                    textWidget();
                }
                break;
                case RADIO:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(170);
                    radioWidget();
                }
                break;
                case SPINBOX:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(171);
                    spinboxWidget();
                }
                break;
                case SLIDER:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(172);
                    sliderWidget();
                }
                break;
                case DROPDOWN:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(173);
                    dropdownWidget();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final CheckboxWidgetContext checkboxWidget() throws RecognitionException {
        CheckboxWidgetContext _localctx = new CheckboxWidgetContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_checkboxWidget);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(176);
                match(CHECKBOX);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TextWidgetContext textWidget() throws RecognitionException {
        TextWidgetContext _localctx = new TextWidgetContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_textWidget);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(178);
                match(TEXT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final RadioWidgetContext radioWidget() throws RecognitionException {
        RadioWidgetContext _localctx = new RadioWidgetContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_radioWidget);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(180);
                match(RADIO);
                setState(181);
                argList();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SpinboxWidgetContext spinboxWidget() throws RecognitionException {
        SpinboxWidgetContext _localctx = new SpinboxWidgetContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_spinboxWidget);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(183);
                match(SPINBOX);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SliderWidgetContext sliderWidget() throws RecognitionException {
        SliderWidgetContext _localctx = new SliderWidgetContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_sliderWidget);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(185);
                match(SLIDER);
                setState(186);
                ((SliderWidgetContext) _localctx).min = match(INT);
                setState(187);
                ((SliderWidgetContext) _localctx).max = match(INT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DropdownWidgetContext dropdownWidget() throws RecognitionException {
        DropdownWidgetContext _localctx = new DropdownWidgetContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_dropdownWidget);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(189);
                match(DROPDOWN);
                setState(190);
                argList();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StyleContext style() throws RecognitionException {
        StyleContext _localctx = new StyleContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_style);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(192);
                match(CURLY_BRACE_L);
                setState(194);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(193);
                            widgetProperty();
                        }
                    }
                    setState(196);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WIDTH) | (1L << FONT) | (1L << FONTSIZE) | (1L << COLOR) | (1L << WIDGET))) != 0));
                setState(198);
                match(CURLY_BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ArgListContext argList() throws RecognitionException {
        ArgListContext _localctx = new ArgListContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_argList);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(200);
                match(BRACKET_L);
                {
                    setState(205);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 21, _ctx);
                    while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(201);
                                    match(STR);
                                    setState(202);
                                    match(COMMA);
                                }
                            }
                        }
                        setState(207);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 21, _ctx);
                    }
                    setState(209);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == STR) {
                        {
                            setState(208);
                            match(STR);
                        }
                    }

                }
                setState(211);
                match(BRACKET_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeContext type() throws RecognitionException {
        TypeContext _localctx = new TypeContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_type);
        try {
            setState(219);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case BOOLEANTYPE:
                    _localctx = new BooltypeContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(213);
                    match(BOOLEANTYPE);
                }
                break;
                case STRINGTYPE:
                    _localctx = new StringtypeContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(214);
                    match(STRINGTYPE);
                }
                break;
                case INTEGERTYPE:
                    _localctx = new IntegertypeContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(215);
                    match(INTEGERTYPE);
                }
                break;
                case MONEYTYPE:
                    _localctx = new MoneytypeContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(216);
                    match(MONEYTYPE);
                }
                break;
                case DATETYPE:
                    _localctx = new DatetypeContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(217);
                    match(DATETYPE);
                }
                break;
                case DECIMALTYPE:
                    _localctx = new DecimaltypeContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(218);
                    match(DECIMALTYPE);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DefaultdefContext defaultdef() throws RecognitionException {
        DefaultdefContext _localctx = new DefaultdefContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_defaultdef);
        try {
            setState(223);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 24, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(221);
                    blockdefault();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(222);
                    linedefault();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BlockdefaultContext blockdefault() throws RecognitionException {
        BlockdefaultContext _localctx = new BlockdefaultContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_blockdefault);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(225);
                match(DEFAULT);
                setState(226);
                type();
                setState(227);
                match(CURLY_BRACE_L);
                setState(229);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(228);
                            widgetProperty();
                        }
                    }
                    setState(231);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WIDTH) | (1L << FONT) | (1L << FONTSIZE) | (1L << COLOR) | (1L << WIDGET))) != 0));
                setState(233);
                match(CURLY_BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LinedefaultContext linedefault() throws RecognitionException {
        LinedefaultContext _localctx = new LinedefaultContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_linedefault);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(235);
                match(DEFAULT);
                setState(236);
                type();
                setState(237);
                widgetProperty();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final WidgetPropertyContext widgetProperty() throws RecognitionException {
        WidgetPropertyContext _localctx = new WidgetPropertyContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_widgetProperty);
        try {
            setState(244);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WIDTH:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(239);
                    widthproperty();
                }
                break;
                case FONT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(240);
                    fontproperty();
                }
                break;
                case FONTSIZE:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(241);
                    fontsizeproperty();
                }
                break;
                case COLOR:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(242);
                    colorproperty();
                }
                break;
                case WIDGET:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(243);
                    widget();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final WidthpropertyContext widthproperty() throws RecognitionException {
        WidthpropertyContext _localctx = new WidthpropertyContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_widthproperty);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(246);
                match(WIDTH);
                setState(247);
                match(COLON);
                setState(248);
                match(INT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FontpropertyContext fontproperty() throws RecognitionException {
        FontpropertyContext _localctx = new FontpropertyContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_fontproperty);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(250);
                match(FONT);
                setState(251);
                match(COLON);
                setState(252);
                match(STR);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FontsizepropertyContext fontsizeproperty() throws RecognitionException {
        FontsizepropertyContext _localctx = new FontsizepropertyContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_fontsizeproperty);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(254);
                match(FONTSIZE);
                setState(255);
                match(COLON);
                setState(256);
                match(INT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ColorpropertyContext colorproperty() throws RecognitionException {
        ColorpropertyContext _localctx = new ColorpropertyContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_colorproperty);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(258);
                match(COLOR);
                setState(259);
                match(COLON);
                setState(260);
                match(CLR);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ValueContext value() throws RecognitionException {
        ValueContext _localctx = new ValueContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_value);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(262);
                _la = _input.LA(1);
                if (!(_la == STR || _la == INT)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StylesheetContext extends ParserRuleContext {
        public StylesheetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode STYLESHEET() {
            return getToken(QLSParser.STYLESHEET, 0);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(QLSParser.IDENTIFIER, 0);
        }

        public TerminalNode CURLY_BRACE_L() {
            return getToken(QLSParser.CURLY_BRACE_L, 0);
        }

        public TerminalNode CURLY_BRACE_R() {
            return getToken(QLSParser.CURLY_BRACE_R, 0);
        }

        public TerminalNode EOF() {
            return getToken(QLSParser.EOF, 0);
        }

        public List<TerminalNode> NEWLINE() {
            return getTokens(QLSParser.NEWLINE);
        }

        public TerminalNode NEWLINE(int i) {
            return getToken(QLSParser.NEWLINE, i);
        }

        public List<PageContext> page() {
            return getRuleContexts(PageContext.class);
        }

        public PageContext page(int i) {
            return getRuleContext(PageContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stylesheet;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitStylesheet(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class PageContext extends ParserRuleContext {
        public PageContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PAGE() {
            return getToken(QLSParser.PAGE, 0);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(QLSParser.IDENTIFIER, 0);
        }

        public TerminalNode CURLY_BRACE_L() {
            return getToken(QLSParser.CURLY_BRACE_L, 0);
        }

        public TerminalNode CURLY_BRACE_R() {
            return getToken(QLSParser.CURLY_BRACE_R, 0);
        }

        public List<SectionContext> section() {
            return getRuleContexts(SectionContext.class);
        }

        public SectionContext section(int i) {
            return getRuleContext(SectionContext.class, i);
        }

        public List<DefaultWidgetContext> defaultWidget() {
            return getRuleContexts(DefaultWidgetContext.class);
        }

        public DefaultWidgetContext defaultWidget(int i) {
            return getRuleContext(DefaultWidgetContext.class, i);
        }

        public List<TerminalNode> NEWLINE() {
            return getTokens(QLSParser.NEWLINE);
        }

        public TerminalNode NEWLINE(int i) {
            return getToken(QLSParser.NEWLINE, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_page;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitPage(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SectionContext extends ParserRuleContext {
        public SectionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SECTION() {
            return getToken(QLSParser.SECTION, 0);
        }

        public TerminalNode STR() {
            return getToken(QLSParser.STR, 0);
        }

        public TerminalNode CURLY_BRACE_L() {
            return getToken(QLSParser.CURLY_BRACE_L, 0);
        }

        public List<ElementContext> element() {
            return getRuleContexts(ElementContext.class);
        }

        public ElementContext element(int i) {
            return getRuleContext(ElementContext.class, i);
        }

        public TerminalNode CURLY_BRACE_R() {
            return getToken(QLSParser.CURLY_BRACE_R, 0);
        }

        public List<TerminalNode> NEWLINE() {
            return getTokens(QLSParser.NEWLINE);
        }

        public TerminalNode NEWLINE(int i) {
            return getToken(QLSParser.NEWLINE, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_section;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitSection(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ElementContext extends ParserRuleContext {
        public ElementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public SectionContext section() {
            return getRuleContext(SectionContext.class, 0);
        }

        public List<TerminalNode> NEWLINE() {
            return getTokens(QLSParser.NEWLINE);
        }

        public TerminalNode NEWLINE(int i) {
            return getToken(QLSParser.NEWLINE, i);
        }

        public DefaultWidgetContext defaultWidget() {
            return getRuleContext(DefaultWidgetContext.class, 0);
        }

        public QuestionContext question() {
            return getRuleContext(QuestionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_element;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitElement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class QuestionContext extends ParserRuleContext {
        public QuestionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode QUESTION() {
            return getToken(QLSParser.QUESTION, 0);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(QLSParser.IDENTIFIER, 0);
        }

        public WidgetContext widget() {
            return getRuleContext(WidgetContext.class, 0);
        }

        public StyleContext style() {
            return getRuleContext(StyleContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_question;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitQuestion(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DefaultWidgetContext extends ParserRuleContext {
        public DefaultWidgetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DEFAULT() {
            return getToken(QLSParser.DEFAULT, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public WidgetContext widget() {
            return getRuleContext(WidgetContext.class, 0);
        }

        public StyleContext style() {
            return getRuleContext(StyleContext.class, 0);
        }

        public List<TerminalNode> NEWLINE() {
            return getTokens(QLSParser.NEWLINE);
        }

        public TerminalNode NEWLINE(int i) {
            return getToken(QLSParser.NEWLINE, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_defaultWidget;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitDefaultWidget(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class WidgetContext extends ParserRuleContext {
        public WidgetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WIDGET() {
            return getToken(QLSParser.WIDGET, 0);
        }

        public WidgetTypeContext widgetType() {
            return getRuleContext(WidgetTypeContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_widget;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitWidget(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class WidgetTypeContext extends ParserRuleContext {
        public WidgetTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public CheckboxWidgetContext checkboxWidget() {
            return getRuleContext(CheckboxWidgetContext.class, 0);
        }

        public TextWidgetContext textWidget() {
            return getRuleContext(TextWidgetContext.class, 0);
        }

        public RadioWidgetContext radioWidget() {
            return getRuleContext(RadioWidgetContext.class, 0);
        }

        public SpinboxWidgetContext spinboxWidget() {
            return getRuleContext(SpinboxWidgetContext.class, 0);
        }

        public SliderWidgetContext sliderWidget() {
            return getRuleContext(SliderWidgetContext.class, 0);
        }

        public DropdownWidgetContext dropdownWidget() {
            return getRuleContext(DropdownWidgetContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_widgetType;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitWidgetType(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CheckboxWidgetContext extends ParserRuleContext {
        public CheckboxWidgetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode CHECKBOX() {
            return getToken(QLSParser.CHECKBOX, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_checkboxWidget;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitCheckboxWidget(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class TextWidgetContext extends ParserRuleContext {
        public TextWidgetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TEXT() {
            return getToken(QLSParser.TEXT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_textWidget;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitTextWidget(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class RadioWidgetContext extends ParserRuleContext {
        public RadioWidgetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode RADIO() {
            return getToken(QLSParser.RADIO, 0);
        }

        public ArgListContext argList() {
            return getRuleContext(ArgListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_radioWidget;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitRadioWidget(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SpinboxWidgetContext extends ParserRuleContext {
        public SpinboxWidgetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SPINBOX() {
            return getToken(QLSParser.SPINBOX, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_spinboxWidget;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitSpinboxWidget(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SliderWidgetContext extends ParserRuleContext {
        public Token min;
        public Token max;

        public SliderWidgetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SLIDER() {
            return getToken(QLSParser.SLIDER, 0);
        }

        public List<TerminalNode> INT() {
            return getTokens(QLSParser.INT);
        }

        public TerminalNode INT(int i) {
            return getToken(QLSParser.INT, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sliderWidget;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitSliderWidget(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DropdownWidgetContext extends ParserRuleContext {
        public DropdownWidgetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DROPDOWN() {
            return getToken(QLSParser.DROPDOWN, 0);
        }

        public ArgListContext argList() {
            return getRuleContext(ArgListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dropdownWidget;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitDropdownWidget(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class StyleContext extends ParserRuleContext {
        public StyleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode CURLY_BRACE_L() {
            return getToken(QLSParser.CURLY_BRACE_L, 0);
        }

        public TerminalNode CURLY_BRACE_R() {
            return getToken(QLSParser.CURLY_BRACE_R, 0);
        }

        public List<WidgetPropertyContext> widgetProperty() {
            return getRuleContexts(WidgetPropertyContext.class);
        }

        public WidgetPropertyContext widgetProperty(int i) {
            return getRuleContext(WidgetPropertyContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_style;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitStyle(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ArgListContext extends ParserRuleContext {
        public ArgListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode BRACKET_L() {
            return getToken(QLSParser.BRACKET_L, 0);
        }

        public TerminalNode BRACKET_R() {
            return getToken(QLSParser.BRACKET_R, 0);
        }

        public List<TerminalNode> STR() {
            return getTokens(QLSParser.STR);
        }

        public TerminalNode STR(int i) {
            return getToken(QLSParser.STR, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(QLSParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(QLSParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_argList;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitArgList(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class TypeContext extends ParserRuleContext {
        public TypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TypeContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_type;
        }

        public void copyFrom(TypeContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class StringtypeContext extends TypeContext {
        public StringtypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode STRINGTYPE() {
            return getToken(QLSParser.STRINGTYPE, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitStringtype(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DatetypeContext extends TypeContext {
        public DatetypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode DATETYPE() {
            return getToken(QLSParser.DATETYPE, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitDatetype(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IntegertypeContext extends TypeContext {
        public IntegertypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode INTEGERTYPE() {
            return getToken(QLSParser.INTEGERTYPE, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitIntegertype(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MoneytypeContext extends TypeContext {
        public MoneytypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MONEYTYPE() {
            return getToken(QLSParser.MONEYTYPE, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitMoneytype(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DecimaltypeContext extends TypeContext {
        public DecimaltypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode DECIMALTYPE() {
            return getToken(QLSParser.DECIMALTYPE, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitDecimaltype(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BooltypeContext extends TypeContext {
        public BooltypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode BOOLEANTYPE() {
            return getToken(QLSParser.BOOLEANTYPE, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitBooltype(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DefaultdefContext extends ParserRuleContext {
        public DefaultdefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public BlockdefaultContext blockdefault() {
            return getRuleContext(BlockdefaultContext.class, 0);
        }

        public LinedefaultContext linedefault() {
            return getRuleContext(LinedefaultContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_defaultdef;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitDefaultdef(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BlockdefaultContext extends ParserRuleContext {
        public BlockdefaultContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DEFAULT() {
            return getToken(QLSParser.DEFAULT, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode CURLY_BRACE_L() {
            return getToken(QLSParser.CURLY_BRACE_L, 0);
        }

        public TerminalNode CURLY_BRACE_R() {
            return getToken(QLSParser.CURLY_BRACE_R, 0);
        }

        public List<WidgetPropertyContext> widgetProperty() {
            return getRuleContexts(WidgetPropertyContext.class);
        }

        public WidgetPropertyContext widgetProperty(int i) {
            return getRuleContext(WidgetPropertyContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_blockdefault;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitBlockdefault(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LinedefaultContext extends ParserRuleContext {
        public LinedefaultContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DEFAULT() {
            return getToken(QLSParser.DEFAULT, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public WidgetPropertyContext widgetProperty() {
            return getRuleContext(WidgetPropertyContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_linedefault;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitLinedefault(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class WidgetPropertyContext extends ParserRuleContext {
        public WidgetPropertyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public WidthpropertyContext widthproperty() {
            return getRuleContext(WidthpropertyContext.class, 0);
        }

        public FontpropertyContext fontproperty() {
            return getRuleContext(FontpropertyContext.class, 0);
        }

        public FontsizepropertyContext fontsizeproperty() {
            return getRuleContext(FontsizepropertyContext.class, 0);
        }

        public ColorpropertyContext colorproperty() {
            return getRuleContext(ColorpropertyContext.class, 0);
        }

        public WidgetContext widget() {
            return getRuleContext(WidgetContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_widgetProperty;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitWidgetProperty(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class WidthpropertyContext extends ParserRuleContext {
        public WidthpropertyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WIDTH() {
            return getToken(QLSParser.WIDTH, 0);
        }

        public TerminalNode COLON() {
            return getToken(QLSParser.COLON, 0);
        }

        public TerminalNode INT() {
            return getToken(QLSParser.INT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_widthproperty;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitWidthproperty(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FontpropertyContext extends ParserRuleContext {
        public FontpropertyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode FONT() {
            return getToken(QLSParser.FONT, 0);
        }

        public TerminalNode COLON() {
            return getToken(QLSParser.COLON, 0);
        }

        public TerminalNode STR() {
            return getToken(QLSParser.STR, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fontproperty;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitFontproperty(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FontsizepropertyContext extends ParserRuleContext {
        public FontsizepropertyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode FONTSIZE() {
            return getToken(QLSParser.FONTSIZE, 0);
        }

        public TerminalNode COLON() {
            return getToken(QLSParser.COLON, 0);
        }

        public TerminalNode INT() {
            return getToken(QLSParser.INT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fontsizeproperty;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitFontsizeproperty(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ColorpropertyContext extends ParserRuleContext {
        public ColorpropertyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode COLOR() {
            return getToken(QLSParser.COLOR, 0);
        }

        public TerminalNode COLON() {
            return getToken(QLSParser.COLON, 0);
        }

        public TerminalNode CLR() {
            return getToken(QLSParser.CLR, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_colorproperty;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitColorproperty(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ValueContext extends ParserRuleContext {
        public ValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode STR() {
            return getToken(QLSParser.STR, 0);
        }

        public TerminalNode INT() {
            return getToken(QLSParser.INT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_value;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLSVisitor) return ((QLSVisitor<? extends T>) visitor).visitValue(this);
            else return visitor.visitChildren(this);
        }
    }
}