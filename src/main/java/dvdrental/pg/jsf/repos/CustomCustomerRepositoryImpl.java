package dvdrental.pg.jsf.repos;

import dvdrental.pg.jsf.entities.Address;
import dvdrental.pg.jsf.entities.City;
import dvdrental.pg.jsf.entities.Country;
import dvdrental.pg.jsf.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class CustomCustomerRepositoryImpl implements CustomCustomerRepository {

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Customer> getAllCustomers() {
        final String sql = """
             select
                    c1_0.customer_id, c1_0.activebool, c1_0.create_date, c1_0.email, c1_0.first_name, c1_0.last_name,
                    c1_0.last_update as c1_0_last_update, c1_0.store_id,
                    a1_0.address_id, a1_0.address, a1_0.address2, a1_0.district, a1_0.last_update as a1_0_last_update,
                    a1_0.phone, a1_0.postal_code,
                    c2_0.city_id, c2_0.city, c2_0.last_update as c2_0_last_update, 
                    c3_0.country_id, c3_0.country, c3_0.last_update as c3_0_last_update
                from
                    customer c1_0
                left join
                    address a1_0
                        on a1_0.address_id=c1_0.address_id
                left join
                    city c2_0
                        on c2_0.city_id=a1_0.city_id
                left join
                    country c3_0
                        on c3_0.country_id=c2_0.country_id
                order by
                    c1_0.customer_id
            """;
        List<Object[]> resultSet = em.createNativeQuery(sql).getResultList();
        List<Customer> result = new ArrayList<>(resultSet.size());
        for (Object[] row : resultSet) {
            int i = 0;
            Country country = new Country();
            City city = new City();
            Address address = new Address();
            Customer customer = new Customer();

            customer.setId((Integer) row[i++]);
            customer.setActiveBool((Boolean) row[i++]);
            customer.setCreateDate((Date) row[i++]);
            customer.setEmail((String) row[i++]);
            customer.setFirstName((String) row[i++]);
            customer.setLastName((String) row[i++]);
            customer.setLastUpdate((Date) row[i++]);
            customer.setStoreId((Integer) row[i++]);
            address.setId((Integer) row[i++]);
            address.setAddress((String) row[i++]);
            address.setAddress2((String) row[i++]);
            address.setDistrict((String) row[i++]);
            address.setLastUpdate((Date) row[i++]);
            address.setPhone((String) row[i++]);
            address.setPostalCode((String) row[i++]);
            city.setId((Integer) row[i++]);
            city.setCity((String) row[i++]);
            city.setLastUpdate((Date) row[i++]);
            country.setId((Integer) row[i++]);
            country.setCountry((String) row[i++]);
            country.setLastUpdate((Date) row[i]);

            city.setCountry(country);
            address.setCity(city);
            customer.setAddress(address);
            result.add(customer);
        }
        return result;
    }
}
