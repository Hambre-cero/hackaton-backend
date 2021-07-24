package co.programacionmaster.hambrecero.business.persistence.repository;

import co.programacionmaster.hambrecero.business.persistence.model.FileJpa;
import javax.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileJpaRepository extends JpaRepository<FileJpa, String> {

  @Nonnull
  Page<FileJpa> findByRecordId(String recordId, Pageable pageable);
}