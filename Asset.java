
public class Asset {
  private String name; // the name of the asset
  private String description; // explanation for the asset
  private double costBasis; // real cost for asset
  private double currentPrice; // real cost of the asset for customer
  private double capitalGains; // real gains
  
  /**
   * Constructs a new Asset object with the given name and cost basis.
   * The capital gains for this asset are initialized to 0.
   * @param name the name of the asset.
   * @param costBasis the cost basis of the asset.
   */
  public Asset(String name, double costBasis) {
    this.name = name;
    this.costBasis = costBasis;
    this.capitalGains = 0;
    
  }
  
  /** 
   * Returns the name of the asset.
   * @return The name of the asset.
   */
  public String getName() {
    return name;
  }
  
  /**
   * Sets the name of the asset.
   * @param name The name of the asset.
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * 
   * Returns the explanation for the asset.
   * @return The description for the asset.
   */
  public String getDescription() {
    return description;
  }
  
  /**
   * Sets a brief description of the asset.
   * @param description a brief description of the asset
   */
  public void setDescription(String description) {
    this.description = description;
  }
  
  /**
   * Returns the original cost of the asset.
   * @return the original cost of the asset
   */
  public double getCostBasis() {
    return costBasis;
  }
  
  /**
   * Sets the original cost of the asset.
   * @param costBasis the original cost of the asset
   */
  public void setCostBasis(double costBasis) {
    this.costBasis = costBasis;
  }
  
  /**
   * Returns the current market value of the asset.
   * @return the current market value of the asset
   */
  public double getCurrentPrice() {
    return currentPrice;
  }
  
  /**
   * Sets the current market value of the asset and updates the current capital gains.
   * @param currentPrice the current market value of the asset
   */
  public void setCurrentPrice(double currentPrice) {
    this.currentPrice = currentPrice;
    this.capitalGains = this.currentPrice - this.costBasis;
  }
  
  /**
   * Returns the current capital gains on the asset.
   * @return the current capital gains on the asset
   */
  public double getCapitalGains() {
    return capitalGains;
  }
  
  /**
   * Sets the capital gains of the asset to the specified value.
   * @param capitalGains The new capital gains of the asset.
   */
  public void setCapitalGains(double capitalGains) {
    this.capitalGains = capitalGains;
  }
  
}
