package hei.school.soratra.service;

import hei.school.soratra.endpoint.rest.models.FileUrls;
import hei.school.soratra.file.BucketComponent;
import hei.school.soratra.file.TextFileHandler;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SoratraService {
  private final TextFileHandler textFileHandler;
  private final BucketComponent bucketComponent;
  private final Duration URL_expiration = Duration.ofHours(1);

  public void save(String id, String text) throws IOException {
    File originalTextFile = textFileHandler.textToTXTFile(text);
    File transformedTextFile = textFileHandler.textToTXTFile(text.toUpperCase());
    bucketComponent.upload(originalTextFile, id);
    bucketComponent.upload(transformedTextFile, this.transformFileId(id));
  }

  public FileUrls getOne(String id) {
    String transformedFileId = this.transformFileId(id);
    String originalUrl = bucketComponent.presign(id, this.URL_expiration).toString();
    String transformedUrl =
        bucketComponent.presign(transformedFileId, this.URL_expiration).toString();

    return FileUrls.builder().original_url(originalUrl).transformed_url(transformedUrl).build();
  }

  private String transformFileId(String id) {
    return id + "-transformed";
  }
}
