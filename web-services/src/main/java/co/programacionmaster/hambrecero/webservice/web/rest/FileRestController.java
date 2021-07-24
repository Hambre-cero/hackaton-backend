package co.programacionmaster.hambrecero.webservice.web.rest;

import co.programacionmaster.hambrecero.businessapi.model.File;
import co.programacionmaster.hambrecero.businessapi.service.FileQueries;
import co.programacionmaster.hambrecero.webservice.config.responses.SuccessResponse;
import co.programacionmaster.hambrecero.webservice.model.FileResource;
import io.vavr.collection.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * File rest controller.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/files")
public class FileRestController {

  private final FileQueries fileQueries;

  /**
   * Find {@link File}s by Record identifier.
   */
  @GetMapping("/by-record-id/{recordId}")
  public SuccessResponse<List<FileResource>> findByRecordId(
      @PathVariable(value = "recordId") String recordId,
      Pageable pageable
  ) {
    Page<FileResource> response = fileQueries
        .findByRecordId(recordId, pageable)
        .map(FileResource::from);

    return new SuccessResponse(
        response.getContent(),
        response.getSize(),
        response.getTotalElements(),
        response.getTotalPages(),
        response.getNumberOfElements(),
        response.getNumber()
    );
  }
}