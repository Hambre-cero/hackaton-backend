package co.programacionmaster.hambrecero.business.repository;

import co.programacionmaster.hambrecero.business.persistence.model.FileJpa;
import co.programacionmaster.hambrecero.business.persistence.repository.FileJpaRepository;
import co.programacionmaster.hambrecero.businessapi.model.File;
import co.programacionmaster.hambrecero.businessapi.repository.FileRepository;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class FileRepositorySpringImpl implements FileRepository {

  private final FileJpaRepository fileJpaRepository;

  @Nonnull
  @Override
  public Page<File> findByRecordId(String recordId, Pageable pageable) {
    return fileJpaRepository.findByRecordId(recordId, pageable).map(FileJpa::narrow);
  }
}
