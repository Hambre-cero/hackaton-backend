package co.programacionmaster.hambrecero.businessapi.service;

import co.programacionmaster.hambrecero.businessapi.model.File;
import javax.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FileQueries {

  @Nonnull
  Page<File> findByRecordId(String recordId, Pageable pageable);
}