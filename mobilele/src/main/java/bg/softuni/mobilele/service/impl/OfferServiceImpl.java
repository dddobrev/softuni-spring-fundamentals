package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.entities.OfferEntity;
import bg.softuni.mobilele.model.service.OfferServiceModel;
import bg.softuni.mobilele.model.view.OfferSummaryViewModel;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.service.OfferService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

  private final OfferRepository offerRepository;
  private final UserRepository userRepository;
  private final ModelRepository modelRepository;
  private final ModelMapper modelMapper;

  public OfferServiceImpl(OfferRepository offerRepository,
      UserRepository userRepository,
      ModelRepository modelRepository,
      ModelMapper modelMapper) {
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
  public long save(OfferServiceModel model, String userName) {
    OfferEntity offerEntity = asNewEntity(model, userName);
    OfferEntity newEntity = offerRepository.save(offerEntity);
    return newEntity.getId();
  }

  @Override
  public void delete(long id) {
    offerRepository.deleteById(id);
  }

  private OfferEntity asNewEntity(OfferServiceModel model, String userName) {
    OfferEntity offerEntity = new OfferEntity();
    modelMapper.map(model, offerEntity);
    offerEntity.setId(null);

    offerEntity.setModel(modelRepository.findById(model.getModelId()).orElseThrow());
    offerEntity.setUser(userRepository.findByUsername(userName).orElseThrow());

    return offerEntity;
  }
}
