package testreplace;

import java.text.ParseException;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 25.01.2016.
 */
public class SystemNameConverter implements Callable<String> {
    private String path;

    public SystemNameConverter(String path) {
        this.path = path;
    }

    @Override
    public String call() throws Exception {

        System.out.println(path);

        String nPath =  path.substring(2);

        String[] strPathParts = nPath.split("\\\\");

        StringBuilder builder = new StringBuilder("\\");

        for (String name : strPathParts) {
            builder.append("\\");
            builder.append(convertToSystem(name));
        }

        return builder.toString();
    }

    public String convertToSystem(String pathElement) throws ParseException
    {
        if( pathElement != null && pathElement.length() > 0 )
        {
            //replace characters according to mapping tables UNI_UNICODE and WIN_UNICODE
            for (int i = 0; i < UNI_UNICODE.length; i++)
            {
                pathElement = pathElement.replace(UNI_UNICODE[i], WIN_UNICODE[i]);
            }
        }
        return pathElement;
    }

    private static final char[] DISPLAYCHARS = {
            '%', '_', '\''
    };

    private static final String[] MACHINECHARS = {
            "^25", "^94", "^39"
    };

    protected static final char[] WIN_UNICODE = {
            0xf001, 0xf002, 0xf003, 0xf004, 0xf005,
            0xf006, 0xf007, 0xf008, 0xf009, 0xf00a,
            0xf00b, 0xf00c, 0xf00d, 0xf00e, 0xf00f,
            0xf010, 0xf011, 0xf012, 0xf013, 0xf014,
            0xf015, 0xf016, 0xf017, 0xf018, 0xf019,
            0xf01a, 0xf01b, 0xf01c, 0xf01d, 0xf01e,
            0xf020, 0xf021, 0xf022, 0xf023, 0xf024,
            0xf025, 0xf026, 0xf027,
            0xf02a
    };

    /**
     * Characters that normally cannot be included in filenames (such as "\\", "*" or "/") are mapped to the private
     * Unicode area by Windows. <code>UNI_UNICODE</code> contains those chars that are mapped by the help of
     * {@link #WIN_UNICODE}.
     * Current map is just a copy of the map that NTFSPathConverterImpl uses, except '.', because this is a supported char
     * on samba volumes.
     */
    protected static final char[] UNI_UNICODE = {
            0x0001, 0x0002, 0x0003, 0x0004, 0x0005,
            0x0006, 0x0007, 0x0008, 0x0009, 0x000a,
            0x000b, 0x000c, 0x000d, 0x000e, 0x000f,
            0x0010, 0x0011, 0x0012, 0x0013, 0x0014,
            0x0015, 0x0016, 0x0017, 0x0018, 0x0019,
            0x001a, 0x001b, 0x001c, 0x001d, 0x001e,
            '\"', '*', '/', '<', '>',
            '?', '\\', '|',
            0xf8ff
    };
}
