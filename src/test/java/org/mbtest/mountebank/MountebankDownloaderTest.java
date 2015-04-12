package org.mbtest.mountebank;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MountebankDownloaderTest {
    @Test
    public void shouldGetUrlForOSXBinaryWhenOnOSX() throws IOException {
        System.setProperty("os.name", OS.OSX.getValue());

        Connection connection = mock(Connection.class);
        Document document = Jsoup.parse(new File("src/test/resources/mbtest.html"), "UTF-8");
        when(connection.get()).thenReturn(document);

        MountebankDownloader mountebankDownloader = new MountebankDownloader(connection);
        String binaryUrl = mountebankDownloader.getLatestBinaryUrl();

        assertThat(binaryUrl).isEqualTo("https://s3.amazonaws.com/mountebank/v1.2/mountebank-v1.2.56-darwin-x64.tar.gz");
    }
}