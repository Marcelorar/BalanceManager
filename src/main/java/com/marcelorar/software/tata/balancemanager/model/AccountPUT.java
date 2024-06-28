package com.marcelorar.software.tata.balancemanager.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AccountPUT
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-27T22:48:20.411121100-05:00[America/Guayaquil]", comments = "Generator version: 7.6.0")
public class AccountPUT {

  private Client client;

  private String number;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    CHECKING("CHECKING"),
    
    SAVINGS("SAVINGS");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TypeEnum type;

  private String availableBalance;

  private Boolean isEnabled;

  public AccountPUT() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AccountPUT(Client client, TypeEnum type, String availableBalance, Boolean isEnabled) {
    this.client = client;
    this.type = type;
    this.availableBalance = availableBalance;
    this.isEnabled = isEnabled;
  }

  public AccountPUT client(Client client) {
    this.client = client;
    return this;
  }

  /**
   * Get clientId
   * @return clientId
  */
  @NotNull 
  @Schema(name = "clientId", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("clientId")
  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public AccountPUT number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  */
  
  @Schema(name = "number", example = "200012", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public AccountPUT type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull 
  @Schema(name = "type", example = "SAVINGS", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public AccountPUT availableBalance(String availableBalance) {
    this.availableBalance = availableBalance;
    return this;
  }

  /**
   * Get availableBalance
   * @return availableBalance
  */
  @NotNull @Pattern(regexp = "^(\\-|\\+)?((\\d+(\\.\\d*)?)|(\\.\\d+))$") 
  @Schema(name = "availableBalance", example = "100.23", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("availableBalance")
  public String getAvailableBalance() {
    return availableBalance;
  }

  public void setAvailableBalance(String availableBalance) {
    this.availableBalance = availableBalance;
  }

  public AccountPUT isEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
    return this;
  }

  /**
   * Get isEnabled
   * @return isEnabled
  */
  @NotNull 
  @Schema(name = "isEnabled", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("isEnabled")
  public Boolean getIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountPUT accountPUT = (AccountPUT) o;
    return Objects.equals(this.client, accountPUT.client) &&
        Objects.equals(this.number, accountPUT.number) &&
        Objects.equals(this.type, accountPUT.type) &&
        Objects.equals(this.availableBalance, accountPUT.availableBalance) &&
        Objects.equals(this.isEnabled, accountPUT.isEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(client, number, type, availableBalance, isEnabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountPUT {\n");
    sb.append("    clientId: ").append(toIndentedString(client)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    availableBalance: ").append(toIndentedString(availableBalance)).append("\n");
    sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
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

