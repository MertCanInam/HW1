totalcash
public class Customer {
  private String firstName;
  private String lastName;
  private Bond bond;
  private MutualFund mutualFund;
  private double totalCash;
  
  /**
   * 
   * Constructs a Customer object with the given bond, mutualfund, firstname,
   * lastname, and totalcash.
   * @param bond the bond owned by the customer
   * @param mutualFund the mutualfund owned by the customer
   * @param firstName the firstname of the customer
   * @param lastName the lastname of the customer
   * @param totalCash the totalcash owned by the customer
   */
  public Customer(Bond bond, MutualFund mutualFund, String firstName, String lastName, double totalCash) {
    this.bond = bond;
    this.mutualFund = mutualFund;
    this.firstName = firstName;
    this.lastName = lastName;
    this.totalCash = totalCash;
  }
  
  /**
   * Returns the first name of the customer.
   * @return the first name of the customer
   */
  public String getFirstName() {
    return firstName;
  }
  
  /**
   * Sets the first name of the customer to the given value.
   * @param firstName the new first name of the customer
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  /**
   * Returns the last name of the customer.
   * @return the last name of the customer
   */
  public String getLastName() {
    return lastName;
  }
  
  /**
   * Sets the last name of the customer to the given value.
   * @param lastName the new last name of the customer
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  /**
   * Returns the bond owned by the customer.
   * @return the bond owned by the customer
   */
  public Bond getBond() {
    return bond;
  }
  
  /**
   * Sets the bond owned by the customer to the given value.
   * @param bond the new bond owned by the customer
   */
  public void setBond(Bond bond) {
    this.bond = bond;
  }
  
  /**
   * Returns the mutual fund owned by the customer.
   * @return the mutual fund owned by the customer
   */
  public MutualFund getMutualFund() {
    return mutualFund;
  }
  
  /**
   * Sets the mutual fund owned by the customer to the given value.
   * @param mutualFund the new mutual fund owned by the customer
   */
  public void setMutualFund(MutualFund mutualFund) {
    this.mutualFund = mutualFund;
  }
  
  /**
   * Calculates the current value of the customer's portfolio, which is the sum of
   * the values of their bond and mutual fund holdings.
   * @return the current value of the customer's portfolio
   */
  public double currentValue() {
    if (this.mutualFund.getCurrentPrice() > 0 && this.bond.getNumberOwned() > 0
          || this.mutualFund.getNumberShares() > 0)
      return 0;
    else
      return (this.mutualFund.getCurrentPrice() * this.bond.getNumberOwned())
      + this.mutualFund.getNumberShares() * this.mutualFund.getCurrentPrice();
    
  }
  /**
   *Sets the total amount of cash for this object.
   *@param totalCash the new total amount of cash for this object
   */
  public void setTotalCash(double totalCash)
  {
    this.totalCash = totalCash;
  }
  /**
   * 
   Returns the total amount of cash for this object.
   @return the total amount of cash for this object
   */
  public double getTotalCash()
  {
    return totalCash;
  }
  
  /**
   * Calculates the total capital gains of the customer by adding the capital
   * gains of the mutual fund and bond investments. If either of the investments
   * has no capital gains, that investment is excluded from the calculation.
   * @return the total capital gains of the customer
   */
  public double getCapitalGains() {
    if (this.mutualFund.getCapitalGains() > 0 && this.bond.getCapitalGains() > 0)
      return 0;
    else
      return this.mutualFund.getCapitalGains() + this.bond.getCapitalGains();
  }
  
  /**
   * Sells a bond owned by the customer and updates the total cash accordingly.
   */
  public void sellBond() {
    this.bond.sell();
    totalCash += this.bond.sell();
    
  }
  
  /** 
   * Buys the Bond if the current price is less than or equal to the total cash
   * available for the customer.
   * @return true if the purchase is successful and false otherwise
   */
  public boolean buyBond() {
    if (this.bond.getCurrentPrice() > totalCash)
      return false;
    else {
      this.bond.buy();
      totalCash -= this.bond.buy();
      return true;
    }
  }
  
  /**
   * Withdraws a specified amount from the mutualfund and adds the proceeds to
   * the total cash of the customer.
   * @param input the amount to be withdrawn from the mutual fund
   */
  
  public void withdrawMutualFund(double input) {
    this.mutualFund.sell(input);
    totalCash += this.mutualFund.sell(input);
    
  }
  
  /**
   Buy a mutual fund with the given input amount.
   @param input the amount of money to use for buying the mutual fund
   @return true if the mutual fund is successfully bought, false otherwise
   */
  public boolean buyMutualFund(double input) {
    if (input > totalCash)
      return false;
    else {
      this.mutualFund.buy(input);
      totalCash -= this.mutualFund.buy(input);
      return true;
    }
    
  }
  
}
