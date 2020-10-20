package util;

import java.text.MessageFormat;
import static java.nio.charset.Charset.defaultCharset;
import java.text.MessageFormat;

import exception.NaveenRuntimeException;
import org.apache.commons.io.IOUtils;

public class FileUtil {
	public static String fromFile(String path) {
		try {
			return IOUtils.toString(FileUtil.class.getResourceAsStream(path), defaultCharset());
		} catch (Exception e) {
			throw new NaveenRuntimeException(MessageFormat.format("Exception while reading contents of file {0}", path), e);
		}
	}
}
