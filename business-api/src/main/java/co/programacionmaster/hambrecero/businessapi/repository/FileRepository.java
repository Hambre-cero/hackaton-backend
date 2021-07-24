package co.programacionmaster.hambrecero.businessapi.repository;

import co.programacionmaster.hambrecero.businessapi.model.File;
import javax.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FileRepository {

  @Nonnull
  Page<File> findByRecordId(String recordId, Pageable pageable);
}