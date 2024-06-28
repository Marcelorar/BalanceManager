package com.marcelorar.software.tata.balancemanager.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Client
 */
@Entity
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-27T22:48:20.411121100-05:00[America/Guayaquil]", comments = "Generator version: 7.6.0")
public class Client implements GetAllClient200ResponseInner {

  private String name;

  /**
   * Gets or Sets gender
   */

  private Person.GenderEnum gender;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birthDate;

  private String identificationCode;

  private String address;

  private String phoneNumber;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer clientId;

  private String password;

  private Boolean isEnabled;

  @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, orphanRemoval = false)
  private List<Account> accounts = new ArrayList<>();

  public Client() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Client(String name, Person.GenderEnum gender, LocalDate birthDate, String identificationCode, String address, String phoneNumber) {
    this.name = name;
    this.gender = gender;
    this.birthDate = birthDate;
    this.identificationCode = identificationCode;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  public Client(Person person) {
    this.name = person.getName();
    this.gender = person.getGender();
    this.birthDate = person.getBirthDate();
    this.identificationCode = person.getIdentificationCode();
    this.address = person.getAddress();
    this.phoneNumber = person.getPhoneNumber();
  }


  public Client name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull
  @Schema(name = "name", example = "Carlos Garcia", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Client gender(Person.GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   *
   * @return gender
   */
  @Schema(name = "gender", example = "OTHER", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("gender")
  public Person.GenderEnum getGender() {
    return gender;
  }

  public void setGender(Person.GenderEnum gender) {
    this.gender = gender;
  }

  public Client birthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Get birthDate
   * @return birthDate
  */
  @NotNull @Valid
  @Schema(name = "birthDate", example = "Wed Jun 12 19:00:00 ECT 2024", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("birthDate")
  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Client identificationCode(String identificationCode) {
    this.identificationCode = identificationCode;
    return this;
  }

  /**
   * Get identificationCode
   * @return identificationCode
  */
  @NotNull @Pattern(regexp = "^\\d{10}$")
  @Schema(name = "identificationCode", example = "1720012573", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("identificationCode")
  public String getIdentificationCode() {
    return identificationCode;
  }

  public void setIdentificationCode(String identificationCode) {
    this.identificationCode = identificationCode;
  }

  public Client address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @NotNull
  @Schema(name = "address", example = "Calle A", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Client phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
  */
  @NotNull @Pattern(regexp = "^\\+?\\d{1,15}$")
  @Schema(name = "phoneNumber", example = "593999756112", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("phoneNumber")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Client clientId(Integer clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Get clientId
   * @return clientId
  */
  
  @Schema(name = "clientId", example = "2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clientId")
  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  public Client password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  
  @Schema(name = "password", example = "PassCode123", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Client isEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
    return this;
  }

  /**
   * Get isEnabled
   * @return isEnabled
  */
  
  @Schema(name = "isEnabled", example = "true", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    Client client = (Client) o;
    return Objects.equals(this.name, client.name) &&
        Objects.equals(this.gender, client.gender) &&
        Objects.equals(this.birthDate, client.birthDate) &&
        Objects.equals(this.identificationCode, client.identificationCode) &&
        Objects.equals(this.address, client.address) &&
        Objects.equals(this.phoneNumber, client.phoneNumber) &&
        Objects.equals(this.clientId, client.clientId) &&
        Objects.equals(this.password, client.password) &&
        Objects.equals(this.isEnabled, client.isEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, gender, birthDate, identificationCode, address, phoneNumber, clientId, password, isEnabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Client {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    identificationCode: ").append(toIndentedString(identificationCode)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    password: ").append("*").append("\n");
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

