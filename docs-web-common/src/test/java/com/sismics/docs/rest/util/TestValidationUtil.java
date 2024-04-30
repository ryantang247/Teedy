package com.sismics.docs.rest.util;

import com.sismics.rest.exception.ClientException;
import com.sismics.rest.util.ValidationUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test the validations.
 *
 * @author jtremeaux 
 */
public class TestValidationUtil {
    @Test
    public void testValidateHttpUrlFail() throws Exception {
        ValidationUtil.validateHttpUrl("http://www.google.com", "url");
        ValidationUtil.validateHttpUrl("https://www.google.com", "url");
        ValidationUtil.validateHttpUrl(" https://www.google.com ", "url");
        try {
            ValidationUtil.validateHttpUrl("ftp://www.google.com", "url");
            Assert.fail();
        } catch (ClientException e) {
            // NOP
        }
        try {
            ValidationUtil.validateHttpUrl("http://", "url");
            Assert.fail();
        } catch (ClientException e) {
            // NOP
        }
    }

//    @Test
//    public void testFileToJsonObjectBuilder() throws IOException {
//        // Mock File object
//        File file = new File();
//        file.setId("fileId");
//        file.setName("testFile.txt");
//        file.setVersion(1);
//        file.setMimeType("text/plain");
//        file.setDocumentId("docId");
//        file.setCreateDate(new Date());
//
//        // Mock DirectoryUtil and FileUtil methods
//        DirectoryUtil directoryUtilMock = mock(DirectoryUtil.class);
//        FileUtil fileUtilMock = mock(FileUtil.class);
//        when(DirectoryUtil.getStorageDirectory()).thenReturn(Paths.get("storageDirectory"));
//        when(FileUtil.isProcessingFile("fileId")).thenReturn(true);
//        when(Files.size(any(Path.class))).thenReturn(100L);
//
//        // Call the method under test
//        JsonObjectBuilder jsonObjectBuilder = RestUtil.fileToJsonObjectBuilder(file);
//
//        // Verify the JSON structure
//        assertEquals(jsonObjectBuilder.build().get("id").toString(), "\"fileId\"");
//        assertEquals(jsonObjectBuilder.build().get("processing").toString(), "true");
//        assertEquals(jsonObjectBuilder.build().get("name").toString(), "\"testFile.txt\"");
//        assertEquals(jsonObjectBuilder.build().get("version").toString(), "1");
//        assertEquals(jsonObjectBuilder.build().get("mimetype").toString(), "\"text/plain\"");
//        assertEquals(jsonObjectBuilder.build().get("document_id").toString(), "\"docId\"");
//        assertEquals(jsonObjectBuilder.build().get("create_date").toString(), String.valueOf(file.getCreateDate().getTime()));
//        assertEquals(jsonObjectBuilder.build().get("size").toString(), "100");
//    }
}
