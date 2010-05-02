package pl.radical.gnu.gettext.msgfmt;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

import pl.radical.gnu.gettext.msgfmt.MsgFormat;

public class MsgFormatTest {
	public static final String NL = System.getProperty("line.separator");

	// @Test
	// public void testReadFile() {
	// Assert.fail("Not yet implemented");
	// }

	@Test
	public void testReadMessagess() {
		final String[][] results = {
				{"Test", "Test"},
				{
					"...neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
					"...nie ma zatem takiego człowieka, który kocha cierpienie samo w sobie, kto by do niego dążył lub chciał go doświadczyć, tylko dlatego, że jest to cierpienie, a dlatego, że czasami zdarzają się takie okoliczności, w których to cierpienie może doprowadzić go do jakiejś wielkiej przyjemności. Dając przykład banalny: któż z nas kiedyś nie podejmował się trudnego wysiłku fizycznego mając na względzie uzyskanie z tego korzyści? Kto ma jakiekolwiek prawo obwiniać człowieka, który wybiera przyjemność nie wiążącą się z przykrymi konsekwencjami, albo tego, kto unika takiego cierpienia, które nie prowadzi do przyjemności?"
				}
		};
		
		final String[] rawLines = {  
			"msgid \"Test\"", 
			"msgstr \"Test\"",
			"msgid \"...neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\"", 
			"msgstr \"...nie ma zatem takiego człowieka, który kocha cierpienie samo w sobie, kto by do niego dążył lub chciał go doświadczyć, tylko dlatego, że jest to cierpienie, a dlatego, że czasami zdarzają się takie okoliczności, w których to cierpienie może doprowadzić go do jakiejś wielkiej przyjemności. Dając przykład banalny: któż z nas kiedyś nie podejmował się trudnego wysiłku fizycznego mając na względzie uzyskanie z tego korzyści? Kto ma jakiekolwiek prawo obwiniać człowieka, który wybiera przyjemność nie wiążącą się z przykrymi konsekwencjami, albo tego, kto unika takiego cierpienia, które nie prowadzi do przyjemności?\"",
			"msgid \"\"",
			"\"...neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, \"",
			"\"consectetur, adipisci velit, sed quia non numquam eius modi tempora \"",
			"\"incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut \"",
			"\"enim ad minima veniam, quis nostrum exercitationem ullam corporis \"",
			"\"suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis \"",
			"\"autem vel eum iure reprehenderit qui in ea voluptate velit esse quam \"",
			"\"nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo \"",
			"\"voluptas nulla pariatur?\"",
			"msgstr \"\"",
			"\"...nie ma zatem takiego człowieka, który kocha cierpienie samo w \"",
			"\"sobie, kto by do niego dążył lub chciał go doświadczyć, tylko \"",
			"\"dlatego, że jest to cierpienie, a dlatego, że czasami zdarzają się \"",
			"\"takie okoliczności, w których to cierpienie może doprowadzić go do \"",
			"\"jakiejś wielkiej przyjemności. Dając przykład banalny: któż z nas \"",
			"\"kiedyś nie podejmował się trudnego wysiłku fizycznego mając na \"",
			"\"względzie uzyskanie z tego korzyści? Kto ma jakiekolwiek prawo \"",
			"\"obwiniać człowieka, który wybiera przyjemność nie wiążącą się z \"",
			"\"przykrymi konsekwencjami, albo tego, kto unika takiego cierpienia, \"",
			"\"które nie prowadzi do przyjemności?\""
		};
		final List<String> lines = new ArrayList<String>(rawLines.length);
		for (final String ln : rawLines) {
	        lines.add(ln);
        }

		final MsgFormat msgFormat = new MsgFormat();
		final TreeMap<String, String> messagess = new TreeMap<String, String>(msgFormat.readMessagess(lines));

		Entry<String, String> entry;
		
		entry = messagess.pollFirstEntry();
		Assert.assertEquals(results[0][0], entry.getKey());
		Assert.assertEquals(results[0][1], entry.getValue());
		
		entry = messagess.pollFirstEntry();
		Assert.assertEquals(results[1][0], entry.getKey());
		Assert.assertEquals(results[1][1], entry.getValue());

		entry = messagess.pollFirstEntry();
		Assert.assertEquals(results[1][0], entry.getKey());
		Assert.assertEquals(results[1][1], entry.getValue());
	}
}
