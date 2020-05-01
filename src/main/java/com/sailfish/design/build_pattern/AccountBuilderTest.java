package com.sailfish.design.build_pattern;

/**
 * @author sailfish
 * @create 2020-05-01-7:27 下午
 */
public class AccountBuilderTest {


    public static void main(String[] args) {
        Account account = new Account.AccountBuilder("Saving            Account", "Dinesh Rajput", 1111l).balance(38458.32).interest(4.5).type("SAVING").build();
        System.out.println(account);
    }
}
