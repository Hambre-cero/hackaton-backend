package co.programacionmaster.hambrecero.business.service;

import co.programacionmaster.hambrecero.businessapi.model.Donation;
import co.programacionmaster.hambrecero.businessapi.repository.AnnounceRepository;
import co.programacionmaster.hambrecero.businessapi.repository.DonationRepository;
import co.programacionmaster.hambrecero.businessapi.service.DonationMutations;
import co.programacionmaster.hambrecero.commons.exception.ResourceNotFoundException;
import co.programacionmaster.hambrecero.commons.utils.MessageUtils;
import co.programacionmaster.hambrecero.iamapi.repository.UserRepository;
import io.vavr.control.Try;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class DonationMutationsSpringImpl implements DonationMutations {

  private final DonationRepository donationRepository;
  private final AnnounceRepository announceRepository;
  private final UserRepository userRepository;
  private final MessageSource messageSource;

  @Nonnull
  @Override
  public Try<Donation> create(Donation donation) {
    return Try.of(() -> {
      announceRepository
          .find(donation.getAnnounceId())
          .getOrElseThrow(() -> new ResourceNotFoundException(MessageUtils
              .getMessage(messageSource, "error.business.announce_not_found",
                  donation.getAnnounceId())));

      userRepository
          .find(donation.getDonorId())
          .getOrElseThrow(() -> new ResourceNotFoundException(MessageUtils
              .getMessage(messageSource, "error.business.donor_not_found", donation.getDonorId())));

      return donationRepository.create(donation).get();
    });
  }
}
