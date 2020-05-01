package com.sailfish.design.template_design_pattern.basic;

import com.sailfish.design.common.Account;
import com.sailfish.design.step03_di.AccountRepository;

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

    private DataSource dataSource;

    @Override
    public void transfer(Account source, Account target) {

    }

    @Override
    public Account findByAccountId(Long accountId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("select id, name, amount from " + "account where id=?");
            stmt.setLong(1, accountId);
            rs = stmt.executeQuery();
            Account account = null;
            if (rs.next()) {
                account = new Account();
                account.setId(rs.getLong("id"));
                account.setName(rs.getString("name"));
                account.setAmount(rs.getString("amount"));
            }
            return account;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {

                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return null;
    }
}