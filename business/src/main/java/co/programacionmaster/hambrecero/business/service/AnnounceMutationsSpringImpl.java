package co.programacionmaster.hambrecero.business.service;

import co.programacionmaster.hambrecero.businessapi.repository.AnnounceRepository;
import co.programacionmaster.hambrecero.businessapi.service.AnnounceMutations;
import javax.annotation.ParametersAreNonnullByDefault;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class AnnounceMutationsSpringImpl implements AnnounceMutations {

  private final AnnounceRepository announceRepository;


}
