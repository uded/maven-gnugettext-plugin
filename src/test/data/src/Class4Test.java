import org.xnap.commons.i18n.I18n;
import org.xnap.commons.i18n.I18nFactory;

public class Class4Test {
	private final I18n i18n = I18nFactory.getI18n(getClass());

	public void method() {
		i18n.tr("Test");

		i18n.tr("...neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?");
		
		i18n.tr("...neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, " +
				"consectetur, adipisci velit, sed quia non numquam eius modi tempora " +
				"incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim" +
				" ad minima veniam, quis nostrum exercitationem ullam corporis suscipit " +
				"laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel " +
				"eum iure reprehenderit qui in ea voluptate velit esse quam nihil " +
				"molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas " +
				"nulla pariatur?");
	}
}
