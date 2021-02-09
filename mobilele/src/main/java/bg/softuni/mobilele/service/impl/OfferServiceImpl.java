package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.entities.OfferEntity;
import bg.softuni.mobilele.model.service.OfferServiceModel;
import bg.softuni.mobilele.model.view.OfferSummaryViewModel;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.security.CurrentUser;
import bg.softuni.mobilele.service.OfferService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

  private final CurrentUser currentUser;
  private final OfferRepository offerRepository;
  private final UserRepository userRepository;
  private final ModelRepository modelRepository;
  private final ModelMapper modelMapper;

  public OfferServiceImpl(CurrentUser currentUser,
      OfferRepository offerRepository,
      UserRepository userRepository,
      ModelRepository modelRepository,
      ModelMapper modelMapper) {
    this.currentUser = currentUser;
    this.offerRepository = offerRepository;
    this.userRepository = userRepository;
    this.modelRepository = modelRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<OfferSummaryViewModel> getAllOffers() {
    //TODO - implement mapping
    throw new UnsupportedOperationException("Comming soon :-)");
  }

  @Override
  public long save(OfferServiceModel model) {
    OfferEntity offerEntity = asNewEntity(model);
    OfferEntity newEntity = offerRepository.save(offerEntity);
    return newEntity.getId();
  }

  private OfferEntity asNewEntity(OfferServiceModel model) {
    OfferEntity offerEntity = new OfferEntity();
    modelMapper.map(model, offerEntity);
    offerEntity.setId(null);

    offerEntity.setModel(modelRepository.findById(model.getModelId()).orElseThrow());
    offerEntity.setUser(userRepository.findByUsername(currentUser.getName()).orElseThrow());

    return offerEntity;
  }
}
