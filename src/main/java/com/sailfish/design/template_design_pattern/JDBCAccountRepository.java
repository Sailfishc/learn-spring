package com.sailfish.design.template_design_pattern;

import com.sailfish.design.common.Account;
import com.sailfish.design.step03_di.AccountRepository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author sailfish
 * @create 2020-05-01-2:05 下午
 */
public class JDBCAccountRepository implements AccountRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void transfer(Account source, Account target) {

    }


    // spring use template design
    @Override
    public Account findByAccountId(Long accountId) {
        return jdbcTemplate.queryForObject("select id, name, amoount" + "from account where id=?", new RowMapper<Account>() {
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();
                account.setId(rs.getLong("id"));
                account.setName(rs.getString("name"));
                account.setAmount(rs.getString("amount"));
                return account;
            }
        }, accountId);
    }
}