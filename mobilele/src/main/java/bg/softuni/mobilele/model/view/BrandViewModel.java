package bg.softuni.mobilele.model.view;

import java.util.List;

public class BrandViewModel {

  private String name;

  private List<ModelViewModel> models;

  public List<ModelViewModel> getModels() {
    return models;
  }

  public BrandViewModel setModels(
      List<ModelViewModel> models) {
    this.models = models;
    return this;
  }

  public String getName() {
    return name;
  }

  public BrandViewModel setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public String toString() {
    return "BrandViewModel{" +
        "name='" + name + '\'' +
        ", models=" + models +
        '}';
  }
}
