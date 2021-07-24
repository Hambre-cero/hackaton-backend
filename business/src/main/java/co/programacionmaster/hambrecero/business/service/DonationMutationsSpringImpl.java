package co.programacionmaster.hambrecero.business.service;

import co.programacionmaster.hambrecero.businessapi.repository.DonationRepository;
import co.programacionmaster.hambrecero.businessapi.service.DonationMutations;
import javax.annotation.ParametersAreNonnullByDefault;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class DonationMutationsSpringImpl implements DonationMutations {

  private final DonationRepository donationRepository;

}
