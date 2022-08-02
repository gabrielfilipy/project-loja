package Model;

import java.util.List;

public class Stocks {
    
    private User user;
    private Provider provider;
    private Department department;
    private Stock stock;
    private List<Stocks> list;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Stocks> getList() {
        return list;
    }

    public void setList(List<Stocks> list) {
        this.list = list;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
}
