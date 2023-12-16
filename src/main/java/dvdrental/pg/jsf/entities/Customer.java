package dvdrental.pg.jsf.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "customer")
@SqlResultSetMapping(name = "CustomerFullResults", entities = {
        @EntityResult(entityClass = Customer.class, fields = {
                @FieldResult(name = "id", column = "customer_id"),
                @FieldResult(name = "storeId", column = "store_id"),
                @FieldResult(name = "firstName", column = "first_name"),
                @FieldResult(name = "lastName", column = "last_name"),
                @FieldResult(name = "email", column = "email"),
                @FieldResult(name = "activeBool", column = "activebool"),
                @FieldResult(name = "createDate", column = "create_date"),
                @FieldResult(name = "lastUpdate", column = "customer_last_update")
        }),
        @EntityResult(entityClass = Address.class, fields = {
                @FieldResult(name = "id", column = "address_id"),
                @FieldResult(name = "address", column = "address"),
                @FieldResult(name = "address2", column = "address2"),
                @FieldResult(name = "district", column = "district"),
                @FieldResult(name = "postalCode", column = "postal_code"),
                @FieldResult(name = "phone", column = "phone"),
                @FieldResult(name = "lastUpdate", column = "address_last_update")
        }),
        @EntityResult(entityClass = City.class, fields = {
                @FieldResult(name = "id", column = "city_id"),
                @FieldResult(name = "city", column = "city"),
                @FieldResult(name = "lastUpdate", column = "city_last_update"),
        }),
        @EntityResult(entityClass = Country.class, fields = {
                @FieldResult(name = "id", column = "country_id"),
                @FieldResult(name = "country", column = "country"),
                @FieldResult(name = "lastUpdate", column = "country_last_update")
        })
})
@NamedNativeQuery(name = "findAllCustomersNative",
        query = NativeQueries.CUSTOMER_FULL_SQL,
        resultSetMapping = "CustomerFullResults"
)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;
    @Column(name = "store_id")
    private Integer storeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "activebool")
    private Boolean activeBool;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getActiveBool() {
        return activeBool;
    }

    public void setActiveBool(Boolean activeBool) {
        this.activeBool = activeBool;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getAddressLine() {
        return address.getPostalCode() + ", " +
                address.getCity().getCity() + ", " +
                address.getAddress() + ", " +
                address.getDistrict() + ", " +
                address.getCity().getCountry().getCountry();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", storeId=").append(storeId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", activeBool=").append(activeBool);
        sb.append(", createDate=").append(createDate);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
