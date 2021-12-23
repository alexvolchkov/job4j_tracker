package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает банковский сервис
 * @author ALEKSANDR VOLCHKOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей c привязанными к ним счетами
     * осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в систему
     * если он еще не присутствует в ней.
     * @param user пользователь, который добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход номер паспорта пользователя и его счет
     * и если счет еще не привязан к пользователю, то привязывает его.
     * @param passport номер паспорта пользователя
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод принимает на вход номер паспорта пользователя
     * и производит поиск пользователя в системе.
     * @param passport номер паспорта пользователя
     * @return возвращает найденного пользователя User или null если не найден.
     */
    public Optional<User> findByPassport(String passport) {
       return users.keySet()
               .stream()
               .filter(key -> passport.equals(key.getPassport()))
               .findFirst();
    }

    /**
     * Метод принимает на вход номер паспорта пользователя и реквизиты счета
     * и производит по ним поиск банковского счета.
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты банковского счета
     * @return возвращает найденный счет Account или null если не найден.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(account -> requisite.equals(account.getRequisite()))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод принимает на вход номера паспортов иреквизиты счетов пользователей
     * и производит перечисление денег с одного счета на другой.
     * Если счет не найден или не хватает средств платежь не совершается.
     * @param srcPassport номер паспорта пользователя плательщика
     * @param srcRequisite реквизиты банковского счета плательщика
     * @param destPassport номер паспорта пользователя получателя
     * @param destRequisite реквизиты банковского счета получателя
     * @return возвращает true если платеж прошел или false если нет.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            double srcBalance = srcAccount.get().getBalance();
            double destBalance = destAccount.get().getBalance();
            srcAccount.get().setBalance(srcBalance - amount);
            destAccount.get().setBalance(destBalance + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод принимает на вход пользователя и удаляет его из системы.
     * @param user пользователь, который удаляется из системы
     * @return возвращает true если удален пользователь или false если нет.
     */
    public boolean deleteUser(User user) {
        return users.remove(user) != null;
    }
}
