package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.FileUtils;
import utils.ZipUtils;

import static com.codeborne.selenide.Selenide.sleep;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


@Epic("QA.GURU automation course")
@Story("Zip File tests")
@Tag("zip")
class ZipFileTests {


    @Test
    void successfulZipFileCheck() {
        String source = "src/test/resources/files/files.zip";
        String destination = "src/test/resources/files/unzip";

        String expectedFileText = "Hello ugly world!";

        new ZipUtils().unzip(source, destination);
        sleep(10000);

        String actualFileText = new FileUtils().readStringFromFile("src/test/resources/files/unzip/file4.txt");
        System.out.println("Actual text from file: \n" + actualFileText);

        assertThat(actualFileText, containsString(expectedFileText));
    }


    @Test
    void successfulZipFileWithPasswordCheck() {
        String source = "src/test/resources/files/files_wp.zip";
        String destination = "src/test/resources/files/unzip_wp";
        String password = "utochka1";

        String expectedFileText = "Hello ugly world!";

        new ZipUtils().unzip(source, destination, password);
        sleep(10000);

        String actualFileText = new FileUtils().readStringFromFile("src/test/resources/files/unzip_wp/file4.txt");
        System.out.println("Actual text from file: \n" + actualFileText);

        assertThat(actualFileText, containsString(expectedFileText));
    }
}