package tika;

import org.apache.commons.lang.StringUtils;
import org.apache.tika.detect.Detector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.newInputStream;
import static java.text.MessageFormat.format;

public class TikaUtil {
    /**
     * Finds media type (through Apache Tika library), based on filename and magic numbers.
     *
     * @throws IOException
     */
    public static MediaType findMediaType(InputStream is, String fileName) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(is)) {
            AutoDetectParser parser = new AutoDetectParser();
            Detector detector = parser.getDetector();
            Metadata md = new Metadata();
            md.add(Metadata.RESOURCE_NAME_KEY, fileName);
            MediaType mediaType = detector.detect(bis, md);
            return mediaType;
        }
    }

    public static void main(String[] args) throws IOException {
        List<Meta> files = new ArrayList<>();
        files.add(new Meta("PDF", "C:\\Users\\naveenkumar.goudar\\Downloads\\Version3ReferenceModelGeneralI-Guide(FINAL) (1).pdf"));
        files.add(new Meta("TXT", "D:\\Naveen\\Features\\DU\\SampleLoans_FNMs\\DI Test Case - C01 - Fixed - Primary - Attached - BW - 05-2014.txt"));
        files.add(new Meta("FNM", "D:\\Naveen\\Features\\DU\\SampleLoans_FNMs\\6300034012 - VA - Cash out Refinacne - John Homeowner.fnm"));
        files.add(new Meta("DOCX", "D:\\Naveen\\Features\\DU\\SampleLoans_FNMs\\3.2 sarika.docx"));
        files.add(new Meta("CRT file", "C:\\Users\\naveenkumar.goudar\\Downloads\\sf-class2-root.crt"));
        files.add(new Meta("EXE file renamed to pdf", "C:\\Users\\naveenkumar.goudar\\Downloads\\visualvm.pdf"));
        files.add(new Meta("Doc", "D:\\Naveen\\Features\\DU\\SampleLoans_FNMs\\3.2 sarika.doc"));
        files.add(new Meta("PDF renamed to EXE", "C:\\Users\\naveenkumar.goudar\\Downloads\\Version3ReferenceModelGeneralI.exe"));
        files.add(new Meta("TIF", "C:\\Users\\naveenkumar.goudar\\Downloads\\FEBP-4589_1_.tif"));
        files.add(new Meta("EMF", "C:\\Users\\naveenkumar.goudar\\Downloads\\FEBP-4589_1_.emf"));
        files.add(new Meta("JPG", "C:\\Users\\naveenkumar.goudar\\Downloads\\FEBP-4589 (1).jpg"));
        files.add(new Meta("JPE", "C:\\Users\\naveenkumar.goudar\\Downloads\\FEBP-4589 (1).jpe"));
        files.add(new Meta("JPEG", "C:\\Users\\naveenkumar.goudar\\Downloads\\NG.jpeg"));
        files.add(new Meta("HTML", "C:\\Users\\naveenkumar.goudar\\Desktop\\blah.html"));
        files.add(new Meta("XPS", "C:\\Users\\naveenkumar.goudar\\Downloads\\Sample.xps"));
        files.add(new Meta("EMF file online converted", "C:\\Users\\naveenkumar.goudar\\Downloads\\FEBP-4589_1_ (1).emf"));
        files.stream().forEach(meta -> {
            String path = meta.path;
            String name = StringUtils.substring(path, StringUtils.lastIndexOf(path, "\\") + 1);
            InputStream is = null;
            try {
                is = newInputStream(Paths.get(path), StandardOpenOption.READ);
                MediaType mediaType = findMediaType(is, name);
                System.out.println(format("{0} --- {1}", meta.type, mediaType));
            } catch (IOException e) {
                System.out.println(format("Failed for {0}", meta.path));
            }
        });

        System.out.println("----------------------------------------------");
        System.out.println(MediaType.parse("text/plain"));
    }

    static class Meta {

        public String type;
        public String path;

        public Meta(String type, String path) {
            this.path = path;
            this.type = type;
        }
    }
}
