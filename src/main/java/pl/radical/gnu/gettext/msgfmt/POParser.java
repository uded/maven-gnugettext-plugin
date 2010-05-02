package pl.radical.gnu.gettext.msgfmt;

import org.parboiled.BaseParser;
import org.parboiled.Rule;

/**
 * @author <a href="mailto:lukasz@radical.com.pl">Łukasz Rżanek</a>
 * @author Radical Creations &copy;2010
 */
public class POParser extends BaseParser<Object> {
	/**
	 * # translator-comments
	 * 
	 * @return
	 */
	public Rule TranslatorComments() {
		return  Sequence(
				"#  ",
				ZeroOrMore(Sequence(TestNot(CharSet("\r\n")), Any())),
				FirstOf("\r\n", '\r', '\n', Eoi())
		);
	}

	/**
	 * #. extracted-comments
	 * 
	 * @return
	 */
	public Rule ExtractedComments() {
		return  Sequence(
				"#. ",
				ZeroOrMore(Sequence(TestNot(CharSet("\r\n")), Any())),
				FirstOf("\r\n", '\r', '\n', Eoi())
		);
	}

	/**
	 * #: reference...
	 * 
	 * @return
	 */
	public Rule Reference() {
		return null;
	}

	/**
	 * #, flag...
	 * 
	 * @return
	 */
	public Rule Flag() {
		return null;
	}

	/**
	 * #| msgctxt previous-context
	 * 
	 * @return
	 */
	public Rule PreviousContext() {
		return null;
	}

	/**
	 * #| msgid previous-untranslated-string-singular
	 * 
	 * @return
	 */
	public Rule PreviousUntranslatedContext() {
		return null;
	}

	/**
	 * #| msgid_plural previous-untranslated-string-plural
	 * 
	 * @return
	 */
	public Rule PreviousPluralUntranslatedContext() {
		return null;
	}

	/**
	 * Whitespaces
	 * 
	 * @return
	 */
	public Rule Spacing() {
		return OneOrMore(CharSet("\t\r\n\f"));
	}
}
