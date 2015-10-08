package file_function;

import junit.framework.TestCase;

/**
 * Created by Maksim Rylkin on 08.10.2015.
 * В качестве тестового файла используется funcs.txt Результирующий фаул будет создан в той же директории
 */
public class ConsoleAppTest extends TestCase {

    public void testMain() throws Exception {
        ConsoleApp consoleApp = new ConsoleApp();
        consoleApp.main(new String[]{"src/test/resources/file/funcs.txt"});
    }
}