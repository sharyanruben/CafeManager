package cafemanagement.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RuBen on 27.03.2017.
 */
@Entity
@Table(name = "tables")
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "table_id")
    private int tableId;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "table_status")
    private int tableStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "table")
    private List<Order> orderList = new ArrayList<Order>();

    public Tables() {
    }

    public Tables(String tableName, byte tableStatus, User user) {
        this.tableName = tableName;
        this.tableStatus = tableStatus;
        this.user = user;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(int tableStatus) {
        this.tableStatus = tableStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tables)) return false;

        Tables tables = (Tables) o;

        if (getTableId() != tables.getTableId()) return false;
        if (getTableStatus() != tables.getTableStatus()) return false;
        if (getTableName() != null ? !getTableName().equals(tables.getTableName()) : tables.getTableName() != null)
            return false;
        return getUser() != null ? getUser().equals(tables.getUser()) : tables.getUser() == null;

    }

    @Override
    public int hashCode() {
        int result = getTableId();
        result = 31 * result + (getTableName() != null ? getTableName().hashCode() : 0);
        result = 31 * result + (int) getTableStatus();
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tables{" +
                "tableId=" + tableId +
                ", tableName='" + tableName + '\'' +
                ", tableStatus=" + tableStatus +
                ", user=" + user +
                '}';
    }
}
