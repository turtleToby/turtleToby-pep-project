package Service;

import Model.Account;
import DAO.AccountDAO;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAO();
    }

    public Account addAccount(Account account) {
        if (!account.getUsername().isEmpty() && account.getPassword().length() > 4 && accountDAO.getAccountByUsername(account.getUsername()) == null) {
            return accountDAO.insertAccount(account);
        }
        
        return null;
    }

    public Account getAccount(Account account) {
        return accountDAO.getAccount(account);
    }

    public boolean searchAccountExistsById(int id) {
        if (accountDAO.getAccountById(id) != null) {
            return true;
        }
        else {
            return false;
        }
    }
}