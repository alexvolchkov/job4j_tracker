package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User key : users.keySet()) {
            if (passport.equals(key.getPassport())) {
                user = key;
                break;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = null;
        Account destAccount = null;
        if (findByPassport(srcPassport) != null) {
            srcAccount = findByRequisite(srcPassport, srcRequisite);
        }
        if (findByPassport(destPassport) != null) {
            destAccount = findByRequisite(destPassport, destRequisite);
        }
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            double srcBalance = srcAccount.getBalance();
            double destBalance = destAccount.getBalance();
            srcAccount.setBalance(srcBalance - amount);
            destAccount.setBalance(destBalance + amount);
            rsl = true;
        }
        return rsl;
    }

    public boolean deleteUser(User user) {
        return users.remove(user) != null;
    }
}
