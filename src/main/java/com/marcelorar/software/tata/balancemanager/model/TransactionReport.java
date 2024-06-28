package com.marcelorar.software.tata.balancemanager.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TransactionReport
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-28T04:11:16.530160300-05:00[America/Guayaquil]", comments = "Generator version: 7.6.0")
public class TransactionReport implements GetTransactionsByDateByClient200ResponseInner {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime date;

  private String name;

  private String account;

  /**
   * Gets or Sets accountType
   */
  public enum AccountTypeEnum {
    CHECKING("CHECKING"),
    
    SAVINGS("SAVINGS");

    private String value;

    AccountTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AccountTypeEnum fromValue(String value) {
      for (AccountTypeEnum b : AccountTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private AccountTypeEnum accountType;

  private String lastBalance;

  /**
   * Gets or Sets operation
   */
  public enum OperationEnum {
    CREDIT("CREDIT"),
    
    DEBIT("DEBIT");

    private String value;

    OperationEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OperationEnum fromValue(String value) {
      for (OperationEnum b : OperationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private OperationEnum operation;

  private String issuedAmount;

  private String currentBalance;

  public TransactionReport date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @Valid 
  @Schema(name = "date", example = "2024-06-13T19:19:56Z", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public TransactionReport name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", example = "Carlos Garcia", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TransactionReport account(String account) {
    this.account = account;
    return this;
  }

  /**
   * Get account
   * @return account
  */
  
  @Schema(name = "account", example = "200012", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("account")
  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public TransactionReport accountType(AccountTypeEnum accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * Get accountType
   * @return accountType
  */
  
  @Schema(name = "accountType", example = "SAVINGS", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accountType")
  public AccountTypeEnum getAccountType() {
    return accountType;
  }

  public void setAccountType(AccountTypeEnum accountType) {
    this.accountType = accountType;
  }

  public TransactionReport lastBalance(String lastBalance) {
    this.lastBalance = lastBalance;
    return this;
  }

  /**
   * Get lastBalance
   * @return lastBalance
  */
  @Pattern(regexp = "^(\\-|\\+)?((\\d+(\\.\\d*)?)|(\\.\\d+))$") 
  @Schema(name = "lastBalance", example = "100.23", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastBalance")
  public String getLastBalance() {
    return lastBalance;
  }

  public void setLastBalance(String lastBalance) {
    this.lastBalance = lastBalance;
  }

  public TransactionReport operation(OperationEnum operation) {
    this.operation = operation;
    return this;
  }

  /**
   * Get operation
   * @return operation
  */
  
  @Schema(name = "operation", example = "DEBIT", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("operation")
  public OperationEnum getOperation() {
    return operation;
  }

  public void setOperation(OperationEnum operation) {
    this.operation = operation;
  }

  public TransactionReport issuedAmount(String issuedAmount) {
    this.issuedAmount = issuedAmount;
    return this;
  }

  /**
   * Get issuedAmount
   * @return issuedAmount
  */
  @Pattern(regexp = "^(\\-|\\+)?((\\d+(\\.\\d*)?)|(\\.\\d+))$") 
  @Schema(name = "issuedAmount", example = "100.23", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("issuedAmount")
  public String getIssuedAmount() {
    return issuedAmount;
  }

  public void setIssuedAmount(String issuedAmount) {
    this.issuedAmount = issuedAmount;
  }

  public TransactionReport currentBalance(String currentBalance) {
    this.currentBalance = currentBalance;
    return this;
  }

  /**
   * Get currentBalance
   * @return currentBalance
  */
  @Pattern(regexp = "^(\\-|\\+)?((\\d+(\\.\\d*)?)|(\\.\\d+))$") 
  @Schema(name = "currentBalance", example = "100.23", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentBalance")
  public String getCurrentBalance() {
    return currentBalance;
  }

  public void setCurrentBalance(String currentBalance) {
    this.currentBalance = currentBalance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionReport transactionReport = (TransactionReport) o;
    return Objects.equals(this.date, transactionReport.date) &&
        Objects.equals(this.name, transactionReport.name) &&
        Objects.equals(this.account, transactionReport.account) &&
        Objects.equals(this.accountType, transactionReport.accountType) &&
        Objects.equals(this.lastBalance, transactionReport.lastBalance) &&
        Objects.equals(this.operation, transactionReport.operation) &&
        Objects.equals(this.issuedAmount, transactionReport.issuedAmount) &&
        Objects.equals(this.currentBalance, transactionReport.currentBalance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, name, account, accountType, lastBalance, operation, issuedAmount, currentBalance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionReport {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    lastBalance: ").append(toIndentedString(lastBalance)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    issuedAmount: ").append(toIndentedString(issuedAmount)).append("\n");
    sb.append("    currentBalance: ").append(toIndentedString(currentBalance)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

