/**
 * Represents a bond asset that can be bought and sold.
 */
public class Bond extends Asset {
  
  /** The principal amount of the bond. */
  private double principal;
  
  /** The interest rate of the bond. */
  private double interestRate;
  
  /** The number of bonds owned. */
  private double numberOwned;
  
  /**
   * Constructs a bond with the specified name, principal amount, and interest rate.
   * @param name the name of the bond
   * @param principal the principal amount of the bond
   * @param interestRate the interest rate of the bond
   */
  public Bond(String name, double principal, double interestRate) {
    super(name, 0);
    this.principal = principal;
    this.interestRate = interestRate;
    setCurrentPrice(principal);
  }
  
  /**
   * Gets the interest rate of the bond.
   * @return the interest rate of the bond
   */
  public double getInterestRate() {
    return interestRate;
  }
  
  /**
   * Sets the interest rate of the bond.
   * @param interestRate the new interest rate of the bond
   */
  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }
  
  /**
   * Gets the number of bonds owned.
   * @return the number of bonds owned
   */
  public double getNumberOwned() {
    return numberOwned;
  }
  
  /**
   * Sets the number of bonds owned.
   * @param numberOwned the new number of bonds owned
   */
  public void setNumberOwned(double numberOwned) {
    this.numberOwned = numberOwned;
  }
  
  /**
   * Gets the principal amount of the bond.
   * @return the principal amount of the bond
   */
  public double getPrincipal() {
    return principal;
  }
  
  /**
   * Calculates and returns the interest payment for the bond.
   * @return the interest payment for the bond
   */
  public double payInterest() {
    return getInterestRate() * getPrincipal();
  }
  
  /**
   * Buys a bond and updates the cost basis and number owned.
   * @return the current price of the bond
   */
  public double buy() {
    setCostBasis(getCurrentPrice() + getCostBasis());
    setNumberOwned(getNumberOwned() + 1);
    return getCurrentPrice();
  }
  
  /**
   * Sells a bond and updates the cost basis, capital gains, and number owned.
   * @return the current price of the bond
   */
  public double sell() {
    if (getNumberOwned() == 0) {
      return 0;
    } else {
      setCostBasis(getCostBasis() - (getCostBasis() / getNumberOwned()));
      setCapitalGains(getCurrentPrice() - getCostBasis());
      setNumberOwned(getNumberOwned() - 1);
      return getCurrentPrice();
    }
  }
}
