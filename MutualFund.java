/**
 * Represents a mutual fund equity asset that can be bought and sold.
 */
public class MutualFund extends Equity {
  
  /** The load, or sales charge, for buying shares of the mutual fund. */
  private double load;
  
  /**
   * Constructs a mutual fund with the specified name, symbol, and current price.
   * @param name the name of the mutual fund
   * @param symbol the symbol of the mutual fund
   * @param currentPrice the current price of the mutual fund
   */
  public MutualFund(String name, char symbol, double currentPrice) {
    super(name, symbol, currentPrice);
  }
  
  /**
   * Gets the load, or sales charge, for buying shares of the mutual fund.
   * @return the load for buying shares of the mutual fund
   */
  public double getLoad() {
    return load;
  }
  
  /**
   * Sets the load, or sales charge, for buying shares of the mutual fund.
   * @param load the new load for buying shares of the mutual fund
   */
  public void setLoad(double load) {
    this.load = load;
  }
  
  /**
   * Buys the specified dollar amount of shares of the mutual fund.
   * @param input the dollar amount to invest
   * @return the dollar amount invested
   */
  public double buy(double input) {
    if (input < 0) {
      return 0;
    } else {
      setNumberShares(getNumberShares() + (input * (100 - load) / getCurrentPrice()));
      return input;
    }
  }
  
  /**
   * Sells the specified dollar amount of shares of the mutual fund.
   * @param input the dollar amount to sell
   * @return the dollar amount received from the sale
   */
  public double sell(double input) {
    if (input < 0 || input > getCurrentPrice() * getNumberShares()) {
      return 0;
    } else {
      setNumberShares(getNumberShares() - (input / getCurrentPrice()));
      setCostBasis(getCostBasis() * (getNumberShares() - (input / getCurrentPrice()) / getNumberShares()));
      setCapitalGains(getCapitalGains() + (input - getCostBasis()));
      return input;
    }
  }
  
}
