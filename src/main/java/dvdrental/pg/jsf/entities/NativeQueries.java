package dvdrental.pg.jsf.entities;

public interface NativeQueries {

     String CUSTOMER_FULL_SQL = """
             select
                    c1_0.customer_id, c1_0.activebool, c1_0.create_date, c1_0.email, c1_0.first_name, c1_0.last_name,
                    c1_0.last_update as customer_last_update, c1_0.store_id,
                    a1_0.address_id, a1_0.address, a1_0.address2, a1_0.district, a1_0.last_update as address_last_update,
                    a1_0.phone, a1_0.postal_code,
                    c2_0.city_id, c2_0.city, c2_0.last_update as city_last_update,
                    c3_0.country_id, c3_0.country, c3_0.last_update as country_last_update
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
}
