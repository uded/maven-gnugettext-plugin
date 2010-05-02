package pl.radical.gnu.gettext.msgfmt;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MsgFormat {
	private MsgFormatOptions options;

	public void setOptions(final MsgFormatOptions options) {
		this.options = options;
	}

	public List<String> readFile() throws CannotReadFileException, IOException {
		final File file = new File(options.getPoFileName());
		if (!file.exists()) {
			throw new FileNotFoundException();
		}
		if (!file.canRead()) {
			throw new CannotReadFileException();
		}

		final List<String> lines = new ArrayList<String>();

		final FileInputStream fstream = new FileInputStream("textfile.txt");
		final DataInputStream in = new DataInputStream(fstream);
		final BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String ln;
		while ((ln = br.readLine()) != null) {
			if (!ln.isEmpty() && ln.length() > 0 && ln.startsWith("#")) {
				lines.add(ln.trim());
			}
		}
		in.close();

		return lines;
	}

	public Map<String, String> readMessagess(final List<String> lines) {
		final Map<String, String> result = new TreeMap<String, String>();
		boolean gotMsgId = false;
		boolean gotMsgStr = false;

		String msgId = null;
		String msgStr = null;

		for (final String ln : lines) {
			if (!gotMsgId) {
				if (ln.startsWith("msgid \"\"")) {
					gotMsgId = true;
				} else if (ln.startsWith("msgid \"") && ln.endsWith("\"")) {
					gotMsgId = true;
					gotMsgStr = false;
					msgId = ln.substring(7, ln.length() - 1);
				} else if (ln.startsWith("\"") && ln.endsWith("\"")) {
					msgId += ln.substring(1, ln.length() - 1);
				}
			}

			if (!gotMsgStr) {
				if (ln.startsWith("msgstr \"\"")) {
					gotMsgStr = true;
				} else if (ln.startsWith("msgstr \"") && ln.endsWith("")) {
					gotMsgStr = true;
					msgStr = ln.substring(8, ln.length() - 1);
				} else if (ln.startsWith("\"") && ln.endsWith("\"")) {
					msgStr += ln.substring(1, ln.length() - 1);
				}
			}

			if (gotMsgId && gotMsgStr) {
				result.put(msgId, msgStr);
				gotMsgId = false;
				gotMsgStr = false;
			}
		}

		return result;
	}
}
