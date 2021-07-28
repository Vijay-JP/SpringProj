package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;

@Entity
@Table
@NamedNativeQuery(
	    name = "find_unique_investments",
    query =
            "SELECT "
                    + "i.portal as portal, sum(i.amount) as amount "
                    + "from INVESTMENTS i group by i.portal",
    resultSetMapping = "unique_investments"
)
@SqlResultSetMapping(
    name = "unique_investments",
    classes = @ConstructorResult(
            targetClass = UniqueInvestments.class,
            columns = {
                    @ColumnResult(name = "portal", type = String.class),
                    @ColumnResult(name = "amount", type = Float.class)
            }
    )
)
public class Investments {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long investment_id;
    @Column
    public String portal;
    @Column
    public String investment_date;
    @Column
    public float amount;
    
    public long getInvestment_id() {
        return investment_id;
    }
    public void setInvestment_id(long investment_id) {
        this.investment_id = investment_id;
    }
    public String getPortal() {
        return portal;
    }
    public void setPortal(String portal) {
        this.portal = portal;
    }
    public String getInvestment_date() {
        return investment_date;
    }
    public void setInvestment_date(String investment_date) {
        this.investment_date = investment_date;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    
}