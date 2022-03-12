package com.cs527.web.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cs527.web.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> getList(){
        String sql = "SELECT *  FROM customer";
        return (List<Customer>) jdbcTemplate.query(sql, new RowMapper<Customer>(){

            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer cus = new Customer();
                cus.setCustomerID(rs.getInt("CustomerID"));
                cus.setCustomer_ContactName(rs.getString("Customer_ContactName"));
                cus.setCustomer_Phone(rs.getString("Customer_Phone"));
                cus.setCompanyName(rs.getString("CompanyName"));
                cus.setPlaceId(rs.getInt("PlaceId"));
                return cus;
            }

        });
    }
}