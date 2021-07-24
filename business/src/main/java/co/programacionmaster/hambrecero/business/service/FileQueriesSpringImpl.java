package co.programacionmaster.hambrecero.business.service;

import co.programacionmaster.hambrecero.businessapi.model.File;
import co.programacionmaster.hambrecero.businessapi.repository.FileRepository;
import co.programacionmaster.hambrecero.businessapi.service.FileQueries;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class FileQueriesSpringImpl implements FileQueries {

  private final FileRepository fileRepository;

  @Nonnull
  @Override
  public Page<File> findByRecordId(String recordId, Pageable pageable) {
    return fileRepository.findByRecordId(recordId, pageable);
  }
}
