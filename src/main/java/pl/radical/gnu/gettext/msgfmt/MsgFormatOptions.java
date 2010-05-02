package pl.radical.gnu.gettext.msgfmt;

import java.util.Locale;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

public class MsgFormatOptions {
	@Option(name = "-l", required = true)
	private Locale locale;

	@Argument(index = 1, required = true)
	private String poFileName;

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(final Locale locale) {
		this.locale = locale;
	}

	public String getPoFileName() {
		return poFileName;
	}

	public void setPoFileName(final String poFileName) {
		this.poFileName = poFileName;
	}

}
