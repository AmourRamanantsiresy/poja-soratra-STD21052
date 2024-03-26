package hei.school.soratra.endpoint.rest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FileUrls implements Serializable {
    private String original_url;
    private String transformed_url;
}
