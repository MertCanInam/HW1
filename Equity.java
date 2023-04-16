/**
 * Represents an equity asset that can be bought and sold.
 */
public class Equity extends Asset {
  
  /** The symbol of the equity. */
  private char symbol;
  
  /** The number of shares owned. */
  private double numberShares;
  
  /**
   * Constructs an equity with the specified name, symbol, and current price.
   * @param name the name of the equity
   * @param symbol the symbol of the equity
   * @param currentPrice the current price of the equity
   */
  public Equity(String name, char symbol, double currentPrice) {
    super(name, currentPrice);
    setCostBasis(0);
    this.symbol = symbol;
  }
  
  /**
   * Gets the number of shares owned.
   * @return the number of shares owned
   */
  public double getNumberShares() {
    return numberShares;
  }
  
  /**
   * Sets the number of shares owned.
   * @param numberShares the new number of shares owned
   */
  public void setNumberShares(double numberShares) {
    this.numberShares = numberShares;
  }
  
  /**
   * Gets the symbol of the equity.
   * @return the symbol of the equity
   */
  public char getSymbol() {
    return symbol;
  }
}
